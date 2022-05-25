package com.azlir.restaurant.controllers;

import com.azlir.restaurant.entities.databases.ItemCategory;
import com.azlir.restaurant.exceptions.NotFoundException;
import com.azlir.restaurant.services.frameworks.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/item/category")
public class ItemCategoryController {
  private final ItemCategoryService itemCategoryService;

  @Autowired
  public ItemCategoryController(ItemCategoryService itemCategoryService) {
    this.itemCategoryService = itemCategoryService;
  }

  @GetMapping
  public List<ItemCategory> getAllItemCategories(
      @RequestParam("page") int page, @RequestParam("page_limit") int pageLimit) {
    return itemCategoryService.getAllItemCategories(page, pageLimit);
  }

  @GetMapping(value = "/{id}")
  public ItemCategory getItemCategoryById(@PathVariable("id") UUID id) {
    return itemCategoryService
        .findById(id)
        .orElseThrow(
            () -> new NotFoundException("ItemCategory dengan id " + id + " tidak ditemukan!"));
  }

  @PostMapping
  public ItemCategory addItemCategory(@Valid @RequestBody ItemCategory itemCategory) {
    return itemCategoryService.save(itemCategory);
  }

  @PutMapping(value = "/{id}")
  public ItemCategory updateItemCategory(
      @PathVariable("id") UUID id, @Valid @RequestBody ItemCategory newItemCategory) {
    // TODO: Update itemCategory
    ItemCategory itemCategory =
        itemCategoryService
            .findById(id)
            .orElseThrow(
                () -> new NotFoundException("ItemCategory dengan id " + id + " tidak ditemukan!"));
    return itemCategoryService.save(itemCategory);
  }

  @DeleteMapping(value = "/{id}")
  public String deleteItemCategory(@PathVariable("id") UUID id) {
    ItemCategory itemCategory =
        itemCategoryService
            .findById(id)
            .orElseThrow(
                () -> new NotFoundException("ItemCategory dengan id " + id + " tidak ditemukan!"));
    itemCategoryService.deleteById(itemCategory.getId());
    return "ItemCategory dengan ID :" + id + " berhasil dihapus";
  }
}
