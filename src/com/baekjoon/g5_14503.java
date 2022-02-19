package com.baekjoon;

import java.util.Scanner;

public class g5_14503 {
    static int N;
    static int M;
    static int[][] map;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static int ans =0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int [N][M];
        int r = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        func(r,c,d);
        System.out.println(ans);
    }
    public static void func(int r, int c, int d){
        if(map[r][c]==0){
            map[r][c]=2;
            ans++;
        }
        boolean check=false;
        int origin = d;
        for (int i = 0; i < 4; i++) {
            int nd = (d+3) % 4;
            int nr = r + dr[nd];
            int nc = c + dc[nd];
            if(nr>0&&nc>0&&nr<N-1&&nc<M-1){
                if(map[nr][nc]==0){
                    func(nr,nc,nd);
                    check=true;
                    break;
                }
            }
            d = (d+3)%4;
        }
        if(!check){
            int nd = (origin+2)%4;
            int nr = r + dr[nd];
            int nc = c + dc[nd];
            if(nr>0&&nc>0&&nr<N-1&&nc<M-1){
                if(map[nr][nc]!=1){
                    func(nr,nc,origin);
                }
            }
        }

    }
}
