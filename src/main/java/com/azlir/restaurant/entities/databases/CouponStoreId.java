package com.azlir.restaurant.entities.databases;

import org.hibernate.Hibernate;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class CouponStoreId implements Serializable {
  @Serial private static final long serialVersionUID = -5958370723231658982L;

  private UUID couponId;

  private UUID storeId;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    CouponStoreId entity = (CouponStoreId) o;
    return Objects.equals(this.couponId, entity.couponId)
        && Objects.equals(this.storeId, entity.storeId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(couponId, storeId);
  }
}
