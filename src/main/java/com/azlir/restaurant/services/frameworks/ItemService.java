package com.azlir.restaurant.services.frameworks;

import com.azlir.restaurant.entities.databases.Item;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ItemService {
  List<Item> getItemsByStoreId(int page, int pageLimit, UUID storeId, UUID subCategoryId);

  List<Item> getSpecialOffers(double latitude, double longitude, int page, int pageLimit);

  Optional<Item> findById(UUID id);

  Item save(Item item);

  void deleteById(UUID id);
}
