package org.example.testovoe.service;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.testovoe.dto.SubscriptionsDTO;
import org.example.testovoe.dto.UserDTO;
import org.example.testovoe.entity.UsersEntity;
import org.example.testovoe.exception.NotFoundUser;
import org.example.testovoe.mapper.GenericMapper;
import org.example.testovoe.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsersService {
  private final UsersRepository usersRepository;

  private final GenericMapper<UserDTO, UsersEntity> genericMapper;

  private static final Logger log = LoggerFactory.getLogger(UsersService.class);


  public void createUser(UserDTO userDTO) {
    UsersEntity savedUser = usersRepository.save(new UsersEntity(userDTO.getName()));
    log.info("Добавлен юзер: {}", savedUser.getName());
  }

  @Transactional(readOnly = true)
  public UserDTO getUser(Integer id) {
    log.info("Поиск юзера с id: {}", id);
    return genericMapper.toDto(usersRepository.findById(id).orElseThrow(() -> new NotFoundUser(id)));
  }

  @Transactional
  public UserDTO updateUser(Integer id, UserDTO userDTO) {
    log.info("Обновление юзера с id: {} и именем: {}", id, userDTO.getName());
    UsersEntity usersEntity = usersRepository.findById(id).orElseThrow(() -> new NotFoundUser(id));
    usersEntity.setName(userDTO.getName());
    return genericMapper.toDto(usersEntity);
  }

  public void deleteUser(Integer id) {
    log.info("Удаление юзера с id: {}", id);
    usersRepository.deleteById(id);
  }



}
