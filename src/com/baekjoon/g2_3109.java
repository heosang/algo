package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class g2_3109 {
	static int R;
	static int C;
	static int ans = 0;
	static char[][] map;
	static boolean check = false;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char [R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < R; i++) {
			check = false;
			func(i,0);
		}
		System.out.println(ans);
	}
	public static void func(int r, int c) {
		if(c==C-1) {
			ans++;
			check = true;
			return ;
		}
		for (int i = -1; i <= 1; i++) {
			if(r+i>=0&&r+i<R&&map[r+i][c+1]=='.') {
				map[r+i][c+1]='x';
				func(r+i,c+1);
				if(check) {					
					return;
				}
			}
		}
	}
}
