package com.app.wordlepredictor.service;

import com.app.wordlepredictor.model.Word;
import com.app.wordlepredictor.repository.WordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IWordService implements WordService{
    @Autowired
    private WordRepo wordRepo;

    @Override
    public Word saveWord(Word word) {
        return wordRepo.save(word);
    }
}