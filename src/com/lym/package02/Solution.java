package com.lym.package02;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


class Solution {
    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[] a = new int[]{1,4,6,7,9};
//        System.out.println(solution.s1earch1(a,8));
        Double a = 2.2;
        Double b = null;
        double c = a + b;
    }

    private void quicksort(int[] nums, int low, int high) {
        int i = low;
        int j = high;
        if (i < j) {
            int temp = nums[i];
            while (i < j) {
                while (i < j && nums[j] >= temp) {
                    j--;
                }
                nums[i] = nums[j];
                while (i < j && nums[i] <= temp) {
                    i++;
                }
                nums[j] = nums[i];
            }
            nums[i] = temp;
            quicksort(nums, low, i - 1);
            quicksort(nums, i + 1, high);

        }
    }

    public int s1earch1(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int middle = (i + j) / 2;
            if (nums[middle] > target) {
                j = middle - 1;
            } else if (nums[middle] < target) {
                i = middle + 1;
            } else {
                while (middle >= 0 && nums[middle] == nums[middle - 1]) {
                    middle--;
                }
                return nums[middle];
            }
        }
        return nums[i] > target ? nums[i] : nums[i + 1];
    }
}