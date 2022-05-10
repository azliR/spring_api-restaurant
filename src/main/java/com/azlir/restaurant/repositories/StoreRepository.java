package com.azlir.restaurant.repositories;

import com.azlir.restaurant.entities.databases.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StoreRepository extends JpaRepository<Store, UUID> {}
