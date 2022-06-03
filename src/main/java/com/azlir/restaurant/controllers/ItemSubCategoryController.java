package com.azlir.restaurant.controllers;

import com.azlir.restaurant.entities.databases.ItemSubCategory;
import com.azlir.restaurant.exceptions.NotFoundException;
import com.azlir.restaurant.services.frameworks.ItemSubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/item/sub_category")
public class ItemSubCategoryController {
  private final ItemSubCategoryService itemSubCategoryService;

  @Autowired
  public ItemSubCategoryController(ItemSubCategoryService itemSubCategoryService) {
    this.itemSubCategoryService = itemSubCategoryService;
  }

  @GetMapping
  public List<ItemSubCategory> getItemSubCategoriesHaveItem(
      @RequestParam("store_id") UUID storeId,
      @RequestParam(value = "language_code", required = false) String languageCode,
      @RequestParam("page") int page,
      @RequestParam("page_limit") int pageLimit) {
    return itemSubCategoryService.getItemSubCategoriesHaveItem(
        storeId, languageCode, page, pageLimit);
  }

  @PostMapping
  public ItemSubCategory addItemSubCategory(@Valid @RequestBody ItemSubCategory itemSubCategory) {
    return itemSubCategoryService.save(itemSubCategory);
  }

  @PutMapping(value = "/{id}")
  public ItemSubCategory updateItemSubCategory(
      @PathVariable("id") UUID id, @Valid @RequestBody ItemSubCategory newItemSubCategory) {
    // TODO: Update itemSubCategory
    ItemSubCategory itemSubCategory =
        itemSubCategoryService
            .findById(id)
            .orElseThrow(
                () ->
                    new NotFoundException("ItemSubCategory dengan id " + id + " tidak ditemukan!"));
    return itemSubCategoryService.save(itemSubCategory);
  }

  @DeleteMapping(value = "/{id}")
  public String deleteItemSubCategory(@PathVariable("id") UUID id) {
    ItemSubCategory itemSubCategory =
        itemSubCategoryService
            .findById(id)
            .orElseThrow(
                () ->
                    new NotFoundException("ItemSubCategory dengan id " + id + " tidak ditemukan!"));
    itemSubCategoryService.deleteById(itemSubCategory.getSubCategoryId());
    return "ItemSubCategory dengan ID :" + id + " berhasil dihapus";
  }
}
