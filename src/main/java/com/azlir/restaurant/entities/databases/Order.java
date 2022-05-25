package com.azlir.restaurant.entities.databases;

import com.azlir.restaurant.entities.enums.OrderStatus;
import com.azlir.restaurant.entities.enums.OrderType;
import com.azlir.restaurant.entities.enums.PickupType;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "orders")
public class Order {
  @Id
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "customer_id", nullable = false)
  private UUID customerId;

  @Column(name = "store_id", nullable = false)
  private UUID storeId;

  @Column(name = "store_account_id")
  private UUID storeAccountId;

  @Column(name = "table_id")
  private UUID tableId;

  @Column(name = "coupon_id")
  private UUID couponId;

  @Column(name = "buyer", nullable = false, length = 64)
  private String buyer;


  @Column(name = "store_image")
  private String storeImage;


  @Column(name = "store_banner")
  private String storeBanner;

  @Column(name = "table_price", precision = 11, scale = 2)
  private BigDecimal tablePrice;

  @Column(name = "brutto", nullable = false, precision = 11, scale = 2)
  private BigDecimal brutto;

  @Column(name = "netto", nullable = false, precision = 11, scale = 2)
  private BigDecimal netto;

  @Column(name = "coupon_code", length = 16)
  private String couponCode;

  @Column(name = "coupon_name", length = 64)
  private String couponName;

  @Column(name = "discount", precision = 11, scale = 2)
  private BigDecimal discount;

  @Column(name = "discount_nominal", nullable = false, precision = 11, scale = 2)
  private BigDecimal discountNominal;

  @Column(name = "status", columnDefinition = "order_status_enum not null")
  private OrderStatus status;

  @Column(name = "order_type", columnDefinition = "order_type_enum not null")
  private OrderType orderType;

  @Column(name = "scheduled_at")
  private Instant scheduledAt;

  @Column(name = "pickup_type", columnDefinition = "pickup_type_enum not null")
  private PickupType pickupType;

  @Column(name = "rating", precision = 2, scale = 1)
  private BigDecimal rating;

  @Column(name = "comment")
  private String comment;

  @Column(name = "created_at", nullable = false)
  private Instant createdAt;
}
