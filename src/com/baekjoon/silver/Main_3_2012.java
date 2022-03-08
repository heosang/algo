package com.baekjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

public class Main_3_2012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] ary =new int[N];
        for (int i = 0; i < N; i++) {
            ary[i] = sc.nextInt();
        }
        Arrays.sort(ary);
        long ans =0;
        for (int i = 0; i < N; i++) {
            ans+=Math.abs(ary[i]-(i+1));
        }
        System.out.println(ans);
    }
}
