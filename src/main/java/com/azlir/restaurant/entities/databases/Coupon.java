package com.azlir.restaurant.entities.databases;

import com.azlir.restaurant.entities.enums.DiscountType;
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
@Table(name = "coupons")
public class Coupon {
  @Id
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "inserted_by", nullable = false)
  private UUID insertedBy;

  @Column(name = "coupon_code", nullable = false, length = 16)
  private String couponCode;

  @Column(name = "name", nullable = false, length = 64)
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "expiry_date", nullable = false)
  private Instant expiryDate;

  @Column(name = "discount_type", columnDefinition = "discount_type_enum not null")
  private DiscountType discountType;

  @Column(name = "discount", nullable = false, precision = 11, scale = 2)
  private BigDecimal discount;

  @Column(name = "min_total", nullable = false, precision = 11, scale = 2)
  private BigDecimal minTotal;

  @Column(name = "max_discount", nullable = false, precision = 11, scale = 2)
  private BigDecimal maxDiscount;

  @Column(name = "max_number_use_total")
  private Integer maxNumberUseTotal;

  @Column(name = "max_number_use_customer", nullable = false)
  private Integer maxNumberUseCustomer;

  @Column(name = "created_at", nullable = false)
  private Instant createdAt;

  @Column(name = "all_store", nullable = false)
  private Boolean allStore = false;

  @Column(name = "all_customer", nullable = false)
  private Boolean allCustomer = false;

  @Column(name = "is_valid", nullable = false)
  private Boolean isValid = false;
}
