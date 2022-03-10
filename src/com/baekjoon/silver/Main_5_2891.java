package com.baekjoon.silver;

import java.util.Scanner;

public class Main_5_2891 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();
        int R = sc.nextInt();
        int ans = 0;
        int[] ary = new int [N+1];
        for (int i = 0; i <= N; i++) {
            ary[i]=1;
        }
        for (int i = 0; i < S; i++) {
            ary[sc.nextInt()] = 0;
        }
        for (int i = 0; i < R; i++) {
            ary[sc.nextInt()]++;
        }
        if(ary[N]==0 && ary[N-1]==2){
            ary[N]++;
            ary[N-1]--;
        }
        for (int i = 1; i < N; i++) {
            if(ary[i]==2){
                if(ary[i+1]==2){
                    ary[i+1]--;
                    ary[i]++;
                }
                else if(ary[i-1]==2){
                    ary[i-1]--;
                    ary[i]++;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if(ary[i]==0){
                ans++;
            }
        }
        for (int i = 1; i <= N; i++) {
            System.out.print(ary[i]);
        }
        System.out.println();
        System.out.println(ans);
    }

}
