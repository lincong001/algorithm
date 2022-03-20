package com.algorithm.basic.prefixSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @projectName: algorithm
 * @description: 和为K的子数组
 * @author: lincong
 * @date: 2022-03-18 11:43
 * @version: 0.0.1
 * leedcode 560
 **/
public class SubarraySum {
    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
     * 输入：nums = [1,1,1], k = 2
     * 输出：2
     *
     * 输入：nums = [1,2,3], k = 3
     * 输出：2
     *
     * 1 <= nums.length <= 2 * 104
     * -1000 <= nums[i] <= 1000
     * -107 <= k <= 107
     *
     */

    private int[] preSum;


    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int res = 0;
        if(len==0){
            return res;
        }
        preSum = new int[len+1];
        for (int i = 1; i <=len ; i++) {
            preSum[i] = preSum[i-1]+nums[i-1];
        }

        //preSum[i]-preSum[j],i>j
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if(preSum[i]-preSum[j] == k)
                    res++;
            }
        }
        return res;
    }

    //优化上面的内层for循环，上面内层for循环做的事情：计算有几个preSum[j]能使得preSum[i]和preSum[j]差为k
    //⽤哈希表，在记录前缀和的同时记录该前缀和出现的次数。preSum[i]- k == preSum[j]
    //直接记录下有⼏个 preSum[j] 和 preSum[i] - k 相等，直接更新结果，就避免了内层 的 for 循环。
    public int subarraySum2(int[] nums,int k){
        //优化，记录下有几个preSum[j]和preSum[i]-k相等
        //map 前缀和，该前缀和出现的次数
        int n = nums.length;
        Map<Integer,Integer> preSum = new HashMap<>();
        //base case
        preSum.put(0,1);

        int res = 0,sum0_i = 0;
        for(int i=0;i<n;i++){
            sum0_i += nums[i];
            //待寻找的前缀和
            int sum0_j = sum0_i - k;
            //如果前面有这个前缀和，直接更新答案
            if(preSum.containsKey(sum0_j)){
                res+=preSum.get(sum0_j);
            }
            //将前缀和num[0...i] 加入并记录出现的次数
            preSum.put(sum0_j,preSum.getOrDefault(sum0_j,0)+1);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {1};
        int k = 0;
        SubarraySum instance = new SubarraySum();
        System.out.println(instance.subarraySum(nums,k));;
    }

}
