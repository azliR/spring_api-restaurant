package com.azlir.restaurant.entities.databases;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "customers")
public class Customer {
  @Id
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "full_name", nullable = false, length = 64)
  private String fullName;

  @Column(name = "phone", nullable = false, length = 16)
  private String phone;

  @Column(name = "language_code", nullable = false, length = 2)
  private String languageCode;

  @Column(name = "created_at", nullable = false)
  private Instant createdAt;
}
