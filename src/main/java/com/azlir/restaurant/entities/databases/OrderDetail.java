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
@Table(name = "order_details")
public class OrderDetail {
  @Id
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "order_id", nullable = false)
  private UUID orderId;

  @Column(name = "item_id", nullable = false)
  private UUID itemId;

  @Column(name = "item_name", nullable = false, length = 64)
  private String itemName;

  @Column(name = "quantity", nullable = false)
  private Integer quantity;

  @Column(name = "price", nullable = false, precision = 11, scale = 2)
  private BigDecimal price;

  @Column(name = "total", nullable = false, precision = 11, scale = 2)
  private BigDecimal total;

  @Column(name = "picture")
  private String picture;

  @Column(name = "item_detail")
  private String itemDetail;
}
