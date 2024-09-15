package com.libraryManagementProject.libraryManageSB.repository;

import com.libraryManagementProject.libraryManageSB.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
