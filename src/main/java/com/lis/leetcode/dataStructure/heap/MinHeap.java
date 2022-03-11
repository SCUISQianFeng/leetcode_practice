package com.lis.leetcode.dataStructure.heap;

/**
 * ClassName MinHeap
 * 最小堆的性质：父节点，最小值的位置就是0
 * 当前节点的父节点： (i - 1) / 2
 * 左子节点: 2 * i + 1
 * 右子节点： 2 * i + 2
 *
 * @author Lis on 2022/3/6
 **/
public class MinHeap {
    // 将所有元素以完全二叉树的形式存入数组
    private int[] heap;
    // 堆中元素的个数
    private int size;

    /**
     * 构造函数
     *
     * @param maxSize
     */
    public MinHeap(int maxSize) {
        heap = new int[maxSize];
    }

    public MinHeap(int[] arr, int maxSize) {
        heap = new int[arr.length > maxSize ? arr.length : maxSize];
        System.arraycopy(arr, 0, heap, 0, arr.length);
        size = arr.length;

        // 最初调整位置,根节点位置
        int pos = (size - 2) / 2;
        while (pos >= 0) {
            // 初始化堆需要自顶向下调整位置
            shiftDown(pos, size - 1);
            pos--;
        }
    }

    /**
     * 自顶向下调整为最小堆
     *
     * @param start
     * @param end
     */
    private void shiftDown(int start, int end) {
        int i = start;
        int j = 2 * start + 1;
        int temp = heap[i];
        // 数组不能越界
        while (j <= end) {
            if (j < end) {
                // 从左右节点中选较小的一个
                j = heap[j] > heap[j + 1] ? j + 1 : j;
            }
            // 最小堆 子节点应该比父节点大
            if (heap[j] > temp) {
                // 已经是理想的情况
                break;
            } else {
                // 父子节点交换元素
                heap[i] = heap[j];
                // 从调整之后的子节点位置开始继续处理
                i = j;
                j = 2 * j + 1;
            }
        }
        heap[i] = temp;
    }

    /**
     * 自自底向上调整为最小堆
     *
     * @param start
     */
    private void shiftUp(int start) {
        // 子节点
        int i = start;
        // 子节点的父节点
        int j = (start - 1) / 2;
        int temp = heap[j];
        // 数组不能越界
        while (j > 0) {
            // 最小堆，父节点小于子节点的值
            if (temp < heap[i]) {
                break;
            } else {
                heap[j] = heap[i];
                i = j;
                j = (j - 1) / 2;
            }
        }
        heap[j] = temp;
    }


    private void insert(int data) {
        // 在队尾插入元素，需要自底向上调整
        if (size < heap.length) {
            // 插入堆尾
            heap[size++] = data;
            // 此时size已经加1，size-1是从原来堆尾的位置开始调整
            shiftUp(size - 1);
        }
    }

    private void remove() {
        while (size > 0) {
            // 删除父节点，先将堆尾的元素调整到堆顶，再从自顶向下调整
            heap[0] = heap[size - 1];
            size--;
            shiftDown(0, size - 1);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 堆排序:每次将最小元素交换到最后
     */
    public void sort() {
        for (int i = size - 1; i >= 0; i--) {
            int temp = heap[0];
            heap[0] = heap[1];
            heap[1] = temp;
            shiftDown(0, i - 1);
        }
        for (int i = size - 1; i >= 0; i--) {
            System.out.println(heap[i] + " ");
        }
    }

    public void printMinHeap(int i) {
        if (size > i) {
            System.out.print(heap[i]);
            if (2 * i + 1 < size || 2 * i + 2 < size) {
                System.out.print("(");
                printMinHeap(2 * i + 1);
                System.out.print(",");
                printMinHeap(2 * i + 2);
                System.out.print(")");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        MinHeap heap = new MinHeap(arr, 5);
        heap.printMinHeap(0);
    }
}
