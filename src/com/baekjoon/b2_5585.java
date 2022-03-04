package com.baekjoon;

import java.util.Scanner;

public class b2_5585 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = 1000 - sc.nextInt();
        int ans = 0;
        ans += money/500;
        money = money%500;
        ans += money/100;
        money = money%100;
        ans += money/50;
        money = money%50;
        ans += money/10;
        money = money%10;
        ans += money/5;
        money = money%5;
        ans += money/1;
        money = money%1;
        System.out.println(ans);

    }
}
