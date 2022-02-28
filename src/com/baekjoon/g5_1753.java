package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class g5_1753 {
    static final int INF = Integer.MAX_VALUE;
    static int v, e;
    static int[] dist;//시작정점~해당정점까지의 최단경로
    static List<List<Edge>> list;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int v = Integer.parseInt(st.nextToken()); // 정점 갯수
        int e = Integer.parseInt(st.nextToken()); // 간선 갯수
        int start = Integer.parseInt(br.readLine()); // 시작점

        list = new ArrayList<List<Edge>>();
        //new ArrayList<Edge>[3];//x
        //new ArrayList[3];//o

        dist = new int[v+1];//시작정점~해당정점까지의 최단경로
        Arrays.fill(dist, INF);

        for (int i = 0; i <= v; i++) {
            list.add(new ArrayList<Edge>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());//5 1 1

            list.get(from).add(new Edge(to, weight));//from -> to로 가는 간선이 존재. 가중치는 weight
        }//input

        dist[start] = 0;//
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();//제일 작은 비중값을 사용하려고
        pq.add(new Edge(start, 0));

        while(!pq.isEmpty()) {
            Edge one = pq.poll();//이 정점과 연결된 다른 정점 중에서 최소비용을 갖는 정점을 조사

            for(Edge node: list.get(one.no)) {
                if(dist[node.no] > dist[one.no] + node.weight) {
                    dist[node.no] = dist[one.no] + node.weight;//update
                    pq.add(new Edge(node.no, dist[node.no]));
                }
            }
        }
        for (int i = 1; i <= v; i++) {
            if(dist[i] == INF)
                System.out.println("INF");
            else
                System.out.println(dist[i]);
        }
    }

    static class Edge implements Comparable<Edge>{
        int no, weight;//no(to)

        public Edge(int no, int weight) {
            this.no = no;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static String src = "5 6\r\n" +
            "1\r\n" +
            "5 1 1\r\n" +
            "1 2 2\r\n" +
            "1 3 3\r\n" +
            "2 3 4\r\n" +
            "2 4 5\r\n" +
            "3 4 6";

}
