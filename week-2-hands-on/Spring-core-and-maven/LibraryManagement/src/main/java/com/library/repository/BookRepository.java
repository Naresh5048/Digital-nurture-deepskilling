package com.library.repository;

import org.springframework.stereotype.Repository;
import java.util.Arrays;
import java.util.List;

@Repository
public class BookRepository {
    public List<String> fetchBooks() {
        return Arrays.asList("Clean Code", "Design Patterns", "Spring in Action");
    }
}