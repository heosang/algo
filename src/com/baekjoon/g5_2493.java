package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class g5_2493 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        for (int i = 0; i < N; i++) {
        	int temp = Integer.parseInt(st.nextToken());
        	while(!s1.isEmpty()) {
        		if(s1.peek()>=temp) {
        			System.out.print(s2.peek()+" ");
        			break;
        		}
        		s1.pop();
        		s2.pop();
        	}
        	if(s1.isEmpty()) System.out.print("0 ");
        	s1.push(temp);
        	s2.push(i+1);
        }
	}

}
