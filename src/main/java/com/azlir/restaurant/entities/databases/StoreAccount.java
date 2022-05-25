package com.azlir.restaurant.entities.databases;

import com.azlir.restaurant.entities.enums.StoreRole;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "store_accounts")
public class StoreAccount {
  @Id
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "full_name", nullable = false, length = 64)
  private String storeId;

  @Column(name = "role", columnDefinition = "store_role_enum not null")
  private StoreRole role;

  @Column(name = "created_at", nullable = false)
  private Instant createdAt;
}
