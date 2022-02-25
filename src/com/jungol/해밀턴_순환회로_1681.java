package com.jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 해밀턴_순환회로_1681 {
    static int N;
    static int adjM[][];
    static boolean v[];
    static int ans=Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adjM=new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                adjM[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        v = new boolean[N];
        v[0] = true;
        func(0,0,0);
        System.out.println(ans);
    }
    private static void func(int cnt, int cur,int sum) {
        if(sum>ans)return;
        if(cnt==N) {
            if(adjM[cur][0]!=0 && ans>sum+adjM[cur][0]) {
                ans=sum+adjM[cur][0];
            }
            return;
        }
        for (int i = 1; i < N; i++) {
            if(adjM[cur][i]==0 || v[i]) continue;
            v[i]=true;
            func(cnt+1,i,sum+adjM[cur][i]);
            v[i]=false;
        }
    }
}