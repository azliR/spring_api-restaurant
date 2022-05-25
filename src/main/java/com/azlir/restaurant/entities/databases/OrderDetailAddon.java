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
@Table(name = "order_detail_addons")
public class OrderDetailAddon {
  @Id
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "order_detail_id", nullable = false)
  private UUID orderDetailId;

  @Column(name = "addon_id", nullable = false)
  private UUID addon;

  @Column(name = "addon_name", nullable = false, length = 64)
  private String addonName;

  @Column(name = "price", nullable = false, precision = 11, scale = 2)
  private BigDecimal price;
}
