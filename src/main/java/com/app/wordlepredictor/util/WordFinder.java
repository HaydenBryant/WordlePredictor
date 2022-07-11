package com.app.wordlepredictor.util;

import com.app.wordlepredictor.model.Word;
import com.app.wordlepredictor.repository.WordRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordFinder {

    @Autowired
    private WordRepo wordRepo;

    public List<Word> getAllWords() {
        return wordRepo.findAll();
    }

    public List<String> parser(List<Character> presentLetters,
                               HashMap<Integer, Character> letterLocation,
                               List<Character> nonPresentLetters){

        List<String> possibleWords = new ArrayList<>();
        String nonPresentLetRegex = ".*[";
        for(char let : nonPresentLetters){
            nonPresentLetRegex += let;
        }
        nonPresentLetRegex += " ].*";

        String presentLetRegex = ".*[";
        for(char let : presentLetters){
            presentLetRegex += let;
        }
        presentLetRegex += " ].*";

        for(Word dictWord : getAllWords()){
            String word = dictWord.getWord();
            if(word.matches(nonPresentLetRegex)){
                continue;
            }
            if(!word.matches(presentLetRegex)){
                continue;
            }
            boolean correctFlag = true;
            for(int num : letterLocation.keySet()){
                if(word.charAt(num) != letterLocation.get(num)){
                    correctFlag = false;
                    break;
                }
            }
            if(correctFlag){
                possibleWords.add(word);
            }
        }

        return possibleWords;
    }
}
