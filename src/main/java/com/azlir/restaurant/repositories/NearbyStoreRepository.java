package com.azlir.restaurant.repositories;

import com.azlir.restaurant.entities.databases.NearbyStore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NearbyStoreRepository extends JpaRepository<NearbyStore, UUID> {
}
