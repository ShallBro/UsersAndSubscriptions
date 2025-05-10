package org.example.testovoe.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UsersEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  public UsersEntity(String name) {
    this.name = name;
  }

  @OneToMany(mappedBy = "users", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  private List<SubscriptionsEntity> subscriptionsEntities;

  public UsersEntity() {

  }
}
