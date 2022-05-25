package com.azlir.restaurant.entities.databases;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "store_staffs")
public class StoreStaff {
  @Id
  @Column(name = "store_account_id", nullable = false)
  private UUID id;

  @MapsId
  @OneToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "store_account_id", nullable = false)
  private StoreAccount storeAdminId;

  @Column(name = "store_id", nullable = false)
  private UUID store;

  @Column(name = "username", nullable = false, length = 36)
  private String username;

  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "is_locked", nullable = false)
  private Boolean isLocked = false;
}
