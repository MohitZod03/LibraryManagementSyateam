package com.libraryManagementProject.libraryManageSB.controller;
import com.libraryManagementProject.libraryManageSB.entity.Category;
import com.libraryManagementProject.libraryManageSB.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CategoryController {
@Autowired
    private CategoryService categoryService;

    // mapping for to get All Category
@RequestMapping("/categories")
    public String getAllCategories(Model model){
    List<Category> categories= categoryService.findAllCategory();
    model.addAttribute("categories",categories);
    return "categories";
}

    // mapping for to get single Category
    @RequestMapping("/category/{id}")
    public String getSingleCategory(@PathVariable Long id, Model model){
        Category category=categoryService.findById(id);
        model.addAttribute("category",category);
        return "list-Category";
    }
    // mapping for to get remove Category

    @RequestMapping("/remove-category/{id}")
    public String deleteCategory(@PathVariable Long id, Model model){
        categoryService.deletedCategory(id);
        model.addAttribute("categories",categoryService.findAllCategory());
        return "categories";
    }


    // mapping for to get update category

    // binding result if any error in html page get into object.
    @RequestMapping("/update-category/{id}")
    public String updateBook(@PathVariable Long id, Model model){
        // find book first.
        Category category=categoryService.findById(id);
        model.addAttribute("category",category);

        return "update-category";
    }
    // it is need to save the updated category list

    @PostMapping("/save-updateCategory/{id}")
    public String updateCategory(@PathVariable Long id,Category category,BindingResult result,Model model){
        if (result.hasErrors()){
            return "update-category";
        }
        categoryService.updateCategory(category);
        model.addAttribute("categories",categoryService.findAllCategory());
        return "redirect:/categories";
    }



    // add Category
    @RequestMapping("/add-category")
    public String addCategory( Category category, Model model){


        return "add-category";
    }
    @PostMapping("/save-category")
    public String addCategory(Category category,BindingResult result,Model model){
        if (result.hasErrors()){
            return "add-category";
        }
        categoryService.updateCategory(category);
        model.addAttribute("categories",categoryService.findAllCategory());
        return "redirect:/categories";
    }

}
