package com.azlir.restaurant.entities.databases;

import org.hibernate.Hibernate;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class CouponCustomerId implements Serializable {
  @Serial private static final long serialVersionUID = -5103779780285702899L;

  private UUID couponId;
  private UUID customerId;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    CouponCustomerId entity = (CouponCustomerId) o;
    return Objects.equals(this.customerId, entity.customerId)
        && Objects.equals(this.couponId, entity.couponId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerId, couponId);
  }
}
