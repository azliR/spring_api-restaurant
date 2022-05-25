package com.azlir.restaurant.controllers;

import com.azlir.restaurant.entities.databases.Item;
import com.azlir.restaurant.services.frameworks.ItemService;
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

  @Autowired
  public HomeController(ItemService itemService) {
    this.itemService = itemService;
  }

  @GetMapping(value = "/special")
  public List<Item> getSpecialOffers(
      @RequestParam("page") int page,
      @RequestParam("page_limit") int pageLimit,
      @RequestParam("latitude") double latitude,
      @RequestParam("longitude") double longitude) {
    return itemService.getSpecialOffers(latitude, longitude, page, pageLimit);
  }

  //  @GetMapping(value = "/nearby")
  //  public List<Item> getNearbyStores(
  //      @RequestParam("page") int page,
  //      @RequestParam("page_limit") int pageLimit,
  //      @RequestParam("latitude") double latitude,
  //      @RequestParam("longitude") double longitude) {
  //    return itemService.getNearbyStores(latitude, longitude, page, pageLimit);
  //  }
}
