package org.example.testovoe.repository;

import java.util.List;
import java.util.UUID;
import org.example.testovoe.entity.SubscriptionsEntity;
import org.example.testovoe.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionsRepository extends JpaRepository<SubscriptionsEntity, Integer> {
  List<SubscriptionsEntity> findSubscriptionsEntitiesByUsers(UsersEntity usersEntity);

  @Query("SELECT s.name FROM SubscriptionsEntity s GROUP BY s.name ORDER BY count(*) DESC LIMIT 3")
  List<String> topSubscriptions();
}
