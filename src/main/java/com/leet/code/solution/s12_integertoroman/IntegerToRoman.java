package com.leet.code.solution.s12_integertoroman;

import java.util.ArrayList;
import java.util.List;

public class IntegerToRoman {
    public String intToRoman(int num) {
        List<String> list = new ArrayList<>();
        int count = 0;
        while (num > 0) {
            int remainder = num % 10;
            num /= 10;
            list.add(split(remainder, count));
            count++;
        }
        StringBuilder s = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            s.append(list.get(i));
        }

        return s.toString();
    }

    private String split(int num, int count) {
        if (count == 0) {
            return switch (num) {
                case 1 -> "I";
                case 2 -> "II";
                case 3 -> "III";
                case 4 -> "IV";
                case 5 -> "V";
                case 6 -> "VI";
                case 7 -> "VII";
                case 8 -> "VIII";
                case 9 -> "IX";
                default -> "";
            };
        }
        if (count == 1) {
            return switch (num) {
                case 1 -> "X";
                case 2 -> "XX";
                case 3 -> "XXX";
                case 4 -> "XL";
                case 5 -> "L";
                case 6 -> "LX";
                case 7 -> "LXX";
                case 8 -> "LXXX";
                case 9 -> "XC";
                default -> "";
            };
        }
        if (count == 2) {
            return switch (num) {
                case 1 -> "C";
                case 2 -> "CC";
                case 3 -> "CCC";
                case 4 -> "CD";
                case 5 -> "D";
                case 6 -> "DC";
                case 7 -> "DCC";
                case 8 -> "DCCC";
                case 9 -> "CM";
                default -> "";
            };
        }
        if (count == 3) {
            return switch (num) {
                case 1 -> "M";
                case 2 -> "MM";
                case 3 -> "MMM";
                case 4 -> "MMMM";
                default -> "";
            };
        }
        return "";
    }
}
