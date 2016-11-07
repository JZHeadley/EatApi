package com.jzheadley.eat.Respositories;

import com.jzheadley.eat.Models.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {

    List<Restaurant> findByOwnerId(@Param("restaurantOwnerId") int ownerId);

//    List<Restaurant> findByRestaurantOwner(@RequestBody User user);
}
