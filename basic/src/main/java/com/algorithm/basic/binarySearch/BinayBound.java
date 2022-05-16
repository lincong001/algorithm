package com.algorithm.basic.binarySearch;

/**
 * @author linchong
 * @version 1.0
 * @Date: 2022-05-15 14:50
 * @Description: LeftBound$
 */
public class BinayBound {
	//二分搜索，查找左边界
	int left_bound(int[] nums, int target) {
		if (nums.length == 0) return -1;
		//搜索区间为[left,right)
		int left = 0, right = nums.length;
		while (left < right) {
			int mid = left + (right - left) >> 2;
			if (nums[mid] == target) {
				// 找到后，不返回，压缩搜索区间，不断的向左搜索
				right = mid;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else if (nums[mid] > target) {
				//保持搜索区间的一致性
				right = mid;
			}
		}
		//未找到有两种情况，left = nums.length 以及 left >= right
		if (left == nums.length) return -1;
		return nums[left] == target ? left : -1;
	}

	int left_bound2(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		// 搜索区间为 [left, right]
		while (left <= right) {
			int mid = left + (right - left) >> 2;
			if (nums[mid] == target) {
				// 收缩右侧边界
				right = mid - 1;
			} else if (nums[mid] < target) {
				// 搜索区间变为 [mid+1, right]
				right = mid - 1;
			} else if (nums[mid] > target) {
				// 搜索区间变为 [left, mid-1]
				left = mid + 1;
			}
		}
		// 检查出界情况
		if (left > nums.length || nums[left] != target) return -1;
		return left;
	}

	//不断的增大左边界，left++
	int right_bound(int[] nums, int target) {
		if (nums.length == 0) return -1;
		int left = 0, right = nums.length;
		//[left,right)
		while (left < right) {
			int mid = left + (right - left) >> 2;
			if (nums[mid] < target) {
				//[mid+1,right)
				left = mid + 1;
			} else if (nums[mid] > target) {
				//[left,mid)
				right = mid;
			} else if (nums[mid] == target) {
				left = mid + 1;
			}
		}
		//left,[0,nums.length]
		// while 的终⽌条件是 left == right，即 left 的取值范围是 [0,nums.length]
		if (left == 0) return -1;
		return nums[left - 1] == target ? left - 1 : -1;
	}

	//不断的缩小右边的边界，right--
	int right_bound2(int[] nums,int target){
		int left = 0,right = nums.length - 1;
		while(left <= right){
			int mid = left + (right - left) >> 2;
			if(nums[mid] < target){
				//[mid+1,right]
				left = mid + 1;
			}else if(nums[mid]>target){
				//[left,mid-1]
				right = mid - 1;
			}else if(nums[mid] == target){
				//左侧区间右移动
				left = mid + 1;
			}
		}
		//当 target ⽐所有元素都⼩时，right 会被减到 -1，所以需要在最后防⽌越界：
		if(right < 0 || nums[right] != target) return -1;
		return right;
	}

	//总结，统一模板
	int binarySearchT(int[] nums,int target){
		int left = 0,right = nums.length - 1;
		while(left <= right){
			int mid = left + (right - left) >> 2;
			if(nums[mid] == target){
				return mid;
			}else if(nums[mid] < target){
				left = mid + 1;
			}else if(nums[mid] > target){
				right = mid - 1;
			}
		}
		return -1;
	}

	int left_boundT(int[] nums,int target){
		int left = 0,right = nums.length - 1;
		while (left <= right){
			int mid = left + (right - left) >> 2;
			if(nums[mid] < target){
				left = mid + 1;
			}else if(nums[mid] > target){
				right = mid - 1;
			}else if(nums[mid] == target){
				left = mid + 1;
			}
		}
		if(left >= nums.length || nums[left] != target) return -1;
		return left;
	}

	int right_boundT(int[] nums,int target){
		int left = 0,right = nums.length-1;
		while(left <= right){
			int mid = left + (right - left) >> 2;
			if(nums[mid] < target){
				left = mid + 1;
			}else if(nums[mid] > target){
				right = mid - 1;
			}else if(nums[mid] == target){
				// 别返回，锁定右侧边界
				left = mid + 1;
			}
		}
		//处理边界情况
		if(right < 0 || nums[right] != target){
			return -1;
		}
		return right;
	}
}
