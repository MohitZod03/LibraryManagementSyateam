package com.libraryManagementProject.libraryManageSB;

import com.libraryManagementProject.libraryManageSB.entity.Author;
import com.libraryManagementProject.libraryManageSB.entity.Book;
import com.libraryManagementProject.libraryManageSB.entity.Category;
import com.libraryManagementProject.libraryManageSB.entity.Publisher;
import com.libraryManagementProject.libraryManageSB.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryManageSbApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManageSbApplication.class, args);

	}
////	@Bean
////	public CommandLineRunner initialCreate(BookService bookService){
////return (args)->{
////	Book book1=new Book("ABC","first","it is my First Book");
////	Author author1= new Author("test name1","test1 description");
////	Category category1= new Category("businessBook");
////	Publisher publisher1= new Publisher("firstPubliser");
////
////	book1.addAuthor(author1);
////	book1.addCategory(category1);
////	book1.addPublisher(publisher1);
////	bookService.createBook(book1);
////
////
////	Book book2=new Book("ABC2","second","it is my second Book");
////	Author author2= new Author("test name2","test2 description");
////	Category category2= new Category("businessBook2");
////	Publisher publisher2= new Publisher("secondPublisher");
////
////	book2.addAuthor(author2);
////	book2.addCategory(category2);
////	book2.addPublisher(publisher2);
////	bookService.createBook(book2);
////
////
////
////
////
////
////
////
////
////};

//	}



}
