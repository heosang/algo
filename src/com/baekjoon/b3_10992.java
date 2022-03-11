package com.baekjoon;

import java.util.Scanner;

public class b3_10992 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n-1; i++) {
			System.out.print(" ");
		}
		System.out.println("*");
		for (int i = 0; i < n-2; i++) {
			for (int j = 1; j < n-i-1; j++) {
				System.out.print(" ");
			}
			System.out.println("*"+' '*i+"*");
			
		}
		
		//System.out.println("*");
		for (int i = 0; i < n*2-1; i++) {
			System.out.print("*");
		}
		

	}

}
