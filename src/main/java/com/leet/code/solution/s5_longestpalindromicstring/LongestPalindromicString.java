package com.leet.code.solution.s5_longestpalindromicstring;

public class LongestPalindromicString {
    // TODO think again
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        String longest = "";
        String longestPalindrome = "";
        for (int i = 0; i < chars.length; i++) {
            longestPalindrome = String.valueOf(chars[i]);
            int prev = 1;
            int next = 1;
            boolean isSame = false;
            boolean isSameBefore = true;
            for (int j = 0; j < chars.length - i; j++) {
                if (i - prev >= 0 && i + next < chars.length) {
                    if (chars[i + next] == chars[i - prev]) {
                        longestPalindrome = chars[i - prev] + longestPalindrome + chars[i + next];

                        if (chars[i] == chars[i - prev] && isSameBefore) {
                            isSame = true;
                        }else{
                            isSameBefore = false;
                        }
                        prev++;
                        next++;
                    } else if (longestPalindrome.length() == 1 || isSame) {

                        if (chars[i] == chars[i - prev]) {
                            longestPalindrome = chars[i - prev] + longestPalindrome;
                            prev++;
                        } else if (chars[i] == chars[i + next]) {
                            longestPalindrome = longestPalindrome + chars[i + next];
                            next++;
                        }
                    }
                } else if (longestPalindrome.length() == 1 || isSame) {
                    if (i - prev >= 0) {
                        if (chars[i] == chars[i - prev]) {
                            longestPalindrome = chars[i - prev] + longestPalindrome;
                            prev++;
                        }
                    } else if (i + next < chars.length) {
                        if (chars[i] == chars[i + next]) {
                            longestPalindrome = longestPalindrome + chars[i + next];
                            next++;
                        }
                    }
                }
            }
            if (longest.length() < longestPalindrome.length()) {
                longest = longestPalindrome;
            }
        }
        return longest;
    }
}
