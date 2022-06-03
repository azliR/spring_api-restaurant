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
@Table(name = "item_sub_category_l10ns")
@IdClass(ItemSubCategoryL10nId.class)
public class ItemSubCategoryL10n {
  @Id
  @Column(name = "sub_category_id", nullable = false)
  private UUID subCategoryId;

  @Id
  @Column(name = "language_code", nullable = false, length = 2)
  private String languageCode;

  @Column(name = "name", nullable = false, length = 64)
  private String name;

  private String translatedName;
}
