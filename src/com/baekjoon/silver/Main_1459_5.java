package com.baekjoon.silver;

import java.util.Scanner;

public class Main_1459_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long X = sc.nextInt();
        long Y = sc.nextInt();
        long W = sc.nextInt();
        long S = sc.nextInt();
        long temp1 = (X + Y) * W;
        long temp2;
        long temp3;
        if((X + Y) % 2 == 0) {
            temp2 = Math.max(X, Y) * S;
        }
        else {
            temp2 = (Math.max(X, Y) - 1) * S + W;
        }
        temp3 = (Math.min(X, Y) * S) + (Math.abs(X - Y) * W);
        System.out.println(Math.min(Math.min(temp1, temp2), temp3));
    }
}
