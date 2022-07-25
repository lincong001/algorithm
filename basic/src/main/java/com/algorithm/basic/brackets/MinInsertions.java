package com.algorithm.basic.brackets;

/**
 * @author linchong
 * @version 1.0
 * @Date: 2022-07-25 20:34
 * @Description: MinInsertions$
 * <p>
 * 现在假设 1 个左括号需要匹配 2 个右括号才叫做合法的括号组合，那么给你输⼊⼀个括号串 s，请问你如何
 * 计算使得 s 合法的最⼩插⼊次数呢？
 * <p>
 * 核⼼思路还是和刚才⼀样，通过⼀个 need 变量记录对右括号的需求数，根据 need 的变化来判断是否需要插⼊。
 */
public class MinInsertions {

	int minInsertions(String s) {
		// need 记录需右括号的需求量
		int res = 0, need = 0;

		for (int i = 0; i < s.length(); i++) {
			// ⼀个左括号对应两个右括号
			//另外，当遇到左括号时，若对右括号的需求量为奇数，需要插⼊ 1 个右括号。因为⼀个左括号需要两个右括
			//号嘛，右括号的需求必须是偶数，这⼀点也是本题的难点。
			if (s.indexOf(i) == '(') {
				need += 2;
				if (need % 2 == 1) {
					res++;
					need--;
				}
			}

			if (s.indexOf(i)== ')') {
				need--;
				//当 need == -1 时，意味着我们遇到⼀个多余的右括号，显然需要插⼊⼀个左括号。
				//⽐如说当 s = ")"，我们肯定需要插⼊⼀个左括号让 s = "()"，但是由于⼀个左括号需要两个右括号，所
				//以对右括号的需求量变为 1：
				if (need == -1) {
					res++;
					need = 1;
				}

			}
		}

		return res + need;

	}

}
