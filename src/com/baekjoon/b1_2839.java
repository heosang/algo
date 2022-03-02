package com.baekjoon;

import java.util.Scanner;

public class b1_2839 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int min = 1234567890;
		for (int i = 0; i <= n/5; i++) {
			int temp = n - 5*i;
			if(temp%3==0) {
				if(min>i + temp/3) min = i + temp/3;
			}
		}
		if(min == 1234567890) System.out.print(-1);
		else System.out.print(min);
		
	}

}
