package com.algorithm.basic.brackets;

/**
 * @author linchong
 * @version 1.0
 * @Date: 2022-07-25 20:19
 * @Description: MinAddToMakeValid$
 * 给你输⼊⼀个字符串 s，你可以在其中的任意位置插⼊左括号 ( 或者右括号 )，请问你最少需要⼏次插⼊才
 * 能使得 s 变成⼀个合法的括号串？
 * 平衡括号串(一)「使括号有效的最少添加」
 */
public class MinAddToMakeValid {

	/**
	 * 核⼼思路是以左括号为基准，通过维护对右括号的需求数 need，来计算最⼩的插⼊次数
	 * 1. 当need<0时，说明右括号太多，需要插入左括号，即res++;
	 * 2. 算法为什么返回res+need?
	 *      res记录左括号的个数，need记录右括号的个数，当for循环结束时，若need不为0，说明
	 *      右括号多，需要插入左括号
	 * @param s
	 * @return
	 */
	int minAddToMakeValid(String s) {
		//res记录插入数
		int res = 0;
		//need记录需要的右括号数量
		int need = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.indexOf(i) == '(') {
				//对右括号的需求+1
				need++;
			}
			if (s.indexOf(i) == ')') {
				//对右括号的需求-1
				need--;
				if (need < 0) {
					need = 0;
					//需要插入一个左括号
					res++;
				}
			}
		}
		return res + need;
	}

}
