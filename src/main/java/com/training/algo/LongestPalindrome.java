package com.training.algo;

class LongestPalindrome {
    public String longestPalindrome(String s) {
        String result = "";
        for (int i=0; i < s.length(); i++) {
            String pal = isPalindrome(s, i, i);
            if (pal.length() > result.length()) {
                result = pal;
            }

            if (i+1 < s.length()) {
                String pal1 = isPalindrome(s, i, i+1);
                if (pal1.length() > result.length()) {
                    result = pal1;
                }
            }
        }
        return result;
    }

    private String isPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left+1, right);
    }
}
