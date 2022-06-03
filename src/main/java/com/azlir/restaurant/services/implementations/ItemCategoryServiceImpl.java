package com.azlir.restaurant.services.implementations;

import com.azlir.restaurant.entities.databases.ItemCategory;
import com.azlir.restaurant.entities.databases.ItemCategoryL10n;
import com.azlir.restaurant.repositories.ItemCategoryRepository;
import com.azlir.restaurant.services.frameworks.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ItemCategoryServiceImpl implements ItemCategoryService {
  private final ItemCategoryRepository itemCategoryRepository;

  @Autowired
  public ItemCategoryServiceImpl(ItemCategoryRepository itemCategoryRepository) {
    this.itemCategoryRepository = itemCategoryRepository;
  }

  @Override
  public List<ItemCategoryL10n> getItemCategoriesHaveItem(
      String languageCode, int page, int pageLimit) {
    final var pageOffset = (page - 1) * pageLimit;
    return itemCategoryRepository.getItemCategoriesHaveItem(languageCode, pageOffset, pageLimit);
  }

  @Override
  public Optional<ItemCategory> findById(UUID id) {
    return Optional.empty();
  }

  @Override
  public ItemCategory save(ItemCategory itemCategory) {
    return null;
  }

  @Override
  public void deleteById(UUID id) {
    itemCategoryRepository.deleteById(id);
  }
}
