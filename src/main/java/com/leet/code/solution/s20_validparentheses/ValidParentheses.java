package com.leet.code.solution.s20_validparentheses;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0){
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            } else{
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if(c == ')' && top != '('){
                    return false;
                }
                if(c == ']' && top != '['){
                    return false;
                }
                if(c == '}' && top != '{'){
                    return false;
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}
