package com.training.algo;

import java.util.LinkedList;
import java.util.List;

public class GenerateBrackets {
    public List<String> generateParenthesis(int n) {
        char[] arr = new char[2*n];
        List<String> results = new LinkedList<>();
        process(results, arr, n, 0, 0, 0);
        return results;
    }

    private void process(List<String> results, char[] arr, int n, int pos, int open, int close) {
        if (close == n) {
            results.add(new String(arr));
            return;
        }

        if (open > close) {
            arr[pos] = ')';
            process(results, arr, n, pos+1, open, close+1);
        }

        if (open < n) {
            arr[pos] = '(';
            process(results, arr, n, pos+1, open+1, close);
        }

    }

    public static void main(String[] args) {
        GenerateBrackets generateBrackets = new GenerateBrackets();
        generateBrackets.generateParenthesis(3);
    }

}
