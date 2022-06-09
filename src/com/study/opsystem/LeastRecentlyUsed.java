package com.study.opsystem;

import java.util.Scanner;
/**
 * @author 建伟 （作者名）
 * @version 1.0 （版本号）
 * @since 16.0.2 （指明需要最早使用的jdk版本）
 */

//LRU算法模拟
public class LeastRecentlyUsed {
    public static void main(String[] args) {
        int maxsize = 20;
        int input;                  //用于输入作业号
        int worknum = 0;                //输入的作业个数
        int storesize;              //系统分配的存储区块数
        int interrupt = 0;              //缺页中断次数
        int[] queue = new int[maxsize];      //队列，LRU算法的主要数据结构
        int[] workstep = new int[maxsize];   //记录作业走向
        //初始化
        for (int i = 0; i < maxsize; i++) {
            queue[i] = 0;
            workstep[i] = 0;
        }
        System.out.print("请输入存储区块数：");
        storesize = new Scanner(System.in).nextInt();
        System.out.println("请输入作业的页面走向（输入0结束）：");
        for (int j = 0; j < maxsize; j++) {
            System.out.print("页面序号"+(j+1)+":");
            input = new Scanner(System.in).nextInt();
            workstep[j] = input;
            if (input == 0){
                System.out.println("输入结束！");
                break;
            }
            worknum++;
        }
        if (workstep[0] == 0){
            System.out.println("为输入任何作业，系统将退出！");
            return;
        }
        System.out.println("置换情况如下：");
        for (int k = 0; k < worknum; k++) {
            boolean jump = false;
            for (int l = 0; l < storesize; l++) {
                if (queue[l] == workstep[k]){
                    System.out.println("内存中有"+workstep[k]+"号页面，无须中断！");
                    for (; l < storesize; l++) {
                        queue[l] = queue[l+1];
                    }
                    //goto step2;
                    queue[storesize - 1] = workstep[k];
                    jump = true;
                    break;
                }
            }
            if (jump) {
                continue;
            }
                if (queue[0] == 0) {
                    System.out.println("发生中断，但内存中有空闲区，" + workstep[k] + "号页面直接调入！");
                    interrupt++;
                    //goto step1;
                    for (int m = 0; m < storesize; m++) {
                    queue[m] = queue[m + 1];
                    }
                    queue[storesize - 1] = workstep[k];
                    continue;
                }
            System.out.println("发生中断，将"+queue[0]+"号页面调出，"+workstep[k]+"号装入！");
            interrupt++;
            //step1
            for (int m = 0; m < storesize; m++) {
                queue[m] = queue[m + 1];
            }
            //step2
            queue[storesize - 1] = workstep[k];

        }
        System.out.println("作业"+worknum+"个,中断"+interrupt+"次，缺页率："+((float)interrupt/(float)worknum*100)+"%");
    }
}
