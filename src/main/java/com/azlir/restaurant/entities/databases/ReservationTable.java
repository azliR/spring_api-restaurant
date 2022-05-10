package com.azlir.restaurant.entities.databases;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "reservation_tables")
public class ReservationTable {
  @Id
  @Column(name = "id", nullable = false)
  private UUID id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "store_id", nullable = false)
  private Store store;

  @Column(name = "name", nullable = false, length = 64)
  private String name;

  @Column(name = "max_person", nullable = false)
  private Integer maxPerson;

  @Column(name = "book_price", nullable = false, precision = 11, scale = 2)
  private BigDecimal bookPrice;
}
