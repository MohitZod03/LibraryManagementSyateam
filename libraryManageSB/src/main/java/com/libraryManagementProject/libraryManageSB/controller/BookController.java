package com.libraryManagementProject.libraryManageSB.controller;

import com.libraryManagementProject.libraryManageSB.entity.Book;
import com.libraryManagementProject.libraryManageSB.service.AuthorService;
import com.libraryManagementProject.libraryManageSB.service.BookService;
import com.libraryManagementProject.libraryManageSB.service.CategoryService;
import com.libraryManagementProject.libraryManageSB.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PublisherService publisherService;

    @Autowired
    private AuthorService authorService;


    // mapping for to get all book

    @RequestMapping("/books")
    public String getAllBook(Model model){
    List<Book> bookList= bookService.findAllBooks();
    model.addAttribute("books",bookList);

        return "books";
    }

    // mapping for to get single book
    @RequestMapping("/book/{id}")
    public String getSingleBook(@PathVariable Long id, Model model){
        Book book=bookService.findById(id);
        model.addAttribute("book",book);
        return "list-book";
    }


    // mapping for to get remove book

    @RequestMapping("/remove-book/{id}")
    public String deleteBook(@PathVariable Long id, Model model){
        bookService.deletedBook(id);
        model.addAttribute("books",bookService.findAllBooks());
        return "books";
    }

    // mapping for to get update book

// binding result if any error in html page get into object.
    @RequestMapping("/update-book/{id}")
    public String updateBook(@PathVariable Long id, Model model){
        // find book first.
        Book book=bookService.findById(id);
        model.addAttribute("book",book);
        model.addAttribute("categories",categoryService.findAllCategory());
        model.addAttribute("publishers",publisherService.findAllPublisher());
        model.addAttribute("authors",authorService.findAllAuthor());
        return "update-book";
    }
    // it is need to save the updated book list

    @PostMapping("/save-update/{id}")
    public String updateBook(@PathVariable Long id,Book book,BindingResult result,Model model){
        if (result.hasErrors()){
            return "update-book";
        }
        bookService.updateBook(book);
        model.addAttribute("books",bookService.findAllBooks());
        return "redirect:/books";
    }


    // add book
    @RequestMapping("/add-book")
    public String addBook( Book book, Model model){

        model.addAttribute("categories",categoryService.findAllCategory());
        model.addAttribute("publishers",publisherService.findAllPublisher());
        model.addAttribute("authors",authorService.findAllAuthor());
        return "add-book";
    }
    @PostMapping("/save-book")
    public String addBook(Book book,BindingResult result,Model model){
        if (result.hasErrors()){
            return "add-book";
        }
        bookService.updateBook(book);
        model.addAttribute("books",bookService.findAllBooks());
        return "redirect:/books";
    }
}
