package com.azlir.restaurant.entities.databases;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "postcodes")
public class Postcode {
  @Id
  @Column(name = "postcode", nullable = false, length = 5)
  private String id;

  @Column(name = "city", nullable = false, length = 128)
  private String city;

  @Column(name = "state", nullable = false, length = 128)
  private String state;

  @Column(name = "country", nullable = false, length = 56)
  private String country;
}
