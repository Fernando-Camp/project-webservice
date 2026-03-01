package com.fernando.webservice.repositories;

import com.fernando.webservice.model.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
