package com.baekjoon;

import java.util.Scanner;

public class b2_3040 {
	static int ary[] = new int[9];
	static int ans[] = new int[7];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 9; i++) {
			ary[i] = sc.nextInt();
		}
		func(0, 0);
	}
	
	static void func(int cnt, int start) {
		if(cnt == 7) {
			int sum = 0;
			for(int i=0;i<7;i++) {
				sum += ans[i];
			}			
			if(sum == 100) {
				for(int i = 0; i < 7; i++) {
					System.out.println(ans[i]);
				}				
			}
			return;
		}
		for(int i = start; i < 9; i++) {
			ans[cnt] = ary[i];
			func(cnt+1, i+1);
		}
	}
}
