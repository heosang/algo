package com.baekjoon;

import java.util.Scanner;

public class s2_14889 {
    static boolean[] startV;
    static int min =1234567890;
    static int N;
    static int [][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        startV = new boolean[N];
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        func(0,0);
        System.out.println(min);
    }
    public static void func(int cnt, int start){
        if(cnt==N/2){
            int startSum=0;
            int linkSum=0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(startV[i]&&startV[j]){
                        startSum+=map[i][j];
                    }
                    else if(!startV[i]&&!startV[j]){
                        linkSum+=map[i][j];
                    }
                }
            }
            min = Math.min(Math.abs(startSum-linkSum),min);
            return;
        }
        for (int i = start; i < N; i++) {
            startV[i]=true;
            func(cnt+1,i+1);
            startV[i]=false;
        }
    }
}
