package com.azlir.restaurant.entities.databases;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "item_category_l10ns")
public class ItemCategoryL10n {
  @EmbeddedId private ItemCategoryL10nId id;

  @MapsId("categoryId")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "category_id", nullable = false)
  private ItemCategory category;

  @Column(name = "name", nullable = false, length = 64)
  private String name;
}
