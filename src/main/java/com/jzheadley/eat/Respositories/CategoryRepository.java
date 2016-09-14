package com.jzheadley.eat.Respositories;

import com.jzheadley.eat.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
