package com.baekjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

public class Main_3_12018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] ary =new int[n];
        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            int l = sc.nextInt();
            int[] temp = new int[p];
            for (int j = 0; j < p; j++) {
                temp[j]=sc.nextInt();
            }
            Arrays.sort(temp);
            if (l>p){
                ary[i] = 1;
                continue;
            }
            ary[i] = temp[p-l];
        }
        Arrays.sort(ary);
        int ans=0;
        for (int i = 0; i < n; i++) {
            if(m<ary[i]) break;
            else{
                ans++;
                m-=ary[i];
            }
        }
        System.out.println(ans);

    }
}
