package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d4_3289 {
    static int [] parent;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st =new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            parent = new int[N+1];
            for ( int i=1; i<= N; i++) {
                parent[i] = i;
            }
            System.out.printf("#%d ",tc);
            for (int i = 0; i < M; i++) {
                st =new StringTokenizer(br.readLine()," ");
                int temp = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (temp == 1){
                    if(findSet(a)==findSet(b)) System.out.print(1);
                    else System.out.print(0);
                }
                else union(a,b);
            }
            System.out.println();
        }
    }
    public static int findSet(int t){
        if(parent[t]==t) return t;
        else return findSet(parent[t]);
    }
    public static void union(int a, int b){
        a = findSet(a);
        b = findSet(b);
        if(a>b) parent[a] = b;
        else parent[b] = a;
    }
}

