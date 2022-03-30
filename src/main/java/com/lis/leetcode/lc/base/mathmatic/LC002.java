package com.lis.leetcode.lc.base.mathmatic;

/**
 * ClassName LC002
 * 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。

 * 示例 1：
 *
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 *
 * 输入：n = 1
 * 输出：0
 *  
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnzlu6/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * 一个数是不是质数，只需要计算该数不能被自身一半大小的数整除就行，并且偶数都不是质数
 * @author Lis on 2022/3/30
 **/
public class LC002 {

    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        for (int i = 2; i <= n; i++) {
            if (n != 2 && n % 2 != 0) {
                int maxDivide = i / 2;


            }

        }
        return 0;

//        boolean[] arr = new boolean[n];
//        int cnt = 0;
//        for(int i = 2; i < n; i++) {
//            if(arr[i]) continue;
//            cnt++;
//            // 该方法完美避开了2,3,5,7这些初始值的处理（思路牛皮）
//            for(int j = i; j < n; j+=i) {
//                arr[j] = true;
//            }
//        }
//        return cnt;

    }

    public static void main(String[] args) {
        System.out.println(Math.floorDiv(14, 3));
    }
}
