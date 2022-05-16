package com.algorithm.basic.other;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author linchong
 * @version 1.0
 * @Date: 2022-05-16 22:15
 * @Description: AdvantageCount$
 */
public class AdvantageCount {

	/**
	 * 给定两个大小相等的数组nums1和nums2，nums1相对于 nums的优势可以用满足nums1[i] > nums2[i]的索引 i的数目来描述。
	 * 返回 nums1的任意排列，使其相对于 nums2的优势最大化。
	 *
	 * 类似田忌赛马，利用自己的优势对地方的劣势
	 * 
	 * 
	 */
	public int[] advantageCount(int[] nums1, int[] nums2) {
		int n = nums1.length;
		//己方排序，有小到大排列
		Arrays.sort(nums1);
		//num2，降序排列，
		PriorityQueue<int[]> maxpq = new PriorityQueue<>((int[] pair1,int[] pair2)->{
			return pair2[1] - pair1[1];
		});
		for(int i=0;i<n;i++){
			//索引，具体的数值
			maxpq.offer(new int[]{i,nums2[i]});
		}
		//nums1[left]最小值，nums2[right]最大值
		int left = 0,right = nums1.length - 1;
		int[] result = new int[n];
		while(!maxpq.isEmpty()){
			int[] pair = maxpq.poll();
			int index = pair[0], value = pair[1];
			if(nums1[right]>value){
				result[index] = nums1[right];
				right -- ;
			}else{
				result[index] = nums1[left];
				left ++;
			}
		}
		return result;
	}
}
