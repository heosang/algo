package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class g4_17144 {
    static int R,C,T;
    static int[][] map;
    static int Ar1, Ar2;
    static Queue<int[]> q;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int ans = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        q = new LinkedList<>();
        boolean airC =false;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1&& !airC){
                    Ar1 = i;
                    Ar2 = i+1;
                    airC = true;
                    continue;
                }
                if (map[i][j] != 0 && map[i][j] != -1){
                    q.add(new int[]{i,j});
                }
            }
        }
        int t=0;
        while(t!=T){
            int size =q.size();
            int[][] tempMap = new int[R][C];
            for (int i = 0; i < size; i++) {
                int[] temp = q.poll();
                int x = temp[0];
                int y = temp[1];
                int distCnt=0;
                for (int j = 0; j < 4; j++) {
                    int nx = temp[0] + dx[j];
                    int ny = temp[1] + dy[j];
                    if(nx<0||ny<0||nx>=R||ny>=C||map[nx][ny]==-1) continue;
                    else {
                        distCnt++;
                        tempMap[nx][ny] += map[x][y]/5;
                    }
                }
                tempMap[x][y] += map[x][y]-map[x][y]/5*distCnt;
            }
            for (int i = Ar1-1; i >= 0; i--) {
                tempMap[i + 1][0] = tempMap[i][0];
            }
            for (int i = 1; i < C ; i++) {
                tempMap[0][i-1] = tempMap[0][i];
            }
            for (int i = 1; i <= Ar1 ; i++) {
                tempMap[i-1][C-1] = tempMap[i][C-1];
            }
            for (int i = C-2; i >= 0; i--) {
                tempMap[Ar1][i+1] = tempMap[Ar1][i];
            }

            for (int i = Ar2+1; i < R; i++) {
                 tempMap[i - 1][0] = tempMap[i][0];
            }
            for (int i = 1; i < C; i++) {
                tempMap[R-1][i-1] = tempMap[R-1][i];
            }
            for (int i = R-2; i >= Ar2; i--) {
                tempMap[i+1][C-1] = tempMap[i][C-1];
            }
            for (int i = C-2; i >= 0; i--) {
                tempMap[Ar2][i+1] = tempMap[Ar2][i];
            }
            tempMap[Ar1][0] =-1;
            tempMap[Ar2][0] =-1;
            tempMap[Ar1][1] =0;
            tempMap[Ar2][1] =0;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    map[i][j] = tempMap[i][j];
                }
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if(map[i][j]!=-1&&map[i][j]!=0) q.add(new int[]{i,j});
                }
            }
            t++;
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j]!=-1) {
                    ans+=map[i][j];
                }
            }
        }
        System.out.println(ans);
    }
}
