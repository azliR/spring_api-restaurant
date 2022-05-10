package com.azlir.restaurant.entities.databases;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "store_pickup_types")
public class StorePickupType {
  @EmbeddedId private StorePickupTypeId id;

  @MapsId("storeId")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "store_id", nullable = false)
  private Store store;
}
