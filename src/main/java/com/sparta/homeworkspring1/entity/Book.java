package com.sparta.homeworkspring1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String title;

    @ManyToOne      //다대일 관계  ( 책 여러개가 하나의 작가에 속할 수 있다 )
    @JoinColumn(name = "author_id") //외래 키 매핑?
    private Author author;

    public void setAuther(Author author) {
    }
}
