package com.azlir.restaurant.entities.dtos;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Data
public class StoreDto implements Serializable {
  private final UUID id;
  private final UUID storeAdminId;
  private final String name;
  private final String description;
  private final String image;
  private final String banner;
  private final String phone;
  private final String streetAddress;
  private final String postcode;
  private final Double latitude;
  private final Double longitude;
  private final BigDecimal rating;
  private final Boolean isActive;
}
