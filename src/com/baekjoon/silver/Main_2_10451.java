package com.baekjoon.silver;

import java.util.Scanner;

public class Main_2_10451 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] ary = new int[N+1][N+1];
            boolean[] c = new boolean[N+1];
            int ans=0;
            for (int i = 1; i <= N; i++) {
                ary[0][i] = i;
                ary[1][i] = sc.nextInt();
            }
            for (int i = 1; i <= N; i++) {
                if(c[i]) continue;
                if(ary[0][i]==ary[1][i]){
                    ans++;
                    c[i] = true;
                    continue;
                }
                int temp = ary[1][i];
                c[temp] = true;
                while(temp!=i){
                    temp = ary[1][temp];
                    c[temp] = true;
                }
                ans++;
            }
            System.out.println(ans);
        }
    }
}
