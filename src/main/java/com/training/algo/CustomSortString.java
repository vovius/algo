package com.training.algo;

class CustomSortString {
    public String customSortString(String S, String T) {
        int[] tCnt = new int[26];
        for (char c : T.toCharArray()) {
            tCnt[c-'a']++;
        }

        StringBuilder result = new StringBuilder();
        for (char c: S.toCharArray()) {
            while (tCnt[c-'a'] > 0) {
                tCnt[c-'a']--;
                result.append(c);
            }
        }

        for (char c = 'a'; c <= 'z'; ++c) {
            while (tCnt[c - 'a']-- > 0) { result.append(c); }   // group chars in T but not in S.
        }

        return result.toString();
    }
}
