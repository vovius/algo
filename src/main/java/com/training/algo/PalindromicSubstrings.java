package com.training.algo;

public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        int result = 0;

        int n = s.length();
        for (int i=0; i <= 2*n-1; i++) {
            int left = i/2;
            int right = left + i%2;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                result++;
                left--;
                right++;
            }
        }

        return result;
    }
}
