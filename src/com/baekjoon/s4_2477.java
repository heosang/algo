package com.baekjoon;

import java.util.Scanner;

public class s4_2477 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] ary = new int[2][6];
        int K = sc.nextInt();
        for (int i = 0; i < 6; i++) {
            ary[0][i] = sc.nextInt();
            ary[1][i] = sc.nextInt();
        }
        int maxOdd = 0;
        int maxOddIndex = 0;
        int maxEven = 0;
        int maxEvenIndex = 0;
        for (int i = 0; i < 6; i+=2) {
            if(ary[1][i]>maxOdd) {
                maxOdd = ary[1][i];
                maxOddIndex = i;
            }
            if(ary[1][i+1]>maxEven){
                maxEven = ary[1][i+1];
                maxEvenIndex = i+1;
            }
        }
        int ans = maxEven * maxOdd;
        int smallOdd;
        int smallEven;
        if(maxOddIndex==0) smallEven = Math.abs(ary[1][5]-ary[1][1]);
        else smallEven = Math.abs(ary[1][maxOddIndex+1]-ary[1][maxOddIndex-1]);
        if(maxEvenIndex==5) smallOdd = Math.abs(ary[1][4]-ary[1][0]);
        else smallOdd = Math.abs(ary[1][maxEvenIndex+1]-ary[1][maxEvenIndex-1]);
        ans -= smallOdd * smallEven;
        System.out.println(ans*K);
    }
}
