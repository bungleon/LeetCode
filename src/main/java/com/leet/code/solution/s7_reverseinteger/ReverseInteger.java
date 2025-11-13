package com.leet.code.solution.s7_reverseinteger;

public class ReverseInteger {
    public int reverse(int x) {
        long remaining = x;
        long converted = 0;
        if (x > Math.pow(2, 31) - 1) {
            return 0;
        }
        if (x < -Math.pow(2, 31)) {
            return 0;
        }
        boolean negative = false;
        if (x < 0) {
            negative = true;
            remaining *= -1;
        }
        while (remaining != 0) {
            long digit = remaining % 10;
            remaining = (remaining - digit) / 10;
            converted = converted * 10 + digit;
        }
        if (converted > Math.pow(2, 31) - 1) {
            return 0;
        }
        if (converted < -Math.pow(2, 31)) {
            return 0;
        }
        if (negative) {
            return -(int) converted;
        }

        return (int) converted;
    }


    public int reverse2(int x) {
        int ans = 0;
        for (; x != 0; x /= 10) {
            if (ans < Integer.MIN_VALUE / 10 || ans > Integer.MAX_VALUE / 10) {
                return 0;
            }
            ans = ans * 10 + x % 10;
        }
        return ans;
    }
}
