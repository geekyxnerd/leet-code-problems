package com.geekyxnerd.leetcode.problems.dp;

/**
 * @author geekyxnerd
 * Created on 03-Apr-21 at 12:05 PM.
 */
public class OnesAndZeroes {

    public static void main(String[] args) {
        String[] strs = {"10","0001","111001","1","0"};
        int m = 5;
        int n = 3;
        System.out.println(findMaxForm(strs,m,n));
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        if(strs==null || m<0 || n<0)
            return 0;
        int[][] dp=new int[m+1][n+1];
        for(String curr : strs){
            int onesCount= (int)curr.chars().filter(num -> num=='1').count();
            int zeroesCount=curr.length()-onesCount;
            for(int i=m; i>=zeroesCount; i--){
                for(int j=n; j>=onesCount; j--){
                    dp[i][j]=Math.max(dp[i][j], dp[i-zeroesCount][j-onesCount]+1);
                }
            }
        }
        return dp[m][n];
    }
}
