package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class d4_7465 {
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
            for (int i = 0; i < M; i++) {
                st =new StringTokenizer(br.readLine()," ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a,b);
            }
            HashSet<Integer> hs = new HashSet<>();
            for (int i = 1; i <= N; i++) {
                hs.add(findSet(i));
            }
            System.out.printf("#%d %d\n",tc,hs.size());
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
