package com.lis.leetcode.dataStructure.heap;

/**
 * ClassName MaxHeap
 *
 * @author Lis on 2022/3/6
 **/
public class MaxHeap {
    // 最大堆用完全二叉树进行表示
    private int[] heap;

    private int size;

    public MaxHeap(int maxSize) {
        heap = new int[maxSize];
    }

    public MaxHeap(int[] arr, int maxSize) {
        heap = new int[arr.length > maxSize ? arr.length : maxSize];
        System.arraycopy(arr, 0, heap, 0, arr.length);
        size = heap.length;
        // 自顶向下调整 从叶子节点开始调整
        // 最大堆的的节点在数组中大致位置是：[root, left_child, right_child, left_chile_child, right_child_child,...,]
        int pos = (size - 1) / 2;
        while (pos >= 0) {
            shiftDown(pos, size - 1);
            pos--;
        }
    }


    private void shiftDown(int start, int end) {
        // 当前子树的父节点
        int i = start;
        // 当前子树的父节点的子节点
        int j = 2 * start + 1;
        int temp = heap[i];
        while(j <= end) {
            if (j < end) {
                // 选择左右节点较大的一个来处理
                j = heap[j] > heap[j + 1] ? j : j + 1;
            }
            // 最大堆，子节点比父节点小
            if( heap[j] < temp) {
                break;
            } else {
                // 先交换父子节点的值
                heap[i] = heap[j];
                // 从新的子节点开始继续处理
                i = j;
                j = 2 * j + 1;
            }
        }
        heap[i] = temp;
    }

    private void shiftUp(int start) {
        // 当前子树的子节点
        int i = start;
        // 当前子树的子节点的父节点
        int j = (size - 1) / 2;
        int temp = heap[i];
        while(j >= 0) {
            if( heap[j] > temp) {
                break;
            } else {
                // 先交换父子节点的值
                heap[i] = heap[j];
                // 从新的子节点开始继续处理
                i = j;
                j = 2 * j + 1;
            }
        }
        heap[i] = temp;
    }


    private void insert(int data) {
        if (size < heap.length) {
            heap[size++] = data;
            shiftDown(0, size - 1);
        }
    }

    private void remove() {
        if (size > 0) {
            //将堆尾的元素放在堆顶
            heap[0] = heap[size - 1];
            // 自底向上调整
            shiftUp(size - 1);
        }
    }

    /**
     * 堆排序:每次将最大元素交换到最后
     */
    private void sort() {
        for (int i = size - 1; i >= 0; i--) {
            int temp = heap[0];
            heap[0] = heap[i];
            heap[i] = temp;

            shiftDown(0, i-1);
        }

        for (int i = size-1; i >= 0; i--) {
            System.out.print(heap[i] + " ");
        }
    }

    private void printMaxHeap(int i) {
        if (size > i) {
            System.out.print(heap[i]);
            if (2 * i + 1 < size || 2 * i + 2 < size) {
                System.out.print("(");
                printMaxHeap(2 * i + 1);
                System.out.print(",");
                printMaxHeap(2 * i + 2);
                System.out.print(")");
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4,5 };
        MaxHeap heap = new MaxHeap(arr, 5);
        heap.printMaxHeap(0);
    }
}
