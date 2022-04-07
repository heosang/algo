package com.jungol;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_화염에서탈출_1082 {
    static int R, C, endR, endC;
    static char map[][];
    static boolean v[][];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        map = new char[R][C];
        v = new boolean[R][C];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            String temp = sc.next();
            for (int j = 0; j < C; j++) {
                map[i][j] = temp.charAt(j);
                if (map[i][j] == 'D') {
                    endR = i;
                    endC = j;
                }
                if (map[i][j] == '*') {
                    v[i][j] = true;
                    q.add(new int[] { i, j, 0});
                }
                if (map[i][j] == 'S') {
                    v[i][j] = true;
                    q.add(new int[] { i, j, 0});
                }
            }
        }

        while (!q.isEmpty()) {
            int cur[] = q.poll();
            if (map[cur[0]][cur[1]] == 'S') {
                for (int i = 0; i < 4; i++) {
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];
                    if (nx >= 0 && ny >= 0 && nx < R && ny < C && !v[nx][ny]) {
                        if (map[nx][ny] == 'D'){
                            System.out.println(cur[2]+1);
                            return;
                        }
                        else if (map[nx][ny] == '.'){
                            v[nx][ny] = true;
                            map[nx][ny] = 'S';
                            q.add(new int[] {nx, ny, cur[2]+1});
                        }

                    }
                }
            } else if (map[cur[0]][cur[1]] == '*') {
                for (int i = 0; i < 4; i++) {
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];
                    if (nx >= 0 && ny >= 0 && nx < R && ny < C && map[nx][ny] == '.' && !v[nx][ny]) {
                        v[nx][ny] = true;
                        map[nx][ny] = '*';
                        q.add(new int[] {nx, ny, cur[2]});
                    }
                }
            }
        }
        System.out.println("impossible");
    }
}