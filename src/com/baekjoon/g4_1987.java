package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class g4_1987 {

	static int R;
	static int C;
	static int ans = 0;
	static char[][] map;
	static boolean[] v = new boolean[26];
	static int[] dx = { 1, -1, 0, 0 }; 
	static int[] dy = { 0, 0, 1, -1 };


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char [R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		func(0, 0, 1);
		System.out.println(ans);
	}
	public static void func(int x, int y, int cnt) {
		if(v[map[x][y]-'A']==true) {
			if(cnt>ans) ans = cnt-1;
			return;
		}
		v[map[x][y]-'A']=true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];		
			if(nx>=0&&nx<R&&ny>=0&&ny<C) {
				func(nx,ny,cnt+1);
			}
		}
		v[map[x][y]-'A']=false;
	}

}
