package com.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class s5_2628 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int width = sc.nextInt();
        int length = sc.nextInt();
        int N = sc.nextInt();
        int [] cutX = new int[N+1];
        int [] cutY = new int[N+1];
        int cntX=0;
        int cntY=0;
        for (int i = 0; i < N; i++) {
            if(sc.nextInt()==0) {
                cutY[i] = sc.nextInt();
                cntY++;
            }
            else {
                cutX[i] = sc.nextInt();
                cntX++;
            }
        }
        cutX[N] = width;
        cutY[N] = length;
        Arrays.sort(cutX);
        Arrays.sort(cutY);
        int nx=0;
        int ny=0;
        int maxX=0;
        int maxY=0;
        for (int i = 0; i <= N; i++) {
            if(cutX[i]-nx>maxX) maxX=cutX[i]-nx;
            nx = cutX[i];
        }
        for (int i = 0; i <= N; i++) {
            if(cutY[i]-ny>maxY) maxY=cutY[i]-ny;
            ny = cutY[i];
        }
        System.out.println(maxX*maxY);
    }
}
