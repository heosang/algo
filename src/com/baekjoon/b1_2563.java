package com.baekjoon;

import java.util.Scanner;

public class b1_2563 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean[][] map = new boolean[101][101];
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int j = x; j < x+10; j++) {
				for (int k = y; k < y+10; k++) {
					map[j][k]=true;
				}
			}
		}
		int ans=0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(map[i][j]==true)ans++;
			}
		}
		System.out.println(ans);
	}

}
