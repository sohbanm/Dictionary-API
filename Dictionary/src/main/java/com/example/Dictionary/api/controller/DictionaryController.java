package com.example.Dictionary.api.controller;

import com.example.Dictionary.api.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class DictionaryController {

    private final DictionaryService dictionaryService;

    @Autowired
    public DictionaryController(DictionaryService dictionaryService){
        this.dictionaryService = dictionaryService;
    }

    @GetMapping("/{text}")
    public String getWord(@PathVariable String text) throws IOException {
        String definition = dictionaryService.findDefinition(text);
        return "<h1>" + text + "</h1><p>" + definition + "</p>";
    }

    @GetMapping("/")
    public String test(){
//        return "<h1>Dictionary</h1>";
        return "<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"><title>Dictionary API</title></head><body><header><h1>Dictionary API</h1></header><section><h2>Welcome</h2><p>This API provides access to a dictionary. You can use it to look up the definitions of words.</p></section><section><h2>Get Definition</h2><p>To get the definition of a word, make a GET request to the following endpoint:</p><code>/{word}</code><p>Replace <code>{word}</code> with the word you want to look up.</p></section><section><h2>Example</h2><p>If you want to find the definition of the word \"example,\" make a GET request to:</p><code>/example</code></section><section><h2>Response</h2><p>The API will respond with the definition of the requested word.</p></section></body></html>";
    }

    @GetMapping(value = "/", params = "param")
    public String getParam(@RequestParam String param){
        return param;
    }

    @GetMapping(value = "/", params = {"first", "second"})
    public String params(@RequestParam String first, @RequestParam String second){
        return first + "<br>" + second;
    }

}
