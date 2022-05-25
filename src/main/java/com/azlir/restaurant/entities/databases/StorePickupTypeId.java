package com.azlir.restaurant.entities.databases;

import com.azlir.restaurant.entities.enums.PickupType;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class StorePickupTypeId implements Serializable {
  @Serial private static final long serialVersionUID = 1094767933656307387L;

  @Column(name = "store_id", nullable = false)
  private UUID storeId;

  @Column(name = "pickup_type", columnDefinition = "pickup_type_enum not null")
  private PickupType pickupType;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    StorePickupTypeId entity = (StorePickupTypeId) o;
    return Objects.equals(this.storeId, entity.storeId)
        && Objects.equals(this.pickupType, entity.pickupType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(storeId, pickupType);
  }
}
