package com.sparta.homeworkspring1.service;

import com.sparta.homeworkspring1.entity.Author;
import com.sparta.homeworkspring1.entity.Book;
import com.sparta.homeworkspring1.repository.AuthorRepository;
import com.sparta.homeworkspring1.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service

public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    //BookREpository와 AuthorRepository는 JPA 리포지토리 인터페이스로,
    //데이터베이스와 상호작용하기 위한 메서드를 정의함!
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public Book createBook(String title, Long authorId) {
        //title과 authorID를 사용해 새로운 도서를 생성하고, 작가와 연결한 후 저장
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new IllegalArgumentException("작가를 찾을 수 없음"));

        Book book = new Book();
        book.setTitle(title);
        author.addBook(book);

        return bookRepository.save(book);
    }

    public Book updateBook(Long bookId, String newTitle){
        //bookID로 책을 찾아서 title을 업데이트 하고 저장
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("책을 찾을 수 없음"));

        book.setTitle(newTitle);

        return bookRepository.save(book);
    }
}
