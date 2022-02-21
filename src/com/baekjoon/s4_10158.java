package com.baekjoon;

import java.util.Scanner;

public class s4_10158 {
    static int[] dx={1,1,-1,-1};
    static int[] dy={1,-1,1,-1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        int t = sc.nextInt();
        int x = (q+t)%(2*w);
        int y = (p+t)%(2*h);

        x = w - Math.abs(w-x);
        y = h - Math.abs(h-y);

        System.out.println(x+" "+y);
    }
}
