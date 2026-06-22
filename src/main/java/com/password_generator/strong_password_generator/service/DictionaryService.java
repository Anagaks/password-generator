package com.password_generator.strong_password_generator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DictionaryService {

    @Autowired
    private RestTemplate restTemplate;

    public boolean isWord(String word){
        try{
            String url = "htpps://dictonaryapi.dev/api/v2/entries/en/" + word;
            restTemplate.getForObject(url,String.class);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

}
