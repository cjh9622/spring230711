package com.sparta.homeworkspring1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    // 일대다 관계 ( 한 명의 작가가 여러 도서를 쓸 수 있음)
    // mappedBy 양방향 관계에서 연관 관계의 '주인이 아닌 쪽'에서 매핑 정보를 설정
    // Book 엔티티의 'author' 필드에 의해 매핑되었다는 것을 의미한다
    // cascade = CascateType.ALL 작가 엔티티가 영속화 또는 삭제될때
    // 관련된 도서 엔티티도 함께 처리되도록 한다.
    // ++ 예전 과제에서 이걸 빠뜨려서 삭제시 에러발생 했었음!
    // orphanRemoval = ture 작가 엔티티와 연관된 도서가 더 이상 참조되지 않을 때,
    // 해당 도서 엔티티도 자동으로 삭제됨
    private List<Book> books = new ArrayList<>();


    public void addBook(Book book) {
        books.add(book);
        book.setAuther(this);
    }

    public void removeBook(Book book){
        books.remove((book));
        book.setAuther(null);
    }
}
