package com.leet.code.solution.s9_palindromenumber;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        return x == reverse(x);
    }

    private int reverse(int x) {
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
