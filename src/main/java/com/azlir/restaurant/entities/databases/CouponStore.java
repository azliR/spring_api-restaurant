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
@Table(name = "coupon_stores")
@IdClass(CouponStoreId.class)
public class CouponStore {
  @Id
  @Column(name = "coupon_id", nullable = false)
  private UUID couponId;

  @Id
  @Column(name = "store_id", nullable = false)
  private UUID storeId;
}
