package com.training.algo;

// Class name must be "Main"
// Libraries included:
// json simple, guava, apache commons lang3, junit, jmock
/**

 Given an encoded string, return it's decoded string.

 The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

 You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

 Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

 s = "3[a]2[bc]", return "aaabcbc".
 s = "3[a2[c]]", return "accaccacc".
 s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */

import java.util.*;

class DecodeString {

    static class Node {
        int num;
        char c;
        boolean isList;
        List<Node> list;

        Node(int i) {
            this.num = i;
            isList = true;
            list = new LinkedList<>();
        }
        Node(char c) {this.c = c;}
    }

    public static String process(String s) {
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(1));

        int i=0;
        String ss = "";
        while (i < s.length()) {

            char c = s.charAt(i);
            if (isNumber(c)) {
                ss = ss + c;
            } else if (c == '[') {
                if (!ss.isEmpty()) {
                    int num = Integer.parseInt(ss);
                    stack.push(new Node(num));
                    ss = "";
                }
            } else if (c == ']') {
                Node node = stack.pop();
                if (!stack.isEmpty()) {
                    stack.peek().list.add(node);
                }
            } else {
                stack.peek().list.add(new Node(c));
            }

            i++;
        }

        return formString(stack.peek());
    }

    private static String formString(Node node) {
        StringBuilder result = new StringBuilder();

        if (node.isList) {
            for (int i=0; i < node.num; i++) {
                for (Node n : node.list) {
                    result.append(formString(n));
                }
            }
        } else {
            result.append(node.c);
        }

        return result.toString();
    }

    private static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        String s = process("2[abc]3[cd]ef");
        System.out.println(s);
    }
}