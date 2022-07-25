package com.algorithm.basic.inPlaceEditArray;

/**
 * @author linchong
 * @version 1.0
 * @Date: 2022-05-19 23:18
 * @Description: MoveZeroes$
 */
public class MoveZeroes {

	//给你输⼊⼀个数组 nums，请你原地修改，将数组中的所有值为 0 的元素移到数组末尾
	void moveZeroes(int[] nums){
		int slow = 0,fast = 0;
		while(fast < nums.length){
			if(nums[fast]!=0){
				nums[slow] = nums[fast];
				slow++;
			}
			fast++;
		}

		for (int i = slow; i < nums.length; i++) {
			nums[i] = 0;
		}
	}
}
