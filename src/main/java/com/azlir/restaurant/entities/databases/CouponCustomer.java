package com.azlir.restaurant.entities.databases;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "coupon_customers")
@IdClass(CouponCustomerId.class)
public class CouponCustomer implements Serializable {
  @Id
  @Column(name = "coupon_id", nullable = false)
  private UUID couponId;

  @Id
  @Column(name = "customer_id", nullable = false)
  private UUID customerId;
}
