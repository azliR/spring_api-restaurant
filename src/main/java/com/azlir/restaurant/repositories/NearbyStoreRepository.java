package com.azlir.restaurant.repositories;

import com.azlir.restaurant.entities.databases.NearbyStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.UUID;

public interface NearbyStoreRepository extends JpaRepository<NearbyStore, UUID> {
  @Query(
      value =
          "SELECT nearby_stores.*,\n"
              + "    postcodes.city,\n"
              + "    postcodes.state,\n"
              + "    postcodes.country\n"
              + "FROM (\n"
              + "        SELECT *,\n"
              + "            (\n"
              + "                6371 * acos(\n"
              + "                    cos(radians(:latitude)) * cos(radians(latitude)) * cos(\n"
              + "                        radians(longitude) - radians(:longitude)\n"
              + "                    ) + sin(radians(:latitude)) * sin(radians(latitude))\n"
              + "                )\n"
              + "            ) AS distance\n"
              + "        FROM stores\n"
              + "    ) nearby_stores\n"
              + "    LEFT JOIN postcodes ON nearby_stores.postcode = postcodes.postcode\n"
              + "WHERE distance <= 5\n"
              + "ORDER BY distance\n"
              + "LIMIT :pageLimit OFFSET :pageOffset",
      nativeQuery = true)
  @NonNull
  List<NearbyStore> getNearbyStores(
      @NonNull double latitude,
      @NonNull double longitude,
      @NonNull int pageLimit,
      @NonNull int pageOffset);
}
