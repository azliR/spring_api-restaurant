package com.azlir.restaurant.entities.databases;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "stores")
public class Store {
  @Id
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "store_admin_id", nullable = false)
  private UUID storeAdminId;

  @Column(name = "name", nullable = false, length = 64)
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "image")
  private String image;

  @Column(name = "banner")
  private String banner;

  @Column(name = "phone", nullable = false, length = 16)
  private String phone;

  @Column(name = "street_address", nullable = false)
  private String streetAddress;

  @Column(name = "postcode", nullable = false)
  private String postcode;

  @Column(name = "latitude", nullable = false)
  private Double latitude;

  @Column(name = "longitude", nullable = false)
  private Double longitude;

  @Column(name = "rating", precision = 2, scale = 1)
  private BigDecimal rating;

  @Column(name = "is_active", nullable = false)
  private Boolean isActive = false;

  private String city;

  private String state;

  private String country;
}
