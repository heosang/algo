package com.baekjoon;

import java.util.Scanner;

public class b2_10870 {
	
	public static int func(int n) {
		if (n == 0) return 0;
		else if (n == 1) return 1;
		else return func(n-1) + func(n-2);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.print(func(n));

	}

}
