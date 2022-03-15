package com.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class s1_13335 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int w = sc.nextInt();
		int L = sc.nextInt();
		int[] ary = new int[n];
		for (int i = 0; i < n; i++) {
			ary[i] = sc.nextInt();
		}
		int sum=0;
		int cnt=0;
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			if(q.size() == w) {
				sum-=q.poll();
			}
			if(sum+ary[i]>L) {
				q.add(0);
				i--;
			}
			else {
				q.add(ary[i]);
				sum+=ary[i];
			}
			cnt++;
		}
		System.out.println(cnt+w);
	}

}
