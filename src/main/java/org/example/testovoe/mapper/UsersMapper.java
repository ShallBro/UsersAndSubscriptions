package org.example.testovoe.mapper;

import org.example.testovoe.dto.UserDTO;
import org.example.testovoe.entity.UsersEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsersMapper extends GenericMapper<UserDTO, UsersEntity> {
  @Override
  @Mapping(target = "name", source = "usersEntity.name")
  UserDTO toDto(UsersEntity usersEntity);
}
