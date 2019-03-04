package com.training.algo;

public class DecodeStringRecursive {

    public String process(String str) {
        return doProcess(str, 0);
    }

    private String doProcess(String str, int pos) {
        StringBuilder result = new StringBuilder();
        StringBuilder numStr = new StringBuilder();
        for (int i=pos; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                numStr.append(c);
            } else if (c == '[') {
                int num = Integer.parseInt(numStr.toString());
                String childString = doProcess(str, i+1);
                while (num > 0) {
                    result.append(childString);
                    num--;
                }
                i = i + 1 + childString.length();
                numStr.delete(0, numStr.length());
            } else if (c == ']') {
                return result.toString();
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        DecodeStringRecursive decodeStringRecursive = new DecodeStringRecursive();
        String s = decodeStringRecursive.process("2[abc]3[cd]ef");
        System.out.println(s);
    }

}
