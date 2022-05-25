package com.azlir.restaurant.entities.databases;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "items")
public class Item {
  @Id
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "store_id", nullable = false)
  private UUID storeId;

  @Column(name = "category_id", nullable = false)
  private UUID categoryId;

  @Column(name = "sub_category_id")
  private UUID subCategoryId;

  @Column(name = "name", nullable = false, length = 64)
  private String name;

  @Column(name = "picture")
  private String picture;

  @Column(name = "price", nullable = false, precision = 11, scale = 2)
  private BigDecimal price;

  @Column(name = "special_offer", nullable = false, precision = 11, scale = 2)
  private BigDecimal specialOffer;

  @Column(name = "description")
  private String description;

  @Column(name = "is_active", nullable = false)
  private Boolean isActive = false;
}
