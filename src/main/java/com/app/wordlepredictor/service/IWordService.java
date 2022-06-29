package com.app.wordlepredictor.service;

import com.app.wordlepredictor.model.Word;
import com.app.wordlepredictor.repository.WordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IWordService implements WordService{
    @Autowired
    private WordRepo wordRepo;

    @Override
    public Word saveWord(Word word) {
        return wordRepo.save(word);
    }

    @Override
    public List<Word> getAllWords() {
        return wordRepo.findAll();
    }

    @Override
    public Character getLetterByPosition(Word word, int position) {
        return word.getWord().charAt(position);
    }
}
