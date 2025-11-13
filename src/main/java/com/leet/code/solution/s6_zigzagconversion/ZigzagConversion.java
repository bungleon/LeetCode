package com.leet.code.solution.s6_zigzagconversion;

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        boolean even = true;
        int numRow = 0;
        String[] retValue = new String[numRows];

        for(int i = 0; i < numRows; i++) {
            retValue[i] = "";
        }

        for (int i = 0; i < chars.length; i++) {
            if (even) {
                retValue[numRow]+=(chars[i]);
                numRow++;
                if(numRow == numRows) {
                    even = false;
                    numRow-=2;
                }
            }
            else {
                retValue[numRow]+=(chars[i]);
                numRow--;
                if(numRow == -1) {
                    even = true;
                    numRow+=2;
                }
            }
        }
        String ss = "";
        for(int i = 0; i < numRows; i++) {
            ss += retValue[i].toString();
        }
        return ss;
    }
}
