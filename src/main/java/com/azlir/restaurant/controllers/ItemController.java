package com.azlir.restaurant.controllers;

import com.azlir.restaurant.entities.databases.Item;
import com.azlir.restaurant.exceptions.NotFoundException;
import com.azlir.restaurant.services.frameworks.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/item")
public class ItemController {
  private final ItemService itemService;

  @Autowired
  public ItemController(ItemService itemService) {
    this.itemService = itemService;
  }

  @GetMapping
  public List<Item> getItemsByStoreId(
      @RequestParam("page") int page,
      @RequestParam("page_limit") int pageLimit,
      @RequestParam("store_id") UUID storeId,
      @RequestParam(value = "sub_category_id", required = false) UUID subCategoryId) {
    return itemService.getItemsByStoreId(page, pageLimit, storeId, subCategoryId);
  }

  @GetMapping(value = "/{id}")
  public Item getItemById(@PathVariable("id") UUID id) {
    return itemService
        .findById(id)
        .orElseThrow(() -> new NotFoundException("Item dengan id " + id + " tidak ditemukan!"));
  }

  @PostMapping
  public Item addItem(@Valid @RequestBody Item item) {
    return itemService.save(item);
  }

  @PutMapping(value = "/{id}")
  public Item updateItem(@PathVariable("id") UUID id, @Valid @RequestBody Item newItem) {
    // TODO: Update item
    Item item =
        itemService
            .findById(id)
            .orElseThrow(() -> new NotFoundException("Item dengan id " + id + " tidak ditemukan!"));
    return itemService.save(item);
  }

  @DeleteMapping(value = "/{id}")
  public String deleteItem(@PathVariable("id") UUID id) {
    Item item =
        itemService
            .findById(id)
            .orElseThrow(() -> new NotFoundException("Item dengan id " + id + " tidak ditemukan!"));
    itemService.deleteById(item.getId());
    return "Item dengan ID :" + id + " berhasil dihapus";
  }
}
