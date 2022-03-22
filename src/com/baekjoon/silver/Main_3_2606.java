package com.baekjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_3_2606 {
    static int comN;
    static int pairN;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        comN = sc.nextInt();
        pairN = sc.nextInt();
        boolean[] c = new boolean[comN+1];
        c[1] = true;
        int[][] adjM = new int[comN+1][comN+1];
        for (int i = 0; i < pairN; i++) {
            int tempA = sc.nextInt();
            int tempB = sc.nextInt();
            adjM[tempA][tempB] = 1;
            adjM[tempB][tempA] = 1;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while(!q.isEmpty()){
            int temp = q.poll();
            for (int i = 1; i <= comN ; i++) {
                if(adjM[temp][i]==1){
                    if(c[i]) continue;
                    else{
                        c[i] = true;
                        q.add(i);
                    }
                }
            }
        }
        int ans =0;
        for (int i = 2; i <= comN; i++) {
            if(c[i]) ans++;
        }
        System.out.println(ans);
    }
}
