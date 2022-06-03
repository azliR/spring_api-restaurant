package com.azlir.restaurant.services.implementations;

import com.azlir.restaurant.entities.databases.ItemCategory;
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
  public List<ItemCategory> getItemCategoriesHaveItem(int page, int pageLimit) {
    return itemCategoryRepository.getItemCategoriesHaveItem(page, pageLimit);
  }

  @Override
  public Optional<ItemCategory> findById(UUID id) {
    return itemCategoryRepository.findById(id);
  }

  @Override
  public ItemCategory save(ItemCategory itemCategory) {
    return itemCategoryRepository.save(itemCategory);
  }

  @Override
  public void deleteById(UUID id) {
    itemCategoryRepository.deleteById(id);
  }
}
