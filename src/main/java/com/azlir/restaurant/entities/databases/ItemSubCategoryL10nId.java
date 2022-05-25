package com.azlir.restaurant.entities.databases;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class ItemSubCategoryL10nId implements Serializable {
  @Serial private static final long serialVersionUID = -8980925095903048184L;

  @Column(name = "sub_category_id", nullable = false)
  private UUID subCategoryId;

  @Column(name = "language_code", nullable = false, length = 2)
  private String languageCode;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    ItemSubCategoryL10nId entity = (ItemSubCategoryL10nId) o;
    return Objects.equals(this.subCategoryId, entity.subCategoryId)
        && Objects.equals(this.languageCode, entity.languageCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subCategoryId, languageCode);
  }
}
