package com.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class g5_1759 {
    static int L;
    static int C;
    static char[] ans;
    static char[] ary;
    static boolean[] v;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        ary = new char[C];
        ans = new char[L];
        for(int i=0; i<C; i++){
            ary[i] = sc.next().charAt(0);
        }
        Arrays.sort(ary);
        func(0,0,0,0);
    }
    public static void func(int cnt, int start,int consonant, int vowel){
        if(cnt==L){
           if (consonant>=2&&vowel>=1){
               for (int i = 0; i < L; i++) {
                   System.out.print(ans[i]);
               }
               System.out.println();
           }
            return;
        }
        for (int i = start; i < C; i++) {
            if(ary[i]=='a'||ary[i]=='e'||ary[i]=='i'
                    ||ary[i]=='o'||ary[i]=='u'){
                ans[cnt] = ary[i];
                func(cnt+1,i+1,consonant,vowel+1);
            }
            else {
                ans[cnt] = ary[i];
                func(cnt+1,i+1,consonant+1,vowel);
            }
        }
    }

}
