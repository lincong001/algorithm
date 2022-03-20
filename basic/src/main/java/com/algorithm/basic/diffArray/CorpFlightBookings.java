package com.algorithm.basic.diffArray;

import java.util.Arrays;

/**
 * @projectName: algorithm
 * @description: 1109. 航班预订统计
 * @author: lincong
 * @date: 2022-03-20 13:46
 * @version: 0.0.1
 **/
public class CorpFlightBookings {
    /**
     * 这里有n个航班，它们分别从 1 到 n 进行编号。
     *
     * 有一份航班预订表bookings ，表中第i条预订记录bookings[i] = [firsti, lasti, seatsi]意味着在从 firsti到 lasti
     * （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi个座位。
     *
     * 请你返回一个长度为 n 的数组answer，里面的元素是每个航班预定的座位总数。
     *
     * 示例 1：
     *
     * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
     * 输出：[10,55,45,25,25]
     * 解释：
     * 航班编号        1   2   3   4   5
     * 预订记录 1 ：   10  10
     * 预订记录 2 ：       20  20
     * 预订记录 3 ：       25  25  25  25
     * 总座位数：      10  55  45  25  25
     * 因此，answer = [10,55,45,25,25]
     * 示例 2：
     *
     * 输入：bookings = [[1,2,10],[2,2,15]], n = 2
     * 输出：[10,25]
     * 解释：
     * 航班编号        1   2
     * 预订记录 1 ：   10  10
     * 预订记录 2 ：       15
     * 总座位数：      10  25
     * 因此，answer = [10,25]
     *
     *
     * 提示：
     *
     * 1 <= n <= 2 * 104
     * 1 <= bookings.length <= 2 * 104
     * bookings[i].length == 3
     * 1 <= firsti <= lasti <= n
     * 1 <= seatsi <= 104
     *
     * 注意，范围，i,j,是从1开始的
     */
    class Difference{
        int[] diff;
        public Difference(int[] nums){
            diff = new int[nums.length];
            diff[0]= nums[0];
            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i]-nums[i-1];
            }
        }

        public void increase(int i,int j,int val){
            diff[i-1] += val;
            if(j<diff.length){
                diff[j] -= val;
            }
        }

        public int[] result(){
            int[] res = new int[diff.length];
            res[0] = diff[0];
            for (int i = 1; i < diff.length; i++) {
                res[i]=res[i-1]+diff[i];
            }
            return res;
        }
    }


    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        Difference df = new Difference(nums);
        for (int[] booking : bookings) {
            int start = booking[0];
            int end = booking[1];
            int seats = booking[2];
            df.increase(start,end,seats);
        }
        return df.result();
    }

    public static void main(String[] args) {
        int[][] bookings = {{1,2,10},{2,3,20},{2,5,25}};
        int n = 5;
        int[] books = new CorpFlightBookings().corpFlightBookings(bookings,n);
        Arrays.stream(books).forEach(item-> System.out.print(item+","));
    }
}
