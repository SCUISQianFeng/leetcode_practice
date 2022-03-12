package com.lis.leetcode.swardoffer;

/**
 * ClassName Quiz12_important
 * 求 1 到最大的 n 位数
 * 题目描述： 输入数字 n， 按顺序打印从 1 到最大的 n 位数十进制数， 比如： 输入
 * 3， 打印出 1 到 999.
 * 思路： 考虑大数问题， 使用字符串或数组表示。
 * 用一个长度为n的数组，初始化为[0, 0, 0]
 * 每进行一步，就将
 * @author Lis on 2022/3/12
 **/
public class Quiz12_important {

    public void printToMaxOfNDigits(int n) {
        int[] array=new int[n];
        if(n <= 0)
            return;
        printArray(array, 0);
    }

    private void printArray(int[] array,int n) {
        for(int i = 0; i < 10; i++) {
            if(n != array.length) {
                array[n] = i;
                printArray(array, n+1);
            } else {
                // array = [0, 0, ..., 0]
                boolean isFirstNo0 = false;
                for(int j = 0; j < array.length; j++) {
                    if(array[j] != 0) {
                        System.out.print(array[j]);
                        if(!isFirstNo0)
                            isFirstNo0 = true;
                    } else {
                        if(isFirstNo0)
                            System.out.print(array[j]);
                    }
                }
                System.out.println();
                return ;
            }
        }
    }

    public static void main(String[] args) {
        Quiz12_important quiz = new Quiz12_important();
        quiz.printToMaxOfNDigits(3);
    }
}
