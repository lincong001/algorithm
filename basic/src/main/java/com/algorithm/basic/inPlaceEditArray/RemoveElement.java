package com.algorithm.basic.inPlaceEditArray;

/**
 * @author linchong
 * @version 1.0
 * @Date: 2022-05-19 23:08
 * @Description: RemoveElement$
 */
public class RemoveElement {

	/**
	 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
	 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
	 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
	 *
	 * @param nums
	 * @param val
	 * @return
	 */
	public int removeElement(int[] nums, int val) {
		int slow = 0,fast = 0;
		while(fast < nums.length){
			//如果nums[i] == val,跳过，否则，利用slow处理
			if(nums[fast] != val){
				nums[slow] = nums[fast];
				slow ++;
			}
			fast ++;
		}

		return slow;

	}

}
