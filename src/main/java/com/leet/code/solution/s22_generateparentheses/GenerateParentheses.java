package com.leet.code.solution.s22_generateparentheses;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        int open = 1;
        int close = 0;
        return parenthesis(open, close, n, "(");
    }

    private List<String> parenthesis(int open, int close, int n, String s) {
        if (open == n && close == n) {
            return List.of(s);
        }
        if (open == n) {
            return parenthesis(open, close + 1, n, s + ")");
        }
        if (close == n) {
            return parenthesis(open + 1, close, n, s + "(");
        }
        if (open == close) {
            return parenthesis(open + 1, close, n, s + "(");
        } else {
            return Stream.concat(parenthesis(open + 1, close, n, s + "(").stream(), parenthesis(open, close + 1, n, s + ")").stream())
                    .collect(Collectors.toList());
        }
    }

}
