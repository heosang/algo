package com.baekjoon.gold;

import java.util.*;

public class Main_4_4485 {
    static int[][] map, ans;
    static int N;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t = 1;
        while (true) {
            N = sc.nextInt();
            if (N == 0) return;
            map = new int[N][N];
            ans = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                    ans[i][j] = 1234567890;
                }
            }
            ans[0][0] = map[0][0];
            func();
            System.out.println("Problem "+t+": "+ans[N - 1][N - 1]);
            t++;
        }
    }

    private static void func() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,map[0][0]});
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];
                if (nx>=0 && ny>=0 && nx<N && ny<N){
                    if (ans[nx][ny] > ans[temp[0]][temp[1]] + map[nx][ny]){
                        ans[nx][ny] = ans[temp[0]][temp[1]] + map[nx][ny];
                        q.add(new int[]{nx, ny,map[nx][ny]});
                    }
                }

            }
        }
    }

}