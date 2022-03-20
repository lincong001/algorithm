package com.algorithm.basic.diffArray;

/**
 * @projectName: algorithm
 * @description: 1094. 拼车
 * @author: lincong
 * @date: 2022-03-20 14:27
 * @version: 0.0.1
 **/
public class CarPooling {
    /**
     * 
     * 假设你是一位顺风车司机，车上最初有capacity个空座位可以用来载客。由于道路的限制，车只能向一个方向行驶（也就是说，不允许掉头或改变方向，你可以将其想象为一个向量）。
     *
     * 这儿有一份乘客行程计划表trips[][]，其中trips[i] = [num_passengers, start_location, end_location]包含了第 i 组乘客的行程信息：
     *
     * 必须接送的乘客数量；
     * 乘客的上车地点；
     * 以及乘客的下车地点。
     * 这些给出的地点位置是从你的初始出发位置向前行驶到这些地点所需的距离（它们一定在你的行驶方向上）。
     *
     * 请你根据给出的行程计划表和车子的座位数，来判断你的车是否可以顺利完成接送所有乘客的任务（当且仅当你可以在所有给定的行程中接送所有乘客时，返回true，否则请返回 false）。
     *
     * 
     *
     * 示例 1：
     *
     * 输入：trips = [[2,1,5],[3,3,7]], capacity = 4
     * 输出：false
     * 示例 2：
     *
     * 输入：trips = [[2,1,5],[3,3,7]], capacity = 5
     * 输出：true
     * 示例 3：
     *
     * 输入：trips = [[2,1,5],[3,5,7]], capacity = 3
     * 输出：true
     * 示例 4：
     *
     * 输入：trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
     * 输出：true
     *
     * 提示：
     *
     * 你可以假设乘客会自觉遵守 “先下后上” 的良好素质
     * trips.length <= 1000
     * trips[i].length == 3
     * 1 <= trips[i][0] <= 100
     * 0 <= trips[i][1] < trips[i][2] <= 1000
     * 1 <=capacity <= 100000
     *
     */
    class Difference{
        private int[] diff;
        public Difference(int[] nums){
            diff = new int[nums.length];
            diff[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i] = nums[i-1];
            }
        }

        public void increase(int i,int j,int val){
            diff[i] += val;
            if(j+1<diff.length){
                diff[j+1] -= val;
            }
        }

        public int[] result(){
            int[] res = new int[diff.length];
            res[0] = diff[0];
            for (int i = 1; i < diff.length; i++) {
                res[i] = res[i-1]+diff[i];
            }
            return res;
        }
    }

    public boolean carPooling(int[][] trips, int capacity) {
        int[] nums = new int[1000+1];
        Difference df = new Difference(nums);
        for (int[] trip : trips) {
            //乘客数量
            int val = trip[0];
            //第trip[start]站乘客上车
            int start = trip[1];
            //第trip[end]站乘客下车，乘客乘车区间是[trip[start],trip[end]-1]
            int end = trip[2]-1;
            df.increase(start,end,val);
        }
        int[] res = df.result();
        boolean flag = true;
        for (int size : res) {
            if(size>capacity){
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {

        int[][] trips = {{2,1,5},{3,5,7}};
        int capacity = 3;
        System.out.println(new CarPooling().carPooling(trips,capacity));
    }
}
