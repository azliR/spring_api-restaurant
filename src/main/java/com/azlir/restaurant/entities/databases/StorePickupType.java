package com.azlir.restaurant.entities.databases;

import com.azlir.restaurant.entities.enums.PickupType;
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
@Table(name = "store_pickup_types")
@IdClass(StorePickupTypeId.class)
public class StorePickupType {
  @Id
  @Column(name = "store_id", nullable = false)
  private UUID storeId;

  @Id
  @Column(name = "pickup_type", columnDefinition = "pickup_type_enum not null")
  private PickupType pickupType;
}
