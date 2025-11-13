package com.leet.code.solution.s14_longestcommonprefix;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int min = strs[0].length();
        for (String str : strs) {
            if (str.length() < min) {
                min = str.length();
            }
        }
        char[] chars = strs[0].toCharArray();
        List<char[]> others = new ArrayList<>();
        for (int i = 1; i < strs.length; i++) {
            others.add(strs[i].toCharArray());
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < min; i++) {
            boolean flag = true;
            for(char[] str : others) {
                if (str[i] != chars[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                stringBuilder.append(chars[i]);
            }
            else {
                break;
            }
        }
        return stringBuilder.toString();
    }
}
