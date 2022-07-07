package com.app.wordlepredictor.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordFinder {
    public static List<String> parser(List<String> dbList,
                                         List<Character> presentLetters,
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

        for(String word : dbList){
            //could be string utils from apache but using regex
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
