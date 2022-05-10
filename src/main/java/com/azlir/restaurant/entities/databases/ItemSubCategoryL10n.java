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
@Table(name = "item_sub_category_l10ns")
public class ItemSubCategoryL10n {
  @EmbeddedId private ItemSubCategoryL10nId id;

  @MapsId("subCategoryId")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "sub_category_id", nullable = false)
  private ItemSubCategory subCategory;

  @Column(name = "name", nullable = false, length = 64)
  private String name;
}
