package com.jzheadley.eat.Respositories;

import com.jzheadley.eat.Models.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {
}
