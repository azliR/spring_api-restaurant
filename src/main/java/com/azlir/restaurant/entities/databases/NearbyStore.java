package com.azlir.restaurant.entities.databases;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
public class NearbyStore {
  @Id private UUID id;

  private UUID storeAdminId;

  private String name;

  private String description;

  private String image;

  private String banner;

  private String phone;

  private String streetAddress;

  private String postcode;

  private Double latitude;

  private Double longitude;

  private BigDecimal rating;

  private Boolean isActive = false;

  private Double distance;

  private String city;

  private String state;

  private String country;
}
