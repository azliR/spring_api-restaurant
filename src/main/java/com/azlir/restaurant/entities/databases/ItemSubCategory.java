package com.azlir.restaurant.entities.databases;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
public class ItemSubCategory {
  @Id
  @Column(name = "sub_category_id", nullable = false)
  private UUID subCategoryId;

  @Column(name = "language_code", nullable = false, length = 2)
  private String languageCode;

  @Column(name = "name", nullable = false, length = 64)
  private String name;

  private String translatedName;
}
