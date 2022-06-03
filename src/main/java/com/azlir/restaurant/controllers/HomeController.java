package com.azlir.restaurant.controllers;

import com.azlir.restaurant.entities.databases.Item;
import com.azlir.restaurant.entities.databases.NearbyStore;
import com.azlir.restaurant.services.frameworks.ItemService;
import com.azlir.restaurant.services.frameworks.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/home")
public class HomeController {
  final ItemService itemService;
  final StoreService storeService;

  @Autowired
  public HomeController(ItemService itemService, StoreService storeService) {
    this.itemService = itemService;
    this.storeService = storeService;
  }

  @GetMapping(value = "/special")
  public List<Item> getSpecialOffers(
      @RequestParam("page") int page,
      @RequestParam("page_limit") int pageLimit,
      @RequestParam("latitude") double latitude,
      @RequestParam("longitude") double longitude) {
    return itemService.getSpecialOffers(latitude, longitude, page, pageLimit);
  }

  @GetMapping(value = "/nearby")
  public List<NearbyStore> getNearbyStores(
      @RequestParam("page") int page,
      @RequestParam("page_limit") int pageLimit,
      @RequestParam("latitude") double latitude,
      @RequestParam("longitude") double longitude) {
    return storeService.getNearbyStores(latitude, longitude, page, pageLimit);
  }
}
