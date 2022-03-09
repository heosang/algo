package com.baekjoon.silver;

import java.util.Scanner;

public class Main_4_1543 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String ary = sc.nextLine();
        String word = sc.nextLine();
        int ans = 0;
        for (int i = 0; i < ary.length()-word.length()+1; i++) {
            boolean c = true;
            for (int j = 0; j < word.length(); j++) {
                if(word.charAt(j)!=ary.charAt(i+j)) {
                    c=false;
                    break;
                }
            }
            if(c){
                ans++;
                i+=word.length()-1;
            }
        }
        System.out.println(ans);
    }
}
