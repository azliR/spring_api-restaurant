package com.azlir.restaurant.repositories;

import com.azlir.restaurant.entities.databases.ItemCategoryL10n;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.UUID;

public interface ItemCategoryRepository extends JpaRepository<ItemCategoryL10n, UUID> {
  @Query(
      value =
          "SELECT item_categories.id,\n"
              + "    item_category_l10ns.language_code,\n"
              + "    item_categories.name AS name,\n"
              + "    item_category_l10ns.name AS translated_name\n"
              + "FROM item_categories\n"
              + "    LEFT JOIN item_category_l10ns ON item_categories.id = item_category_l10ns.category_id\n"
              + "    AND item_category_l10ns.language_code = :languageCode\n"
              + "WHERE (\n"
              + "        SELECT COUNT(*)\n"
              + "        FROM items\n"
              + "        WHERE items.category_id = item_categories.id\n"
              + "    ) > 0\n"
              + "ORDER BY (\n"
              + "        CASE\n"
              + "            WHEN item_category_l10ns.name IS NOT NULL THEN item_category_l10ns.name\n"
              + "            ELSE item_categories.name\n"
              + "        END\n"
              + "    )\n"
              + "LIMIT :pageLimit OFFSET :pageOffset",
      nativeQuery = true)
  @NonNull
  List<ItemCategoryL10n> getItemCategoriesHaveItem(
      String languageCode, @NonNull int pageOffset, @NonNull int pageLimit);
}
