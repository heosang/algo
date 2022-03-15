package com.baekjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class s3_9375 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int n = sc.nextInt();
			int ans=1;
			Map<String, Integer> map = new HashMap<String, Integer>();
			for (int i = 0; i < n; i++) {
				String name = sc.next();
				String kind = sc.next();
				if(map.get(kind)==null) {
					map.put(kind,1);
				}
				else {
					map.put(kind, map.get(kind)+1);
				}
			}
			for (int i : map.values()) {
				ans *= (i+1);
			}
			System.out.println(ans-1);
		}
		
	}

}
