package com.algorithm.basic.inPlaceEditArray;

import java.util.Arrays;

/**
 * @author linchong
 * @version 1.0
 * @Date: 2022-05-19 9:06
 * @Description: RemoveDuplicates$修改数组中重复元素
 */
public class RemoveDuplicates {


	/**
	 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
	 * <p>
	 * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。
	 * <p>
	 * 将最终结果插入 nums 的前 k 个位置后返回 k 。
	 * <p>
	 * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
	 * <p>
	 * 判题标准:
	 * <p>
	 * 系统会用下面的代码来测试你的题解:
	 * <p>
	 * int[] nums = [...]; // 输入数组
	 * int[] expectedNums = [...]; // 长度正确的期望答案
	 * <p>
	 * int k = removeDuplicates(nums); // 调用
	 * <p>
	 * assert k == expectedNums.length;
	 * for (int i = 0; i < k; i++) {
	 * assert nums[i] == expectedNums[i];
	 * }
	 * 如果所有断言都通过，那么您的题解将被 通过。
	 * <p>
	 * <p>
	 * 示例 1：
	 * <p>
	 * 输入：nums = [1,1,2]
	 * 输出：2, nums = [1,2,_]
	 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
	 * 示例 2：
	 * <p>
	 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
	 * 输出：5, nums = [0,1,2,3,4]
	 * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
	 *  
	 * <p>
	 * 提示：
	 * <p>
	 * 0 <= nums.length <= 3 * 104
	 * -104 <= nums[i] <= 104
	 * nums 已按 升序 排列
	 * <p>
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-array
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 *
	 * @param nums
	 * @return
	 */
	//普通方法，时间复杂度N*N
	public static int removeDuplicates(int[] nums) {
		int counter = nums.length;
		for (int i = nums.length - 2; i >= 0; i--) {
			//如果两个元素相等，向前移动一位
			if (nums[i] == nums[i + 1]) {
				for (int j = i + 1; j < counter; j++) {
					nums[j - 1] = nums[j];
				}
				counter--;
			}
		}
		return counter;
	}

	//慢指针 slow ⾛在后⾯，快指针 fast ⾛在前⾯探路，找到⼀个不重复的元素就告诉 slow 并让 slow
	//前进⼀步。这样当 fast 指针遍历完整个数组 nums 后，nums[0..slow] 就是不重复元素。
	public static int removeDuplicates2(int[] nums) {
		if (nums.length == 0) return 0;
		int slow = 0, fast = 0;
		while (fast < nums.length) {
			if (nums[slow] != nums[fast]) {
				slow++;
				//[0,slow]无重复数组
				nums[slow] = nums[fast];
			}
			fast++;
		}
		// 数组⻓度为索引 + 1
		return slow + 1;
	}


	public static void main(String[] args) {
		int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
		int counter = removeDuplicates2(nums);
		System.out.println(counter);
		Arrays.stream(nums).forEach(System.out::print);

	}
}
