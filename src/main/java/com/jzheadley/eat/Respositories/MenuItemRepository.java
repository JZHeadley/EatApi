package com.jzheadley.eat.Respositories;

import com.jzheadley.eat.Models.MenuItem;
import org.springframework.data.repository.CrudRepository;

public interface MenuItemRepository extends CrudRepository<MenuItem, Integer> {
}
