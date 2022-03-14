package com.baekjoon;

import java.util.Scanner;

public class s1_7568 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();		
		int[] weight = new int[N];
		int[] height = new int[N];
		int[] rank = new int[N];
		for (int i = 0; i < N; i++) {
			weight[i]=sc.nextInt();
			height[i]=sc.nextInt();
		}
		for (int i = 0; i < N; i++) {
			int temp_rank = 1;
			for (int j = 0; j < N; j++) {
				if(weight[i]>=weight[j]|| height[i]>=height[j]) ;
				else temp_rank++;
			}
			rank[i] = temp_rank;
		}
		for (int i = 0; i < N; i++) {
			System.out.print(rank[i]+" ");			
		}
	}

}
