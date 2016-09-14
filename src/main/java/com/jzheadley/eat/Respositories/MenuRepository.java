package com.jzheadley.eat.Respositories;

import com.jzheadley.eat.Models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
}
