package com.lis.leetcode.swardoffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * ClassName Quiz30
 * 找出最小的 K 个数
 * 题目描述： 输入 n 个整数， 找出其中最小的 K 个数。
 * 思路： 先将前 K 个数放入数组， 进行堆排序， 若之后的数比它还小， 则进行调整
 *
 * @author Lis on 2022/3/13
 **/
public class Quiz30 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || k <= 0 || k > input.length) {
            return list;
        }
        int[] arr = Arrays.copyOfRange(input, 0, k);
        buildHeap(arr);

        for (int i = k; i < input.length; i++) {
            if (input[i] < arr[0]) {
                // 比最大值还小
                arr[0] = input[i];
                maxHeap(arr, 0);
            }
        }
        // 构建最大堆结束
        for (int i = arr.length - 1; i >= 0; i--) {
            list.add(arr[i]);
        }
        return list;
    }

    public void buildHeap(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            maxHeap(arr, i);
        }
    }

    private void maxHeap(int[] array, int i) {
        // i : root index
        int left = 2 * i + 1;
        int right = left + 1;
        int largest = 0;
        if (left < array.length && array[left] > array[i]) {
            largest = left;
        } else {
            largest = i;
        }
        if (right < array.length && array[right] > array[i]) {
            largest = right;
        }
        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            maxHeap(array, largest);
        }
    }

}
