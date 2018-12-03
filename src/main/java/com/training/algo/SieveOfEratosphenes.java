package com.training.algo;

public class SieveOfEratosphenes {

    public static void process(int n) {
        boolean[] marks = new boolean[n];
        for (int i=0; i < n; i++) {
            marks[i] = false;
        }

        for (int i=2 ; i*i <= n; i++) {
            if (marks[i]) {
                continue;
            }

            for (int j=i*i; j < n; j += i) {
                marks[j] = true;
            }
        }


        for (int i=1; i < n; i++) {
            if (!marks[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        process(50);
    }
}
