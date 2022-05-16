package com.algorithm.basic.binarySearch;

/**
 * @author linchong
 * @version 1.0
 * @Date: 2022-05-15 14:27
 * @Description: BinarySearch$查找一个数，找到返回索引，未找到返回-1
 */
public class BinarySearch {

	int binarySearch(int[] nums,int target){
		int left = 0,right = nums.length-1;
		int mid;
		while(left <= right){
			mid = left+(right-left)>>2;
			if(nums[mid] == target){
				return mid;
			}else if(nums[mid]<target){
				left = mid + 1;
			}else if(nums[mid]>target){
				right = mid - 1;
			}
		}
		return -1;
	}
}
