package org.example.testovoe.service;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.testovoe.dto.SubscriptionsDTO;
import org.example.testovoe.dto.UserDTO;
import org.example.testovoe.entity.SubscriptionsEntity;
import org.example.testovoe.entity.UsersEntity;
import org.example.testovoe.exception.NotFoundUser;
import org.example.testovoe.mapper.GenericMapper;
import org.example.testovoe.repository.SubscriptionsRepository;
import org.example.testovoe.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SubscriptionsService {
  private static final Logger log = LoggerFactory.getLogger(SubscriptionsService.class);

  private final UsersRepository usersRepository;

  private final SubscriptionsRepository subscriptionsRepository;

  private final GenericMapper<SubscriptionsDTO, SubscriptionsEntity> genericMapper;

  @Transactional
  public void addSubscription(Integer idUser, SubscriptionsDTO subscriptionsDTO) {
    log.info("Поиск юзера с id: {}", idUser);
    UsersEntity users = getUser(idUser);
    log.info("Добавление подписки пользователю с id: {}", users.getId());
    subscriptionsRepository.save(new SubscriptionsEntity(subscriptionsDTO.getName(), users));
  }
  @Transactional(readOnly = true)
  public List<SubscriptionsDTO> getSubscription(int idUser) {
     log.info("Получение подписок пользователя юзера с id: {}", idUser);
     return genericMapper.toDtoList(subscriptionsRepository.findSubscriptionsEntitiesByUsers(getUser(idUser)));
  }

  public void deleteSubscription(int idSubscription) {
    log.info("Удаление подписки с id: {}", idSubscription);
    subscriptionsRepository.deleteById(idSubscription);
  }

  public List<String> topSubscriptions() {
    log.info("Получение топ 3 популярных подписок");
    return subscriptionsRepository.topSubscriptions();
  }


  private UsersEntity getUser(Integer idUser) {
    return usersRepository.findById(idUser).orElseThrow(() -> new NotFoundUser(idUser));
  }

}
