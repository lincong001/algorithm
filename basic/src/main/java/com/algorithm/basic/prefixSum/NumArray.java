package com.algorithm.basic.prefixSum;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * @projectName: algorithm
 * @description: 区域和检索-数组不变
 * @author: lincong
 * @date: 2022-03-10 19:25
 * @version: 0.0.1
 **/
public class NumArray {
    /**
     * 给定一个整数数组  nums，处理以下类型的多个查询:
     *
     * 计算索引left和right（包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
     * 实现 NumArray 类：
     *
     * NumArray(int[] nums) 使用数组 nums 初始化对象
     * int sumRange(int i, int j) 返回数组 nums 中索引 left 和 right 之间的元素的 总和 ，包含 left 和 right 两点（也就是 nums[left] + nums[left + 1] + ... + nums[right] )
     *  
     *输入：
     * ["NumArray", "sumRange", "sumRange", "sumRange"]
     * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
     * 输出：
     * [null, 1, -1, -3]
     * 
     * 1 <= nums.length <= 104
     * -105<= nums[i] <=105
     * 0 <= i <= j < nums.length
     * 最多调用 104 次 sumRange 方法
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/range-sum-query-immutable
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    private int[] preSum;
    /**
     * 构造前缀和，避免区间内的数据反复相加
     * @param nums 目标数组
     */
    public NumArray(int[] nums){
        preSum = new int[nums.length+1];
        //构造前缀和
        for (int i = 1; i < nums.length+1; i++) {
            preSum[i]=preSum[i-1]+nums[i-1];
        }

    }

    int sumRange(int i,int j){
        return preSum[j+1]-preSum[i];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,4,3,6,1};
        NumArray ar = new NumArray(nums);
        System.out.println(ar.sumRange(1,3));
        System.out.println(ar.sumRange(2,4));
    }
}
