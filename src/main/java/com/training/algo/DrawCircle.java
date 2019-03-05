package com.training.algo;

public class DrawCircle {

    public static void process(int r) {

        for (int i = -r; i <= r; i++) {
            for (int j = -r; j <= r; j++ ) {
                if (i*i + j*j < r*r+1) {
                    System.out.print(".");
                } else {
                    System.out.print(" ");
                }

                System.out.print(" ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        process(10);
    }
}
