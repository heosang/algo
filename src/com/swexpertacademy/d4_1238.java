package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class d4_1238 {
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            StringTokenizer st =new StringTokenizer(br.readLine()," ");
            int length = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine()," ");
            map = new int[101][101];
            for (int i = 0; i < length/2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                map[from][to] = 1;
            }

            System.out.printf("#%d %d\n",tc,func(start));
        }
    }
    public static int func(int start){
        int[] v = new int[101];
        int ans = 0;
        Queue<Integer> q= new LinkedList<Integer>();
        q.add(start);
        v[start] = 1;
        while(!q.isEmpty()){
            int temp = q.poll();
            for (int i = 1; i <= 100; i++) {
                if (map[temp][i] == 1 && v[i] == 0) {
                    v[i] = v[temp] + 1;
                    q.add(i);
                }
            }
        }
        for (int i = 1; i <= 100; i++) {
            if(v[i]>=v[ans]&&i>ans) ans = i;
        }
        return ans;
    }
}
