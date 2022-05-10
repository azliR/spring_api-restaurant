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
@Table(name = "item_addons")
public class ItemAddon {
  @Id
  @Column(name = "id", nullable = false)
  private UUID id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "addon_category_id", nullable = false)
  private ItemAddonCategory addonCategory;

  @Column(name = "name", nullable = false, length = 64)
  private String name;

  @Column(name = "price", nullable = false, precision = 11, scale = 2)
  private BigDecimal price;
}
