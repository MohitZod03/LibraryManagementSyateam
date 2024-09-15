package com.libraryManagementProject.libraryManageSB.service;

import com.libraryManagementProject.libraryManageSB.entity.Author;


import com.libraryManagementProject.libraryManageSB.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    // get all author...
    public List<Author> findAllAuthor(){
        return authorRepository.findAll();
    }

    // find single author...

    public Author findById(Long id){
        Author author;
        // findById need  exception handling.
        author=authorRepository.findById(id).orElseThrow(()->new RuntimeException("author not found"));
        return author;
    }


    // create the author

    public void  createAuthor(Author author){
        authorRepository.save(author);
    }

    /// deleted author
    public  void deletedAuthor(Long id){
        // fist find author
        Author  author=authorRepository.findById(id).orElseThrow(()->new RuntimeException("author not found"));
        authorRepository.deleteById(author.getId());
    }

    // update the book
    public  void updateAuthor(Author author){
        authorRepository.save(author);
    }

}
