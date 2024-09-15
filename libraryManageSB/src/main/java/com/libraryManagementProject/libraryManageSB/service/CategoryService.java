package com.libraryManagementProject.libraryManageSB.service;



import com.libraryManagementProject.libraryManageSB.entity.Category;
import com.libraryManagementProject.libraryManageSB.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    // get all category...
    public List<Category> findAllCategory(){
        return categoryRepository.findAll();
    }

    // find single category...

    public Category findById(Long id){
       Category category;
        // findById need this exception handling.
        category=categoryRepository.findById(id).orElseThrow(()->new RuntimeException("category not found"));
        return category;
    }


    // create the category

    public void  createCategory(Category category){
        categoryRepository.save(category);
    }

    /// deleted category
    public  void deletedCategory(Long id){
        // first find category then deleted
       Category category=categoryRepository.findById(id).orElseThrow(()->new RuntimeException("category not found"));
        categoryRepository.deleteById(category.getId());
    }

    // update the book
    public  void updateCategory(Category category){
        categoryRepository.save(category);
    }

}
