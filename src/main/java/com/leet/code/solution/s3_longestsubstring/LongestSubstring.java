package com.leet.code.solution.s3_longestsubstring;

public class LongestSubstring {
    public int longestSubstring(String s) {
        char[] chars = s.toCharArray();
        String test = "";
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            test = chars[i] + "";
            for (int j = i + 1; j < chars.length; j++) {
                if(test.contains(chars[j] + "")) {
                    max = Math.max(max, j - i);
                    break;
                }
                test = test + chars[j];
            }
            max = Math.max(max, test.length());
        }
        return max;
    }

// TODO solve again
    public int longestSubstring2(String s) {
        int max = 0;
        char[] chars = s.toCharArray();

        for(int i = 0; i < chars.length; i++) {

        }
        return max;
    }
}
