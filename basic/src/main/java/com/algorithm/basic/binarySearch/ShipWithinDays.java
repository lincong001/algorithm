package com.algorithm.basic.binarySearch;

/**
 * @author linchong
 * @version 1.0
 * @Date: 2022-05-16 20:31
 * @Description: ShipWithinDays$
 */
public class ShipWithinDays {


	/**
	 * 传送带上的包裹必须在 days 天内从一个港口运送到另一个港口。
	 * 传送带上的第 i个包裹的重量为weights[i]。每一天，我们都会按给出重量（weights）的顺序往传送带上装载包裹。
	 * 我们装载的重量不会超过船的最大运载重量。返回能在 days 天内将传送带上的所有包裹送达的船的最低运载能力
	 *
	 *  由题意可知，days天内可以将所有的包裹运送过去，运载范围为[max(weight[i]),sum(weight[i])]中获取
	 *  若小于max(weight[i]),则不能运送过去
	 *
	 */
	public int shipWithinDays(int[] weights, int days) {
		int maxVal = 0;
		int sum = 0;
		for (int weight : weights) {
			if(weight>maxVal) maxVal = weight;
			sum += weight;
		}
		int left = maxVal,right = sum;
		//[maxVal,sum]之间查询最低运载能力，二分查找左边界
		while(left <= right){
			int mid = left + (right - left) / 2;
			if(canShip(weights,mid,days)){
				//向左压缩边界
				right = mid-1;
			}else{
				//向右扩展
				left = mid+1;
			}
		}

		return left;
	}

	boolean canShip(int[] weights,int weight,int days){
		//所需天数
		int count = 1;
		//当前运载的重量
		int curWeight = 0;
		for (int w : weights) {
			curWeight += w;
			//超重，不能运送
			if(curWeight > weight){
				count++;
				//取最后一次不能运输的数量
				curWeight = w;
			}
			if(count>days) return false;
		}
		return true;
	}

























}
