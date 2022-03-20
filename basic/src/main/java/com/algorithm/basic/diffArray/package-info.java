/**
 * 差分数组
 *  适用场景：频繁对原始数组的 某个区间的元素进⾏增减。
 *  如：输⼊⼀个数组 nums，然后⼜要求给区间 nums[2..6] 全部加 1，再给 nums[3..9] 全部减 3，再给 nums[0..4] 全部加 2，
 *  思想：先对 nums 数组构造⼀个 diff 差 分数组，diff[i] 就是 nums[i] 和 nums[i-1] 之差：
 *  int[] diff = new int[nums.length];
 *  // 构造差分数组
 *  diff[0] = nums[0];
 *  for (int i = 1; i < nums.length; i++) {
 *      diff[i] = nums[i] - nums[i - 1];
 *  }
 *  通过这个 diff 差分数组是可以反推出原始数组 nums 的，代码逻辑如下：
 *  int[] res = new int[diff.length];
 *  // 根据差分数组构造结果数组
 *  res[0] = diff[0];
 *  for (int i = 1; i < diff.length; i++) {
 *      res[i] = res[i - 1] + diff[i];
 *  }
 *  这样构造差分数组 diff，就可以快速进⾏区间增减的操作，如果你想对区间 nums[i..j] 的元素全部加 3，
 *  那么只需要让 diff[i] += 3，然后再让 diff[j+1] -= 3 即可：
 *  多次修改 diff，然后通过 diff 数组反推，即可得到 nums 修改后的结果
 *
 *  例题
 *  370. 区间加法（中等）
 *  1109. 航班预订统计（中等）
 *  1094. 拼⻋（中等）
 *
 */
package com.algorithm.basic.diffArray;


// 差分数组⼯具类
class Difference {
    // 差分数组
    private int[] diff;

    /* 输⼊⼀个初始数组，区间操作将在这个数组上进⾏ */
    public Difference(int[] nums) {
        assert nums.length > 0;
        diff = new int[nums.length];
        // 根据初始数组构造差分数组
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    /* 给闭区间 [i,j] 增加 val（可以是负数）*/
    public void increment(int i, int j, int val) {
        diff[i] += val;
        //当 j+1 >= diff.length 时，说明是对 nums[i] 及以后的整个数组都进⾏修改，那么就不需要再给 diff 数组减 val
        if (j + 1 < diff.length) {
            diff[j + 1] -= val;
        }
    }

    /* 返回结果数组 */
    public int[] result() {
        int[] res = new int[diff.length];
        // 根据差分数组构造结果数组
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }
}
