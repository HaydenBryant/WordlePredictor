package com.app.wordlepredictor.repository;

import com.app.wordlepredictor.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepo extends JpaRepository<Word, Integer> {
}
