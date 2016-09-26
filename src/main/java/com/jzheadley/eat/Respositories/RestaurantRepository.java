package com.jzheadley.eat.Respositories;

import com.jzheadley.eat.Models.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {
}
