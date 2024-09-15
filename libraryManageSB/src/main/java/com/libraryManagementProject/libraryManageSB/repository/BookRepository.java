package com.libraryManagementProject.libraryManageSB.repository;

import com.libraryManagementProject.libraryManageSB.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
