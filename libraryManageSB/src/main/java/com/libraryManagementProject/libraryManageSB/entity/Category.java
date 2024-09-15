package com.libraryManagementProject.libraryManageSB.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "name" , length = 50, nullable = false,unique = true)
    private String name;

    // constructor


    public Category(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "categories",cascade = {CascadeType.ALL})
    private Set<Book> books= new HashSet<Book>();
}
