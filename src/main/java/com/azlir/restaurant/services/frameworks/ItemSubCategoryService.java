package com.azlir.restaurant.services.frameworks;

import com.azlir.restaurant.entities.databases.ItemSubCategory;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ItemSubCategoryService {
  List<ItemSubCategory> getItemSubCategoriesHaveItem(
      UUID storeId, String languageCode, int page, int pageLimit);

  Optional<ItemSubCategory> findById(UUID id);

  ItemSubCategory save(ItemSubCategory itemCategory);

  void deleteById(UUID id);
}
