package org.example.testovoe.mapper;

import java.util.List;
import org.example.testovoe.dto.SubscriptionsDTO;
import org.example.testovoe.entity.SubscriptionsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubscriptionsMapper extends GenericMapper<SubscriptionsDTO, SubscriptionsEntity> {

  @Override
  @Mapping(target = "name", source = "subscriptionsEntity.name")
  SubscriptionsDTO toDto(SubscriptionsEntity subscriptionsEntity);

  @Override
  List<SubscriptionsDTO> toDtoList(List<SubscriptionsEntity> subscriptionsEntities);
}
