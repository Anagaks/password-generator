package com.password_generator.strong_password_generator.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestClientException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Service
public class DictionaryService {
    private final RestTemplate restTemplate;
    private static final String API_URL = "https://api.dictionaryapi.dev/api/v2/entries/en/";

    public DictionaryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean isWord(String word) {
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(API_URL + word, String.class);
            return response.getStatusCode() == HttpStatus.OK;
        } catch (RestClientException e) {
            return false;
        }
    }
}