package com.password_generator.strong_password_generator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PasswordService {

    @Autowired
    private DictionaryService dictionaryService ;

    private static final int PASSWORD_LENGTH = 12;

    private static final String Characters = "ABCDEFGHIJKLMNOPQRSTUVWXY" +
                                          "abcdefghijklmnopqrstuvwxyz" +
                                            "0123456789" +
                                            "!@#$%^&*";

    private final Random random = new Random();

    public String generateStrongPassword() {
        while(true){
            String password = generatePassword();

            if(!containsDictionaryWord(password)){
                return password;
            }
        }
    }
// generate new password
    private String generatePassword() {
        StringBuilder strongPassword  = new StringBuilder();
        for(int i =0; i < PASSWORD_LENGTH; i++){
            int index = random.nextInt(Characters.length());
            strongPassword.append(Characters.charAt(index));
    }
        return strongPassword.toString();
    }

    //check the word exists in dictionary
    private boolean containsDictionaryWord(String password) {
        String letters = password.replaceAll("[^a-zA-Z]", "").toLowerCase();
        if(letters.length() < 4) return false;
        for(int i =0; i <=  letters.length(); i++){
            for(int j = i+4 ; j <=letters.length() ; j++){
                String string = letters.substring(i,j);
                if(dictionaryService.isWord(string)){
                    return true;
                }

            }
        }
        return false ;
    }


}
