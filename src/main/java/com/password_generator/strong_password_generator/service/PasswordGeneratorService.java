package com.password_generator.strong_password_generator.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.security.SecureRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class PasswordGeneratorService {

    private final DictionaryService dictionaryService;
    private final SecureRandom secureRandom = new SecureRandom();

    @Value("${app.password.chars:ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+}")
    private String allowedChars;

    public PasswordGeneratorService(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    public String generate(int length) {
        String password;
        do {
            password = IntStream.range(0, length)
                    .mapToObj(i -> String.valueOf(allowedChars.charAt(secureRandom.nextInt(allowedChars.length()))))
                    .collect(Collectors.joining());
        } while (containsDictionaryWord(password));
        return password;
    }

    private boolean containsDictionaryWord(String password) {
        int length = password.length();
        for (int len = 4; len <= length; len++) {
            for (int i = 0; i <= length - len; i++) {
                String sub = password.substring(i, i + len);
                if (sub.matches("^[a-zA-Z]+$") && dictionaryService.isWord(sub)) {
                    return true;
                }
            }
        }
        return false;
    }
}
