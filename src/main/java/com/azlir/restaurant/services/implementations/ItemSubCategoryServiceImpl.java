package com.azlir.restaurant.services.implementations;

import com.azlir.restaurant.entities.databases.ItemSubCategory;
import com.azlir.restaurant.repositories.ItemSubCategoryRepository;
import com.azlir.restaurant.services.frameworks.ItemSubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ItemSubCategoryServiceImpl implements ItemSubCategoryService {
  private final ItemSubCategoryRepository itemSubCategoryRepository;

  @Autowired
  public ItemSubCategoryServiceImpl(ItemSubCategoryRepository itemSubCategoryRepository) {
    this.itemSubCategoryRepository = itemSubCategoryRepository;
  }

  @Override
  public List<ItemSubCategory> getItemSubCategoriesHaveItem(
      UUID storeId, String languageCode, int page, int pageLimit) {
    final var pageOffset = (page - 1) * pageLimit;
    return itemSubCategoryRepository.getItemSubCategoriesHaveItem(
        storeId, languageCode, pageOffset, pageLimit);
  }

  @Override
  public Optional<ItemSubCategory> findById(UUID id) {
    return itemSubCategoryRepository.findById(id);
  }

  @Override
  public ItemSubCategory save(ItemSubCategory itemSubCategory) {
    return itemSubCategoryRepository.save(itemSubCategory);
  }

  @Override
  public void deleteById(UUID id) {
    itemSubCategoryRepository.deleteById(id);
  }
}
