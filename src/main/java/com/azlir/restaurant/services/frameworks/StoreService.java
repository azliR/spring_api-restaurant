package com.azlir.restaurant.services.frameworks;

import com.azlir.restaurant.entities.databases.Store;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StoreService {
  List<Store> getAllStores();

  Optional<Store> findById(UUID id);

  Store save(Store store);

  void deleteById(UUID id);
}