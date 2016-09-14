package com.jzheadley.eat.Respositories;

import com.jzheadley.eat.Models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
}
