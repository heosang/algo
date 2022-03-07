package com.baekjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

public class Main_20044_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ary = new int[2*n];
        for (int i = 0; i < 2*n; i++) {
            ary[i] = sc.nextInt();
        }
        Arrays.sort(ary);
        int min = 1234567890;
        for (int i = 0; i < n; i++) {
            if(min>ary[i]+ary[2*n-i-1]) {
                min = ary[i]+ary[2*n-i-1];
            }
        }
        System.out.println(min);
    }
}
