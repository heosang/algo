package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d4_1861 {
    static int max;
    static int N;
    static int start;
    static int move;
    static int[][] map;
    static boolean v[];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            max = 0;
            start = 1234567890;
            v = new boolean[N * N + 1];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    move=1;
                    if (v[map[i][j]]) continue;
                    else func(i, j);
                    if (max<move){
                        max = move;
                        start = map[i][j];
                    }
                    else if(max==move&&map[i][j]<start) start = map[i][j];
                }
            }
            System.out.printf("#%d %d %d\n",tc,start,max);
        }

    }
    public static void func(int x, int y){
        loop1:
        while(true){
            loop2:
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx>=0&&ny>=0&&nx<N&&ny<N){
                    if(map[nx][ny]-map[x][y]==1){
                        move++;
                        x=nx;
                        y=ny;
                        v[map[x][y]]=true;
                        continue loop1;
                    }
                }
            }
            break loop1;
        }
    }
}
