package com.training.algo;

import java.util.Stack;

public class CalcBraces {

    public static boolean verify(String input) {
        Stack<Character> stack = new Stack<>();

        for (char i : input.toCharArray()) {
            if (!isBrace(i)) {
                continue;
            }

            if (i == '(' || i == '[' || i == '{') {
                stack.push(i);
            }

            if (i == ')' || i == ']' || i == '}') {
                char latest = stack.peek();
                if (!matches(latest, i)) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.empty();
    }

    public static int calc(String input) {
        Stack<Character> stack = new Stack<>();

        int count = 0;
        for (char i : input.toCharArray()) {
            if (!isBrace(i)) {
                continue;
            }

            if (i == '(' || i == '[' || i == '{') {
                stack.push(i);
            }

            if (i == ')' || i == ']' || i == '}') {
                char latest = stack.peek();
                if (matches(latest, i)) {
                    count++;
                }

                stack.pop();
            }
        }

        return count;
    }



    private static boolean isBrace(char ch) {
        return ch == '(' || ch == '[' || ch == '{' || ch == ')' || ch == ']' || ch == '}';
    }

    private static boolean matches(char opening, char closing) {
        return opening == '(' && closing == ')' ||
               opening == '[' && closing == ']' ||
               opening == '{' && closing == '}';
    }

    public static void main(String[] args) {
        String[] cases = {"[](){}[[]]", "[{]}", "[{()]}", "[{()}]", "[{()}]"};
        for (String theCase : cases) {
            print(theCase);

        }
    }


    private static void print(String string) {
        System.out.println(string + ", " + verify(string) + ", " + calc(string));
    }
}
