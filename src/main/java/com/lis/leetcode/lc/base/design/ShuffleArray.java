package com.lis.leetcode.lc.base.design;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author lis
 * @version 1.0
 * @date 2022-3-30
 **/
public class ShuffleArray {

    private int[] nums;

    public ShuffleArray(int[] nums) {
        this.nums = nums;

    }

    public int[] reset() {
        return this.nums;
    }

    public int[] shuffle() {
        if (this.nums == null) {
            return null;
        }
        int[] cloneArray = this.nums.clone();
        List<Integer> list = Arrays.stream(cloneArray).boxed().collect(Collectors.toList());
        int[] result = new int[list.size()];
        int len = list.size();
        int index = 0;
        while (len > 0) {
            Random random = new Random();
            int i = random.nextInt(len);
            result[index] = list.get(i);
            list.remove(i);
            index++;
            len--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        ShuffleArray obj = new ShuffleArray(nums);
//        int[] param_1 = obj.reset();
        for (int i = 0; i < 10; i++) {
            int[] param_2 = obj.shuffle();
            System.out.println(Arrays.toString(param_2));
        }

    }
}
