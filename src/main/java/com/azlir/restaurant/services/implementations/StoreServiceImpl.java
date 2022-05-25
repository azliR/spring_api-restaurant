package com.azlir.restaurant.services.implementations;

import com.azlir.restaurant.entities.databases.Store;
import com.azlir.restaurant.repositories.StoreRepository;
import com.azlir.restaurant.services.frameworks.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StoreServiceImpl implements StoreService {
  private final StoreRepository storeRepository;

  @Autowired
  public StoreServiceImpl(StoreRepository storeRepository) {
    this.storeRepository = storeRepository;
  }

  @Override
  public List<Store> getNearbyStores(double latitude, double longitude, int page, int pageLimit) {
    return storeRepository.getNearbyStores(latitude, longitude, page, pageLimit);
  }

  @Override
  public Optional<Store> findById(UUID id) {
    return storeRepository.findById(id);
  }

  @Override
  public Store save(Store store) {
    return storeRepository.save(store);
  }

  @Override
  public void deleteById(UUID id) {
    storeRepository.deleteById(id);
  }
}
