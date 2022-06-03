package com.azlir.restaurant.services.frameworks;

import com.azlir.restaurant.entities.databases.ItemCategory;
import com.azlir.restaurant.entities.databases.ItemCategoryL10n;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ItemCategoryService {
  List<ItemCategoryL10n> getItemCategoriesHaveItem(String languageCode, int page, int pageLimit);

  Optional<ItemCategory> findById(UUID id);

  ItemCategory save(ItemCategory itemCategory);

  void deleteById(UUID id);
}
