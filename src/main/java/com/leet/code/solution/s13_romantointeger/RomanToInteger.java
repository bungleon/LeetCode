package com.leet.code.solution.s13_romantointeger;

public class RomanToInteger {
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int[] nums = new int[chars.length];

        Integer solution = 0;
        for (int i = 0; i < chars.length; i++) {
            nums[i] = split(chars[i]);
        }
        for (int i = 0; i < chars.length; i++) {
            if(i+1<chars.length) {
                if (nums[i] < nums[i + 1]) {
                    solution = solution + nums[i + 1] - nums[i];
                    i++;
                }
                else{
                    solution = solution + nums[i];
                }
            }
            else{
                solution = solution + nums[i];
            }
        }

        return solution;
    }

    private int split(char s) {
        return switch (s) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }
}
