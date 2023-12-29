package com.example.Dictionary.api.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class DictionaryService {

    private File jsonFile;

    public DictionaryService(ResourceLoader resourceLoader) throws IOException {
        String relativePath = "classpath:dictionary_compact.json";
        Resource resource = resourceLoader.getResource(relativePath);
        this.jsonFile = resource.getFile();
    }

    public String findDefinition(String word) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode dictionary = objectMapper.readTree(this.jsonFile);
        if (dictionary.has(word)) {
            return dictionary.get(word).asText();
        } else {
            return "Definition not found for the word: " + word;
        }
    }

}
