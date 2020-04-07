package com.leetcode.easy;

import java.util.HashMap;

/**
 * @auther: Bin.L
 * @date: 2019/07/22 10:13
 * @Description: # 1 Two Sum
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {

    /**
     * 题意是让你从给定的数组中找到两个元素的和为指定值的两个索引，最容易的当然是循环两次，复杂度为 O(n^2)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 利用 HashMap 作为存储，键为目标值减去当前元素值，索引为值，比如 i = 0 时，
     * 此时首先要判断 nums[0] = 2 是否在 map 中，如果不存在，那么插入键值对 key = 9 - 2 = 7, value = 0，
     * 之后当 i = 1 时，此时判断 nums[1] = 7 已存在于 map 中，那么取出该 value = 0 作为第一个返回值，当前 i 作为第二个返回值
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; ++i) {
            final Integer value = map.get(nums[i]);
            if (value != null) {
                return new int[]{value, i};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        //System.out.println(twoSum.twoSum(new int[]{2, 7, 11, 15}, 9));
        System.out.println(twoSum.twoSum(new int[]{2, 7, 11, 15}, 26));
    }
}
