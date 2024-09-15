package com.libraryManagementProject.libraryManageSB.repository;

import com.libraryManagementProject.libraryManageSB.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
