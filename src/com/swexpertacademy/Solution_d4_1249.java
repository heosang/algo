package com.swexpertacademy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Solution_d4_1249 {
    static int T,N;
    static int[][] map, sum;
    static int INF = 1234567890;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            map = new int[N][N];
            sum = new int[N][N];
            for (int i = 0; i < N; i++) {
                String temp = sc.next();
                for (int j = 0; j < N; j++) {
                    map[i][j] = temp.charAt(j) - '0';
                    sum[i][j] = INF;
                }
            }
            Queue<int[]> q = new LinkedList<>();
            sum[0][0] = 0;
            q.add(new int[]{0,0});
            while(!q.isEmpty()){
                int[] t = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = t[0] + dx[i];
                    int ny = t[1] + dy[i];
                    if(nx<0||ny<0||nx>=N||ny>=N) continue;

                    if(sum[nx][ny]>map[nx][ny]+sum[t[0]][t[1]]){
                        sum[nx][ny]=map[nx][ny]+sum[t[0]][t[1]];
                        q.add(new int[]{nx,ny});
                    }

                }
            }
            System.out.println("#" + tc + " " + sum[N-1][N-1]);
        }
    }
}