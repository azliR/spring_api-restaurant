package com.azlir.restaurant.entities.databases;

import org.hibernate.Hibernate;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class ItemCategoryL10nId implements Serializable {
  @Serial private static final long serialVersionUID = 7975086358000141075L;

  private UUID categoryId;

  private String languageCode;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    ItemCategoryL10nId entity = (ItemCategoryL10nId) o;
    return Objects.equals(this.languageCode, entity.languageCode)
        && Objects.equals(this.categoryId, entity.categoryId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(languageCode, categoryId);
  }
}
