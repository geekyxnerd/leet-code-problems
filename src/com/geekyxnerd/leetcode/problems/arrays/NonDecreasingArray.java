package com.geekyxnerd.leetcode.problems.arrays;

/**
 * @author geekyxnerd
 * Created on 16-Apr-21 at 8:59 PM.
 *
 * Leetcode 665. Non-decreasing Array | Medium
 *
 * Problem Url: https://leetcode.com/problems/non-decreasing-array/solution/
 * Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.
 *
 * We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,2,3]
 * Output: true
 * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 * Example 2:
 *
 * Input: nums = [4,2,1]
 * Output: false
 * Explanation: You can't get a non-decreasing array by modify at most one element.
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 104
 * -105 <= nums[i] <= 105
 *
 * Time complexity: O(n)
 *
 * Solution Url: https://www.youtube.com/watch?v=3UgvNI02ai4
 */
public class NonDecreasingArray {

    public static void main(String[] args) {
        System.out.println(checkPossibility(new int[]{3,4,2,3}));
    }

    public static boolean checkPossibility(int[] nums) {
        //Step1: Counter to keep the track the number of modifications
        int count = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            //Step 2: Look for cases when the ith element is lower than i + 1 element
            if(nums[i] > nums[i+1]){
                ++count;
                //Step 3: If count is more than 2, return false
                if(count > 1) {
                    return false;
                }
                //Step 4: Case to decide which of the element is to be modified, ith or i + 1 th element
                if(i > 0 && nums[i -1] > nums [i+1]) {
                    nums[i+1] = nums[i];
                } else {
                    nums[i] = nums[i+1];
                }

            }
        }
        return true;
    }
}
