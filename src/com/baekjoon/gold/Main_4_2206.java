package com.baekjoon.gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_4_2206 {
    static int N, M;
    static int dx[] = {0, -1, 0, 1};
    static int dy[] = {-1, 0, 1, 0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        if(N==1 && M==1){
            System.out.println(1);
            return;
        }
        char[][] miro = new char[N][M];
        int[][] dist = new int[N][M];
        boolean[][][] v = new boolean[2][N][M];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String temp = sc.next();
            for (int j = 0; j < M; j++) {
                miro[i][j] = temp.charAt(j);
            }
        }
        q.add(new int[]{0, 0, 0});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx< 0 || ny<0 ||nx>=N||ny>=M) continue;
                if (miro[nx][ny] == '1') {
                    if(cur[2] == 0 && !v[1][nx][ny]){
                        v[cur[2]][nx][ny] = true;
                        dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                        q.add(new int[]{nx, ny, 1});
                    }
                }
                else{
                    if(!v[cur[2]][nx][ny]){
                    v[cur[2]][nx][ny] = true;
                    dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{nx, ny, cur[2]});
                    }
                }
                if(nx==N-1&&ny==M-1){
                    System.out.print(dist[nx][ny] + 1);
                    return;
                }
            }
        }
        System.out.println(-1);

    }
}
