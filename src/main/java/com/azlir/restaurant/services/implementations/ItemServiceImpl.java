package com.azlir.restaurant.services.implementations;

import com.azlir.restaurant.entities.databases.Item;
import com.azlir.restaurant.repositories.ItemRepository;
import com.azlir.restaurant.services.frameworks.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ItemServiceImpl implements ItemService {
  private final ItemRepository itemRepository;

  @Autowired
  public ItemServiceImpl(ItemRepository itemRepository) {
    this.itemRepository = itemRepository;
  }

  @Override
  public List<Item> getSpecialOffers(double latitude, double longitude, int page, int pageLimit) {
    final var pageOffset = (page - 1) * pageLimit;
    return itemRepository.getSpecialOfferItems(latitude, longitude, pageLimit, pageOffset);
  }

  @Override
  public List<Item> getItemsByStoreId(int page, int pageLimit, UUID storeId, UUID subCategoryId) {
    final var pageOffset = (page - 1) * pageLimit;
    if (subCategoryId != null) {
      return itemRepository.getItemsByStoreId(storeId, subCategoryId, pageLimit, pageOffset);
    } else {
      return itemRepository.getItemsByStoreId(storeId, pageLimit, pageOffset);
    }
  }

  @Override
  public Optional<Item> findById(UUID id) {
    return itemRepository.findById(id);
  }

  @Override
  public Item save(Item item) {
    return itemRepository.save(item);
  }

  @Override
  public void deleteById(UUID id) {
    itemRepository.deleteById(id);
  }
}
