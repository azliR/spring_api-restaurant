package com.azlir.restaurant.entities.databases;

import com.azlir.restaurant.entities.enums.PickupType;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Enumerated;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Embeddable
public class StorePickupTypeId implements Serializable {
  private static final long serialVersionUID = 7253671040359481910L;

  @Column(name = "store_id", nullable = false)
  private UUID storeId;

  @Column(name = "pickup_type", columnDefinition = "pickup_type_enum not null")
  @Enumerated
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
