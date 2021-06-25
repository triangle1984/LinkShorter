package com.example.linkshorter.domain;

import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author Andrey Markov
 * @version 1.0 23.06.2021
 */
@Service
public class GeneratePrefix {
    public String generate(int length){
        Random random = new Random();
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder url = new StringBuilder();
        int min = 0;
        int max = chars.length()-1;
        for (int i = 0; i < length; i++) {
            url.append(chars.charAt(random.nextInt((max - min) + 1)));
        }
        return url.toString();
    }
}
