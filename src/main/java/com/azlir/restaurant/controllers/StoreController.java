package com.azlir.restaurant.controllers;

import com.azlir.restaurant.entities.databases.Store;
import com.azlir.restaurant.exceptions.NotFoundException;
import com.azlir.restaurant.services.frameworks.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/store")
public class StoreController {
  private final StoreService storeService;

  @Autowired
  public StoreController(StoreService storeService) {
    this.storeService = storeService;
  }

  @GetMapping(value = "/{id}")
  public Store getStoreById(@PathVariable("id") UUID id) {
    return storeService
        .findById(id)
        .orElseThrow(() -> new NotFoundException("Store dengan id " + id + " tidak ditemukan!"));
  }

  @PostMapping
  public Store addStore(@Valid @RequestBody Store store) {
    return storeService.save(store);
  }

  @PutMapping(value = "/{id}")
  public Store updateStore(@PathVariable("id") UUID id, @Valid @RequestBody Store newStore) {
    // TODO: Update store
    Store store =
        storeService
            .findById(id)
            .orElseThrow(
                () -> new NotFoundException("Store dengan id " + id + " tidak ditemukan!"));
    return storeService.save(store);
  }

  @DeleteMapping(value = "/{id}")
  public String deleteStore(@PathVariable("id") UUID id) {
    Store store =
        storeService
            .findById(id)
            .orElseThrow(
                () -> new NotFoundException("Store dengan id " + id + " tidak ditemukan!"));
    storeService.deleteById(store.getId());
    return "Store dengan ID :" + id + " berhasil dihapus";
  }
}
