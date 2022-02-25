package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class g5_7576 {
    static int N;
    static int M;
    static int[][] map;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int ans = 0;
    static Queue<int[]> q;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int [N][M];
        q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st =new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1) q.add(new int[]{i, j, 0});
            }
        }
        while(!q.isEmpty()){
            int[] temp = q.poll();
            ans = temp[2];
            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];
                if(nx<0||ny<0||nx>=N||ny>=M||
                        map[nx][ny]==1||map[nx][ny]==-1) continue;
                else {
                    map[nx][ny] = 1;
                    q.add(new int[]{nx, ny, temp[2]+1});
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]==0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(ans);
    }

}
