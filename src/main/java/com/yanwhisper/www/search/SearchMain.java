package com.yanwhisper.www.search;

import java.util.HashMap;
import java.util.Map;

/**
 * @author little whisper
 * @date 2020/2/14 18:09
 */
public class SearchMain {

    public static int[] arr = new int[]{2, 10, 5, 15, 4, 3, 8, 9, 20};

    public static void main(String args[]) {
        Map<Integer, Integer> temp = new HashMap<>();
        temp.put(1, 2);
        temp.put(2, 2);
        temp.put(3, 2);
        temp.entrySet().stream().forEach(entry -> {
            temp.remove(2);
        });
    }

    public static int sequenceSearch(int[] a, int value) {
        int length = a.length;
        for (int i = 0; i < length; i++) {
            if (a[i] == value) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 二分查找
     * @param a 有序数组
     * @param value 待查找的值
     * @param low 待查找数组最小索引
     * @param high 待查找数组最大索引
     * @return 值对应的索引，-1 表示未找到
     */
    public static int binarySearch(int[] a, int value, int low, int high) {
        int middle = low + (high - low) / 2;
        if (a[middle] == value) {
            return middle;
        }
        if (middle != low && a[middle] > value) {
            return binarySearch(a, value, low, middle - 1);
        }
        if (middle != high && a[middle] < value) {
            return binarySearch(a, value, middle + 1, high);
        }
        return -1;
    }

}
