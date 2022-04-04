package com.baekjoon.gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_4_3055 {
    static int R,C;
    static char[][] map;
    static boolean[][] c;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<int[]> q;
    static Queue<int[]> water;
    static int cnt = 0;
    static boolean check;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        map = new char[R][C];
        c = new boolean[R][C];
        q = new LinkedList<>();
        water = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String temp = sc.next();
            for (int j = 0; j < C; j++) {
                map[i][j] = temp.charAt(j);
                if(temp.charAt(j)=='S') q.add(new int[]{i, j});
                if(temp.charAt(j)=='*') water.add(new int[]{i, j});
            }
        }

        func();
        if(!check){
            System.out.println("KAKTUS");
        }
        else{
            System.out.println(cnt);
        }
    }
    public static void func(){
        while(true){
            cnt++;
            if(q.isEmpty()) return;
            int wSize = water.size();
            int qSize = q.size();
            for (int i = 0; i < wSize; i++) {
                int[] temp = water.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = temp[1] + dx[j];
                    int ny = temp[0] + dy[j];
                    if(nx>=0&&ny>=0&&nx<C&&ny<R&&map[ny][nx]=='.'){
                        map[ny][nx] = '*';
                        water.add(new int[]{ny,nx});
                    }
                }
            }
            for (int i = 0; i < qSize; i++) {
                int[] temp = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = temp[1] + dx[j];
                    int ny = temp[0] + dy[j];
                    if(nx>=0&&ny>=0&&nx<C&&ny<R){
                        if (map[ny][nx]=='D'){
                            check = true;
                            return;
                        }
                        if(map[ny][nx]=='.'){
                            map[ny][nx] = 'S';
                            q.add(new int[]{ny,nx});
                        }
                    }
                }
            }

        }
    }
}
