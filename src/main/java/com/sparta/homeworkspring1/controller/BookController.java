package com.sparta.homeworkspring1.controller;

import com.sparta.homeworkspring1.entity.Book;
import com.sparta.homeworkspring1.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")


public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping//CREATE부분
    public ResponseEntity<Book> createBook(@RequestParam String title, @RequestParam Long authorId){
        Book book = bookService.createBook(title, authorId);
        return ResponseEntity.ok(book);
    }

    @PutMapping("/{id}")//UPDATE부분
    public ResponseEntity<Book> updateBook(@PathVariable("id") Long bookId, @RequestParam String newTitle){
        Book book = bookService.updateBook(bookId, newTitle);
        return ResponseEntity.ok(book);
    }
}
