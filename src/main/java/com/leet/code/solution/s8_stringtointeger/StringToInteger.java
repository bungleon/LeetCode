package com.leet.code.solution.s8_stringtointeger;

public class StringToInteger {
    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        String numbers = "0123456789";
        boolean negative = false;
        boolean numberFound = false;
        long result = 0;
        String numberMatched ="";
        boolean digitFound = false;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                if (!numberFound) {
                    continue;
                } else {
                    break;
                }
            }
            if (chars[i] == '-') {
                if (!numberFound) {
                    numberFound=true;
                    negative = true;
                    continue;
                } else {
                    break;
                }
            }
            if (chars[i] == '+') {
                if (!numberFound) {
                    numberFound=true;
                    continue;
                } else {
                    break;
                }
            }
            if (numbers.contains(String.valueOf(chars[i]))) {
                numberFound = true;
                if(chars[i] != '0') {
                        numberMatched += chars[i];
                        digitFound = true;
                }else{
                   if(digitFound){
                       numberMatched += chars[i];
                   }
                }
                result = result * 10 + Integer.parseInt(String.valueOf(chars[i]));
            } else{
                break;
            }
        }


        if(negative) {
            result = -result;
        }
        if(numberMatched.length()>=11){
            if(negative){
                return Integer.MIN_VALUE;
            }
            return Integer.MAX_VALUE;
        }else {
            if(result<Integer.MIN_VALUE){
                if(negative){
                    return Integer.MIN_VALUE;
                }
                return Integer.MAX_VALUE;
            }
            else if(result>Integer.MAX_VALUE){
                if(negative){
                    return Integer.MIN_VALUE;
                }
                return Integer.MAX_VALUE;
            }
        }
        return (int) result;
    }
}
