package com.azlir.restaurant.repositories;

import com.azlir.restaurant.entities.databases.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import java.util.Optional;
import java.util.UUID;

public interface StoreRepository extends JpaRepository<Store, UUID> {

  @Query(
      value =
          "SELECT stores.*,\n"
              + "    postcodes.city,\n"
              + "    postcodes.state,\n"
              + "    postcodes.country\n"
              + "FROM stores\n"
              + "    JOIN postcodes ON stores.postcode = postcodes.postcode\n"
              + "WHERE stores.id = :id",
      nativeQuery = true)
  @Override
  @NonNull
  Optional<Store> findById(@NonNull UUID id);
}
