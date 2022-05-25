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
@Table(name = "item_category_l10ns")
@IdClass(ItemCategoryL10nId.class)
public class ItemCategoryL10n {
  @Id
  @Column(name = "category_id", nullable = false)
  private UUID categoryId;

  @Id
  @Column(name = "language_code", nullable = false, length = 2)
  private String languageCode;

  @Column(name = "name", nullable = false, length = 64)
  private String name;
}
