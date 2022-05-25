package com.azlir.restaurant.repositories;

import com.azlir.restaurant.entities.databases.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ItemRepository extends JpaRepository<Item, UUID> {
  @Query(
      value =
          "SELECT *\n"
              + "FROM items\n"
              + "WHERE store_id = :storeId\n"
              + "    AND sub_category_id = :subCategoryId\n"
              + "ORDER BY (\n"
              + "        CASE\n"
              + "            WHEN special_offer IS NOT NULL THEN special_offer\n"
              + "            ELSE price\n"
              + "        END\n"
              + "    )\n"
              + "LIMIT :pageLimit OFFSET :pageOffset",
      nativeQuery = true)
  @NonNull
  List<Item> getItemsByStoreId(
      @NonNull UUID storeId,
      @NonNull UUID subCategoryId,
      @NonNull int pageLimit,
      @NonNull int pageOffset);

  @Query(
      value =
          "SELECT *\n"
              + "FROM items\n"
              + "WHERE store_id = :storeId\n"
              + "ORDER BY (\n"
              + "        CASE\n"
              + "            WHEN special_offer IS NOT NULL THEN special_offer\n"
              + "            ELSE price\n"
              + "        END\n"
              + "    )\n"
              + "LIMIT :pageLimit OFFSET :pageOffset",
      nativeQuery = true)
  @NonNull
  List<Item> getItemsByStoreId(
      @NonNull UUID storeId, @NonNull int pageLimit, @NonNull int pageOffset);

  @Query(
      value =
          "SELECT items.*\n"
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
              + "    ) nearby_stores,\n"
              + "    items\n"
              + "WHERE nearby_stores.distance <= 5\n"
              + "    AND items.store_id = nearby_stores.id\n"
              + "    AND items.special_offer IS NOT NULL\n"
              + "ORDER BY distance\n"
              + "LIMIT :pageLimit OFFSET :pageOffset",
      nativeQuery = true)
  @NonNull
  List<Item> getSpecialOfferItems(
      @NonNull double latitude,
      @NonNull double longitude,
      @NonNull int pageLimit,
      @NonNull int pageOffset);

  @Query(value = "SELECT *\n" + "FROM items\n" + "WHERE id = :id", nativeQuery = true)
  @Override
  @NonNull
  Optional<Item> findById(@NonNull UUID id);
}
