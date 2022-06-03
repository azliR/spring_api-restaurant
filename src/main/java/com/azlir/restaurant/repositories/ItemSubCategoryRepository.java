package com.azlir.restaurant.repositories;

import com.azlir.restaurant.entities.databases.ItemSubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.UUID;

public interface ItemSubCategoryRepository extends JpaRepository<ItemSubCategory, UUID> {
  @Query(
      value =
          "SELECT item_sub_categories.id,\n"
              + "    item_sub_category_l10ns.language_code,\n"
              + "    item_sub_categories.name AS name,\n"
              + "    item_sub_category_l10ns.name AS translated_name\n"
              + "FROM item_sub_categories\n"
              + "    LEFT JOIN item_sub_category_l10ns ON item_sub_categories.id = item_sub_category_l10ns.sub_category_id\n"
              + "    AND item_sub_category_l10ns.language_code = :languageCode\n"
              + "WHERE item_sub_categories.store_id = :storeId\n"
              + "    AND (\n"
              + "        SELECT COUNT(*)\n"
              + "        FROM items\n"
              + "        WHERE items.sub_category_id = item_sub_categories.id\n"
              + "    ) > 0\n"
              + "ORDER BY (\n"
              + "        CASE\n"
              + "            WHEN item_sub_category_l10ns.name IS NOT NULL THEN item_sub_category_l10ns.name\n"
              + "            ELSE item_sub_categories.name\n"
              + "        END\n"
              + "    )\n"
              + "LIMIT :pageLimit OFFSET :pageOffset",
      nativeQuery = true)
  @NonNull
  List<ItemSubCategory> getItemSubCategoriesHaveItem(
      @NonNull UUID storeId, String languageCode, @NonNull int pageOffset, @NonNull int pageLimit);
}
