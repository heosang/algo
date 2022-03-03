package com.baekjoon;

import java.util.Scanner;

public class b2_2775 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] ary = new int[15][15];
		for (int i = 1; i < 15; i++) {
			ary[0][i]=i;
		}
		for (int i = 1; i < 15; i++) {
			for (int j = 1; j < 15; j++) {
					int sum = 0;
					for (int k = 1; k <= j; k++) {
						sum+=ary[i-1][k];
					}
					ary[i][j]=sum;
			}
		}
		for (int i = 0; i < T; i++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			System.out.println(ary[k][n]);
		}
		
	}

}
