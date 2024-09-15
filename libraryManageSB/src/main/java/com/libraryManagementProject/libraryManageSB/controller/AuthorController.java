package com.libraryManagementProject.libraryManageSB.controller;

import com.libraryManagementProject.libraryManageSB.entity.Author;
import com.libraryManagementProject.libraryManageSB.entity.Category;
import com.libraryManagementProject.libraryManageSB.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AuthorController {
    @Autowired
    private AuthorService authorService;


    // mapping for to get All Category
    @RequestMapping("/authors")
    public String getAllAuthors(Model model){
        List<Author> authors= authorService.findAllAuthor();
        model.addAttribute("authors",authors);
        return "authors";
    }


    // mapping for to get single Category
    @RequestMapping("/author/{id}")
    public String getSingleCategory(@PathVariable Long id, Model model){
        Author author=authorService.findById(id);
        model.addAttribute("author",author);
        return "list-Author";
    }


    // mapping for to get remove Category

    @RequestMapping("/remove-author/{id}")
    public String deleteAuthor(@PathVariable Long id, Model model){
        authorService.deletedAuthor(id);
        model.addAttribute("authors",authorService.findAllAuthor());
        return "authors";
    }


    // mapping for to get update category

    // binding result if any error in html page get into object.
    @RequestMapping("/update-author/{id}")
    public String updateAuthor(@PathVariable Long id, Model model){
        // find book first.
        Author author=authorService.findById(id);
        model.addAttribute("author",author);

        return "update-author";
    }
    // it is need to save the updated category list

    @PostMapping("/save-updateAuthor/{id}")
    public String updateAuthor(@PathVariable Long id, Author author, BindingResult result, Model model){
        if (result.hasErrors()){
            return "update-author";
        }
        authorService.updateAuthor(author);
        model.addAttribute("authors",authorService.findAllAuthor());
        return "redirect:/authors";
    }


    // add Category
    @RequestMapping("/add-author")
    public String addAuthor( Author author, Model model){


        return "add-author";
    }
    @PostMapping("/save-author")
    public String addAuthor(Author author,BindingResult result,Model model){
        if (result.hasErrors()){
            return "add-author";
        }
        authorService.updateAuthor(author);
        model.addAttribute("author",authorService.findAllAuthor());
        return "redirect:/authors";
    }



}
