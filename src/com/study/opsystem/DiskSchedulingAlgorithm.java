package com.study.opsystem;

import java.util.Scanner;

import static java.lang.Math.abs;

//磁盘调度算法
public class DiskSchedulingAlgorithm {
    static final int MaxNumber = 100;
    static int[] TrackerOrder = new int[MaxNumber];
    static int[] MoveDistance = new int[MaxNumber];
    static int[] FindOrder = new int[MaxNumber];
    static double AverageDistance;
    static boolean direction;
    static int BeginNum;
    static int M = 500;
    static int N;
    static int[] SortOrder = new int[MaxNumber];
    static boolean[] Finished = new boolean[MaxNumber];
    public static void main(String[] args) {
        int y = 1;
        int s;
        Inith();
        while (y==1){
            System.out.println("请选择寻道方式:1--FCFS;2--SSTF;3--SCAN;4--CSCSN:");
            s = new Scanner(System.in).nextInt();
            switch (s){
                case 1:
                    FCFS();
                    Count();
                    Show();
                    break;
                case 2:
                    SSTF();
                    Count();
                    Show();
                    break;
                case 3:
                    SCAN();
                    Count();
                    Show();
                    break;
                case 4:
                    CSCAN();
                    Count();
                    Show();
                    break;
            }
            System.out.println("是否继续选择寻道算法？1--是；0--否");
            int p;
            p=new Scanner(System.in).nextInt();
            y=p;
            if (p==0){
                break;
            }
        }

    }
    static void Inith(){
        System.out.println("请输入提出磁盘I/O申请数：");
        N = new Scanner(System.in).nextInt();
        System.out.println("请依次输入要访问的磁道号：");
        for (int i = 0; i < N; i++) {
            TrackerOrder[i] = new Scanner(System.in).nextInt();
        }
        for (int j = 0; j < N; j++) {
                MoveDistance[j] = 0;
                System.out.println("请输入开始磁道号:");
                BeginNum = new Scanner(System.in).nextInt();
                break;
        }
        for (int k = 0; k < N; k++) {
                Finished[k] = false;
        }
        for (int l = 0; l < N; l++) {
                SortOrder[l] = TrackerOrder[l];
        }
    }
    static void Sort(){
        int temp;
        for (int i = N-1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (SortOrder[j] > SortOrder[j+1]){
                    temp = SortOrder[j];
                    SortOrder[j] = SortOrder[j+1];
                    SortOrder[j+1] = temp;
                }
            }

        }
    }
    static void FCFS(){
        int temp;
        temp = BeginNum;
        for (int i = 0; i < N; i++) {
            MoveDistance[i] = abs(TrackerOrder[i] - temp);
            temp = TrackerOrder[i];
            FindOrder[i] = TrackerOrder[i];
        }
    }
    static void SSTF(){
        int temp,n = 0;
        int A = M;
        temp = BeginNum;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (abs(TrackerOrder[j] - temp)<A&&Finished[j]==false){
                    A = abs(TrackerOrder[j] - temp);
                    n = j;
                }else {
                    continue;
                }
            }
            Finished[n] = true;
            MoveDistance[i] = A;
            temp = TrackerOrder[n];
            A = M;
            FindOrder[i] = TrackerOrder[n];
        }
    }
    static void SCAN(){
        int m,n = 0,temp;
        temp = BeginNum;
        Sort();
        System.out.println("请选择开始方向：1--向外；0--向里：");
        m = new Scanner(System.in).nextInt();
        if (m == 1){
            direction = true;
        }else if (m == 0){
            direction = false;
        }else {
            System.out.println("输入错误！");
        }
        for (int i = 0; i < N; i++) {
            if(SortOrder[i]<BeginNum){
                continue;
            }else {
                n = i;
                break;
            }
        }
        if (direction == true){
            for (int i = n; i < N; i++) {
                MoveDistance[i-n] = abs(SortOrder[i]-temp);
                temp = SortOrder[i];
                FindOrder[i-n] = SortOrder[i];
            }
            for (int j = n-1; j >= 0; j--) {
                MoveDistance[N-1-j] = abs(SortOrder[j]-temp);
                temp = SortOrder[j];
                FindOrder[N-1-j] = SortOrder[j];
            }
        }else {
            for (int i = n-1; i >= 0; i--) {
                MoveDistance[n-1-i] = abs(SortOrder[i]-temp);
                temp = SortOrder[i];
                FindOrder[n-1-i] = SortOrder[i];
            }
            for (int j = n; j < N; j++) {
                MoveDistance[j] = abs(SortOrder[j]-temp);
                temp = SortOrder[j];
                FindOrder[j] = SortOrder[j];
            }
        }
    }
    static void CSCAN(){
        int m,n = 0,temp;
        temp = BeginNum;
        Sort();
        System.out.println("请选择开始方向：1--向外；0--向里：");
        m = new Scanner(System.in).nextInt();
        if (m == 1){
            direction = true;
        }else if (m == 0){
            direction = false;
        }else {
            System.out.println("输入错误！");
        }
        for (int i = 0; i < N; i++) {
            if(SortOrder[i]<BeginNum){
                continue;
            }else {
                n = i;
                break;
            }
        }
        if (direction == true){
            for (int i = n ; i < N; i++) {
                MoveDistance[i - n] =abs(SortOrder[i]-temp);
                temp = SortOrder[i];
                FindOrder[i-n] = SortOrder[i];
            }
            for (int j = 0; j < n; j++) {
                MoveDistance[N-n+j]=abs(SortOrder[j]-temp);
                temp = SortOrder[j];
                FindOrder[N-n+j] = SortOrder[j];
            }
        }else {
            for (int i = n-1; i >= 0; i--) {
                MoveDistance[n-1-i]=abs(SortOrder[i]-temp);
                temp =SortOrder[i];
                FindOrder[n-1-i]=SortOrder[i];
            }
            for (int j = N-1; j >= n; j--) {
                MoveDistance[N-j+n-1]=abs(SortOrder[j]-temp);
                temp = SortOrder[j];
                FindOrder[N-j+n-1] = SortOrder[j];
            }
        }
    }
    static void Count(){
        int Total = 0;
        for (int i = 0; i < N; i++) {
            Total+=MoveDistance[i];
        }
        AverageDistance = ((double)Total)/((double) N);
    }
    static void Show(){
        System.out.println("被访问的下一个磁道号\t"+"\t移动距离（磁道数）");
        for (int i = 0; i < N; i++) {
            System.out.println("\t\t"+FindOrder[i]+"\t\t\t\t\t"+MoveDistance[i]);
        }
        System.out.println("\t平均寻道长度"+AverageDistance);
        System.out.println();
    }
}
