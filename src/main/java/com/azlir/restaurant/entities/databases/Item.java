package com.azlir.restaurant.entities.databases;

import lombok.*;

import javax.persistence.*;
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

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "store_id", nullable = false)
  private Store store;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "category_id", nullable = false)
  private ItemCategory category;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "sub_category_id")
  private ItemSubCategory subCategory;

  @Column(name = "name", nullable = false, length = 64)
  private String name;

  @Lob
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
