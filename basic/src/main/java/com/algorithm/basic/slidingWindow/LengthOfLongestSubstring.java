package com.algorithm.basic.slidingWindow;

import java.util.HashMap;

/**
 * @projectName: algorithm
 * @description: 3. 无重复字符的最长子串
 * @author: lincong
 * @date: 2022-03-20 17:55
 * @version: 0.0.1
 **/
public class LengthOfLongestSubstring {
    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
     *
     * 
     *
     * 示例1:
     *
     * 输入: s = "abcabcbb"
     * 输出: 3 
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
     *     请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
     * 
     *
     * 提示：
     *
     * 0 <= s.length <= 5 * 104
     * s由英文字母、数字、符号和空格组成
     *
     */

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> window = new HashMap<>();
        int left=0,right=0;
        int res = 0;
        char[] source = s.toCharArray();
        while(right<s.length()){
            char c = source[right];
            right++;

            window.put(c,window.getOrDefault(c,0)+1);

            //判断左侧是否收缩
            while (window.get(c)>1){
                char d = source[left];
                left++;
                window.put(d,window.getOrDefault(d,1)-1);
            }
            res = Math.max(res,right-left);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
