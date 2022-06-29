package com.app.wordlepredictor.service;

import com.app.wordlepredictor.model.Word;

import java.util.List;

public interface WordService {
    public Word saveWord(Word word);
    public List<Word> getAllWords();
    public Character getLetterByPosition(Word word, int position);
}
