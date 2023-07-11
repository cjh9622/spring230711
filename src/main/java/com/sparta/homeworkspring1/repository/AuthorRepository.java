package com.sparta.homeworkspring1.repository;

import com.sparta.homeworkspring1.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
