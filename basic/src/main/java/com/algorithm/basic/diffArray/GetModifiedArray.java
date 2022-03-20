package com.algorithm.basic.diffArray;

import java.util.Arrays;

/**
 * @projectName: algorithm
 * @description: 370. 区间加法
 * @author: lincong
 * @date: 2022-03-20 11:52
 * @version: 0.0.1
 **/
public class GetModifiedArray {

    /**
     * 假设你有一个长度为n的数组，初始情况下所有的数字均为0，你将会被给出k 个更新的操作。
     * 其中，每个操作会被表示为一个三元组：[startIndex, endIndex, inc]，你需要将子数组A[startIndex ... endIndex]（包括 startIndex 和 endIndex）增加inc。
     * 请你返回k次操作后的数组。
     *
     * 示例:
     * 输入: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
     * 输出: [-2,0,3,5,3]
     * 解释:
     * 初始状态:
     * [0,0,0,0,0]
     *
     * 进行了操作 [1,3,2] 后的状态:
     * [0,2,2,2,0]
     *
     * 进行了操作 [2,4,3] 后的状态:
     * [0,2,5,5,3]
     *
     * 进行了操作 [0,2,-2] 后的状态:
     * [-2,0,3,5,3]
     *
     */
    class Difference{
        private int[] diff;

        public Difference(int[] nums){
            int len = nums.length;
            diff = new int[len];
            //构造差分数组
            diff[0] = nums[0];
            for (int i = 1; i < diff.length; i++) {
                diff[i] = nums[i] - nums[i-1];
            }
        }

        public void increase(int i,int j,int val){
            //diff[i]+val,还原的时候可以依次正常还原[i,j]之间的内容
            diff[i] += val;
            if(j+1<diff.length){
                //i,j增加了val,nums[j+1]相比较nums[i]便减少了val,还原的时候便可以正常还原
                diff[j+1] -= val;
            }
        }

        //返回结果数组
        public int[] result(){
            //根据差分数组构造结果数组
            int[] res = new int[diff.length];
            res[0] = diff[0];
            for (int i = 1; i < diff.length; i++) {
                res[i] = res[i-1] + diff[i];
            }
            return res;
        }

    }
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] nums = new int[length];
        Difference df = new Difference(nums);
        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int val = update[2];
            df.increase(start,end,val);
        }
        return df.result();
    }

    public static void main(String[] args) {
        int length = 5;
        int[][] updates = {{1,3,2},{2,4,3},{0,2,-2}};
        int[] res = new GetModifiedArray().getModifiedArray(length,updates);
        Arrays.stream(res).forEach(System.out::print);
    }
}
