package com.kelimeoyunu.repository;

import com.kelimeoyunu.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
