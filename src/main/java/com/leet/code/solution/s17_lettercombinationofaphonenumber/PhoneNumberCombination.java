package com.leet.code.solution.s17_lettercombinationofaphonenumber;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumberCombination {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        printCombinations("", digits, result);
        return result;
    }

    private char[] getCombination(char digit) {
        return switch (digit){
            case '2'-> new char[]{'a','b','c'};
            case '3'-> new char[]{'d','e','f'};
            case '4'-> new char[]{'g','h','i'};
            case '5'-> new char[]{'j','k','l'};
            case '6'-> new char[]{'m','n','o'};
            case '7'-> new char[]{'p','q','r','s'};
            case '8'-> new char[]{'t','u','v'};
            case '9'-> new char[]{'w','x','y','z'};
            default -> new char[]{};
        };
    }

    private void printCombinations(String combination,String nextDigit, List<String> result) {
        if (nextDigit.equals("")) {
            if (combination.length() > 0) {
                result.add(combination);
            }
        }
        else {
            char[] chars = nextDigit.toCharArray();
            char[] combinations = getCombination(chars[0]);
            nextDigit = nextDigit.substring(1);
            for (int i = 0; i < combinations.length; i++) {
                printCombinations(combination + combinations[i], nextDigit, result);
            }
        }
    }
}
