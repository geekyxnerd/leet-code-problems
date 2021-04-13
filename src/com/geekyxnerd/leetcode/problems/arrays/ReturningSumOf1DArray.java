package com.geekyxnerd.leetcode.problems.arrays;

/**
 * @author geekyxnerd
 * Created on 12-Apr-21 at 4:02 PM.
 *
 * Leetcode: 1480: Running Sum of 1d Array
 * Problem url: https://leetcode.com/problems/running-sum-of-1d-array/
 *
 * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
 *
 * Return the running sum of nums.
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: [1,3,6,10]
 * Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
 * Example 2:
 *
 * Input: nums = [1,1,1,1,1]
 * Output: [1,2,3,4,5]
 * Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
 * Example 3:
 *
 * Input: nums = [3,1,2,10,1]
 * Output: [3,4,6,16,17]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 1000
 * -10^6 <= nums[i] <= 10^6
 *
 */
public class ReturningSumOf1DArray {

    /*
        Naive Solution
        Time Complexity: Quadratic time O(n2)
        Space complexity: Linear space O(n)
     */
    public int[] runningSum(int[] nums) {
        //Step 1: Initialize a new array to store the sums
        int[] Rsum = new int[nums.length];
        //Step 2: Iterate through each element
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            //Step 3: Compute the sum of previous elements until the element at i index
            for (int j = 0; j <= i; j++) {
                sum = sum + nums[j];
            }
            //Step 4: Store the results
            Rsum[i] = sum;
        }
        return Rsum;
    }

    /*
        Optimised Solution: Eliminate the inner loop and used the existing array of nums to store the result
        Time Complexity: Quadratic time O(n)
        Space complexity: Constant space O(1)
     */
    public int[] runningSumOptimised(int[] nums) {
        int i = 1;
        //Use the result of previous computation and override the old element with new result
        while (i<nums.length){
            nums[i]+=nums[i-1];
            i++;
        }
        return nums;
    }
}
