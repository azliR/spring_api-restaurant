package com.azlir.restaurant.repositories;

import com.azlir.restaurant.entities.databases.ItemCategory;
import com.azlir.restaurant.entities.databases.ItemCategoryL10n;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.UUID;

public interface ItemCategoryRepository extends JpaRepository<ItemCategory, UUID> {
  @Query(
      value =
          "SELECT *\n"
              + "FROM item_categories\n"
              + "ORDER BY name\n"
              + "LIMIT :pageLimit OFFSET :pageOffset",
      nativeQuery = true)
  @NonNull
  List<ItemCategory> getItemCategories(@NonNull int pageLimit, @NonNull int pageOffset);

  @Query(
      value =
          "SELECT item_categories.id,\n"
              + "    item_categories.name AS name,\n"
              + "    item_category_l10ns.name AS name_l10n\n"
              + "FROM item_categories\n"
              + "    LEFT JOIN item_category_l10ns ON item_categories.id = item_category_l10ns.category_id\n"
              + "WHERE item_category_l10ns.language_code = 'id'\n"
              + "ORDER BY item_category_l10ns.name\n"
              + "LIMIT :pageLimit OFFSET :pageOffset",
      nativeQuery = true)
  @NonNull
  List<ItemCategoryL10n> getItemCategoriesL10ns(@NonNull int pageLimit, @NonNull int pageOffset);
}
