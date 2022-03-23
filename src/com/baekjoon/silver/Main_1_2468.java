package com.baekjoon.silver;

import java.util.Scanner;

public class Main_1_2468 {
    static int N;
    static int[][] map;
    static boolean[][] c;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        int highest = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] =sc.nextInt();
                if(map[i][j]>highest) highest = map[i][j];
            }
        }
        for (int i = 0; i < highest; i++) {
            int cnt = 0;
            c = new boolean[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if(map[j][k]>i && !c[j][k]) {
                        c[j][k] = true;
                        func(j, k, i);
                        cnt++;
                    }
                }
            }
            if(cnt>max) max = cnt;
        }
        System.out.println(max);
    }

    public static void func(int x, int y, int limit) {
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && ny>=0 && nx<N && ny<N) {
                if(map[nx][ny] > limit && !c[nx][ny]) {
                    c[nx][ny] = true;
                    func(nx, ny, limit);
                }
            }
        }
    }

}
