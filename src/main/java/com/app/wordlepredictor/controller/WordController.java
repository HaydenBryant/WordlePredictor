package com.app.wordlepredictor.controller;

import com.app.wordlepredictor.model.Word;
import com.app.wordlepredictor.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
