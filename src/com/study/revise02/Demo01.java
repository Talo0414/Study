package com.study.revise02;

public class Demo01 {
    public static void main(String[] args) {
        //原始数组
        System.out.println("以下为原始数组：");
        int arrays[][] = new int[11][11];
        arrays[1][2] = 1;
        arrays[2][3] = 2;
        //打印原始数组
        for (int[] ints : arrays) {
            for (int anInt : ints) {
                System.out.print(anInt+"\t");
            }
            System.out.println();
        }
        
        /**转换为稀疏数组
         * 稀疏数组：【有效个数+1】【3】
         * 行    列     值
         */
        //计数：有效的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (arrays[i][j] != 0){
                    sum++;
                }
            }
        }
        //创建稀疏数组
        int arrays1[][] = new int[sum+1][3]; 
        arrays1[0][0] = 11;         //行为11
        arrays1[0][1] = 11;         //列为11
        arrays1[0][2] = sum;        //有效值为sum
        //给稀疏数组传参
        int count = 0;
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                if (arrays[i][j] != 0){
                    count++;                            //值有效则计数器加一（因为第一行记录了行、列、有效值信息，因此要加一）
                    arrays1[count][0] = i;              //稀疏数组第count行开始记录第一个值所在的行位置
                    arrays1[count][1] = j;              //稀疏数组第count行开始记录第一个值所在的列位置
                    arrays1[count][2] = arrays[i][j];   ////稀疏数组第count行开始记录第一个值所在的行位置
                }
            }
        }
        //打印稀疏数组
        System.out.println("以下为稀疏数组：");
        for (int[] ints : arrays1) {
            for (int anInt : ints) {
                System.out.print(anInt+"\t");
            }
            System.out.println();
        }
        /**
         * 将稀疏数组还原
         */
        int arrays2[][] = new int[arrays1[0][0]][arrays1[0][1]];
        for (int i = 1; i < arrays1.length; i++) {      //从索引1开始，因为索引0存放原始数组信息。
                arrays2[arrays1[i][0]][arrays1[i][1]] = arrays1[i][2];  //取稀疏数组中行、列、值信息给还原数组赋值
        }
        //打印还原数组
        System.out.println("以下为还原数组：");
        for (int[] ints : arrays2) {
            for (int anInt : ints) {
                System.out.print(anInt+"\t");
            }
            System.out.println();
        }
    }
}
