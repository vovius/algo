package com.training.algo;

public class StringPermute {

    private static void permute(String str, int start, int end) {

        if (start == end) {
            System.out.println(str);
        }
        for (int i = start; i <= end; i++) {
            str = swap(str, start, i);
            permute(str, start + 1, end);
            str = swap(str, start, i);
        }
    }

    private static String swap(String str, int first, int second) {
        char[] strArr = str.toCharArray();
        strArr[second] = str.charAt(first);
        strArr[first] = str.charAt(second);
        return new String(strArr);
    }

    public static void main(String[] args) {
        String[] cases = {"abc", "abcd"};
        for (String theCase : cases) {
            System.out.println("----");
            permute(theCase, 0, theCase.length() - 1);
        }
    }
}
