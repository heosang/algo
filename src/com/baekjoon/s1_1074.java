package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s1_1074 {
	static int ans = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int length = (int)Math.pow(2, N);
		func(length, r, c);
		System.out.println(ans);
	}
	public static void func(int length, int r, int c) {
		if(length == 1) return ;
		if(r<length/2 && c<length/2) {
			func(length/2, r, c);
		}
		else if (r<length/2 && c>=length/2) {
			ans += length*length/4;
			func(length/2, r, c-length/2);
		}
		else if (r>=length/2 && c<length/2) {
			ans += length*length/4*2;
			func(length/2, r-length/2, c);
		}
		else {
			ans += length*length/4*3;
			func(length/2, r-length/2, c-length/2);
		}
	}
}
