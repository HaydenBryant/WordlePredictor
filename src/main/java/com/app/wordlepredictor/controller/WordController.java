package com.app.wordlepredictor.controller;

import com.app.wordlepredictor.model.Word;
import com.app.wordlepredictor.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/word")
public class WordController {
    @Autowired
    private WordService wordService;

    @PostMapping("/add")
    public String add(@RequestBody Word word){
        wordService.saveWord(word);
        return "New word added";
    }

    @GetMapping("/getWords")
    public List<Word> getAllWords(){
        return wordService.getAllWords();
    }

    @GetMapping("/getLetter")
    public Character getLetterByPosition(@RequestBody Word word, int position){return wordService.getLetterByPosition(word, position);}
}
