package org.example.testovoe.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "subscriptions")
@Getter
@Setter
public class SubscriptionsEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  public SubscriptionsEntity(String name, UsersEntity users) {
    this.name = name;
    this.users = users;
  }

  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private UsersEntity users;

  public SubscriptionsEntity() {

  }
}
