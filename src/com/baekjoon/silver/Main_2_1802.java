package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2_1802 {
    static String str;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            str = st.nextToken();
            String temp = String.copyValueOf(str.toCharArray());
            boolean c = true;
            while(true){
                int mid = temp.length()/2;
                if(mid==0) break;
                for (int j = 0; j < mid; j++) {
                    if(temp.charAt(j)==temp.charAt(temp.length()-j-1)) {
                        c = false;
                        break;
                    }
                }
                if(!c){
                    System.out.println("NO");
                    break;
                }
                else {
                    temp = temp.substring(0, mid);
                }
            }
            if(c){
                System.out.println("YES");
            }
        }
    }
}
