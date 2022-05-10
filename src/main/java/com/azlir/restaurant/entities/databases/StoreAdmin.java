package com.azlir.restaurant.entities.databases;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "store_admins")
public class StoreAdmin {
  @Id
  @Column(name = "store_account_id", nullable = false)
  private UUID id;

  @MapsId
  @OneToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "store_account_id", nullable = false)
  private StoreAccount storeAccounts;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "token_reset_password")
  private String tokenResetPassword;

  @Column(name = "token_expired_at")
  private Instant tokenExpiredAt;

  @Column(name = "last_updated_password")
  private Instant lastUpdatedPassword;
}
