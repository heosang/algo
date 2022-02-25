package com.swexpertacademy;

import java.util.PriorityQueue;
import java.util.Scanner;

class Tunnel implements Comparable<Tunnel>{
    int a;
    int b;
    double d;
    public Tunnel(int a,int b, double d) {
        this.a = a;
        this.b = b;
        this.d = d;
    }
    @Override
    public int compareTo(Tunnel o) {
        return (int)(this.d-o.d);
    }
}

public class d4_1251 {
    static int N;
    static double E;
    static int [] parent;
    static int[] x;
    static int[] y;
    static double ans;

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T ; tc++) {
            ans = 0;
            N = sc.nextInt();
            parent = new int[N+1];
            x = new int[N];
            y = new int[N];
            PriorityQueue<Tunnel> tunnel = new PriorityQueue<>();
            for (int i = 1; i <= N; i++) parent[i]=i;
            for (int i = 0; i < N; i++) x[i]=sc.nextInt();
            for (int i = 0; i < N; i++) y[i]=sc.nextInt();
            E = sc.nextDouble();
            for (int i = 0; i < N; i++) {
                for (int j = i+1; j < N; j++) {
                    int dx=x[i]-x[j];
                    int dy=y[i]-y[j];
                    double dist=Math.pow(dx,2)+Math.pow(dy, 2);
                    tunnel.add(new Tunnel(i+1,j+1,dist));
                }
            }
            int length = tunnel.size();
            for (int i = 0; i < length; i++) {
                Tunnel cur = tunnel.poll();
                union(cur);
            }
            System.out.printf("#%d %.0f\n",tc,ans);
        }

    }
    public static void union(Tunnel tu){
        int a = find(tu.a);
        int b = find(tu.b);
        if(a!=b){
            ans += E*tu.d;
            if (a>b) parent[a]=b;
            else parent[b]=a;
        }
    }
    public static int find(int x){
        if(x==parent[x])return x;
        else {
            return parent[x] = find(parent[x]);
        }
    }
}
