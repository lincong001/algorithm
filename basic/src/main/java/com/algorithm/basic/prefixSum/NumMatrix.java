package com.algorithm.basic.prefixSum;

/**
 * @projectName: algorithm
 * @description: 二维区域和检索
 * @author: lincong
 * @date: 2022-03-11 11:31
 * @version: 0.0.1
 **/
public class NumMatrix {
    /**
     * 给定一个二维矩阵 matrix，以下类型的多个请求：
     *
     * 计算其子矩形范围内元素的总和，该子矩阵的 左上角 为 (row1,col1) ，右下角 为 (row2,col2) 。
     * 实现 NumMatrix 类：
     *
     * NumMatrix(int[][] matrix)给定整数矩阵 matrix 进行初始化
     * int sumRegion(int row1, int col1, int row2, int col2)返回 左上角 (row1,col1)、右下角(row2,col2) 所描述的子矩阵的元素 总和 。
     *
     * 输入:
     * ["NumMatrix","sumRegion","sumRegion","sumRegion"]
     * [[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,1,2,2],[1,2,2,4]]
     * 输出:
     * [null, 8, 11, 12]
     *
     * 解释:
     * NumMatrix numMatrix = new NumMatrix([[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]);
     * numMatrix.sumRegion(2, 1, 4, 3); // return 8
     * numMatrix.sumRegion(1, 1, 2, 2); // return 11
     * numMatrix.sumRegion(1, 2, 2, 4); // return 12
     *
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m,n <=200
     * -105<= matrix[i][j] <= 105
     * 0 <= row1 <= row2 < m
     * 0 <= col1 <= col2 < n
     * 最多调用 104 次sumRegion 方法
     *
     */

    int[][] preSum;
    public NumMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if(rows==0||cols==0)
            return;

        preSum = new int[rows+1][cols+1];
        preSum[0][0] = matrix[0][0];
        for(int i=1;i<=rows;i++){
            for(int j = 1;j<=cols;j++){
                preSum[i][j] = preSum[i-1][j] +preSum[i][j-1]-preSum[i-1][j-1]+matrix[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2+1][col2+1] - preSum[row1][col2+1] - preSum[row2+1][col1]
                + preSum[row1][col1];
    }

    public static void main(String[] args) {
        int[][] matrix = {{2,4,7,4},
                          {1,5,1,1},
                          {9,2,3,2},
                          {4,2,9,5}};

        NumMatrix instance = new NumMatrix(matrix);
        System.out.println(instance.sumRegion(1,1,2,2));
    }

}
