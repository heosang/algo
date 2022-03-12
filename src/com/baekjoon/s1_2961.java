package com.baekjoon;

import java.util.Scanner;

public class s1_2961 {
	static int min = Integer.MAX_VALUE;
	static int N;
	static int[] sour;
	static int[] bitter;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sour = new int[N];
		bitter = new int[N];
		for (int i = 0; i < N; i++) {
			sour[i] = sc.nextInt();
			bitter[i] = sc.nextInt();
		}
		func(0, 1, 0, 0);
		System.out.println(min);
	}
	
	public static void func(int cnt, int s, int b, int t) {
		if(cnt==N) {
            if (t!=0) min = Math.min(min, Math.abs(s-b));	
			return;
		}
		func(cnt+1, s*sour[cnt], b+bitter[cnt], t+1);
		func(cnt+1, s, b, t);	
	}
}
