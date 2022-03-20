/**
 *
 * 使用场景：前缀和技巧适⽤于快速、频繁地计算⼀个索引区间内的元素之和。
 * 303. 区域和检索 - 数组不可变（中等）
 * 304. ⼆维区域和检索 - 矩阵不可变（中等）
 * 560. 和为K的⼦数组（中等）
 *
 **/
/* 核心代码：
class PrefixSum {
// 前缀和数组
private int[] prefix;

//输⼊⼀个数组，构造前缀和
public PrefixSum(int[] nums) {
        prefix = new int[nums.length + 1];
        // 计算 nums 的累加和
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
}

    //查询闭区间 [i, j] 的累加和
    public int query(int i, int j) {
        return prefix[j + 1] - prefix[i];
    }
}
*/

package com.algorithm.basic.prefixSum;