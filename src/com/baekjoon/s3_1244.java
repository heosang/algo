package com.baekjoon;

import java.util.Scanner;

public class s3_1244 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int N = sc.nextInt();
        int[] ary = new int[N+1];
        for (int i = 1; i <= N; i++) ary[i] = sc.nextInt();
        int studentNum = sc.nextInt();
        for(int i = 0; i < studentNum; i++) {
            int gender = sc.nextInt();
            int tempNum = sc.nextInt();
            if(gender == 1) {
                for(int j = tempNum; j <= N; j+=tempNum) {
                    if (ary[j]==0) ary[j] = 1;
                    else ary[j] = 0;
                }
            }
            else if(gender == 2){
                int size = 1;
                if (ary[tempNum]==0) ary[tempNum] = 1;
                else ary[tempNum] = 0;
                while(true) {
                    if(tempNum-size < 1 || tempNum+size > N) break;
                    if(ary[tempNum-size] != ary[tempNum+size]) break;
                    if (ary[tempNum-size]==0) ary[tempNum-size] = 1;
                    else ary[tempNum-size] = 0;
                    if (ary[tempNum+size]==0) ary[tempNum+size] = 1;
                    else ary[tempNum+size] = 0;
                    size++;
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            System.out.print(ary[i]+" ");
            if(i%20==0) System.out.println();
        }
    }
}
