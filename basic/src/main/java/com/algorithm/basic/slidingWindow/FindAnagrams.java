package com.algorithm.basic.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @projectName: algorithm
 * @description: 438. 找到字符串中所有字母异位词
 * @author: lincong
 * @date: 2022-03-20 17:31
 * @version: 0.0.1
 **/
public class FindAnagrams {

    /**
     * 给定两个字符串s和 p，找到s中所有p的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
     *
     * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
     *
     * 
     *
     * 示例1:
     *
     * 输入: s = "cbaebabacd", p = "abc"
     * 输出: [0,6]
     * 解释:
     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
     * 示例 2:
     *
     * 输入: s = "abab", p = "ab"
     * 输出: [0,1,2]
     * 解释:
     * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
     * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
     * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
     * 
     *
     * 提示:
     *
     * 1 <= s.length, p.length <= 3 * 104
     * s和p仅包含小写字母
     *
     * 
     */

    public List<Integer> findAnagrams(String s, String p) {

            HashMap<Character,Integer> need = new HashMap<>();
            HashMap<Character,Integer> window = new HashMap<>();
            List<Integer> result = new ArrayList<Integer>();
            for(char c:p.toCharArray()){
                need.put(c,need.getOrDefault(c,0)+1);
            }
            char[] source = s.toCharArray();
            int left=0,right=0;
            int valid = 0;
            while(right < source.length){
                char c = source[right];
                right++;
                if(need.containsKey(c)){
                    window.put(c,window.getOrDefault(c,0)+1);
                    if(need.get(c).equals(window.get(c))){
                        valid++;
                    }
                }

                while(right-left>=p.length()){
                    if(need.size() == valid){
                        result.add(left);
                    }
                    char d = source[left];
                    left++;
                    if(need.containsKey(d)){
                        if(need.get(d).equals(window.get(d))){
                            valid--;
                        }
                        window.put(d,window.getOrDefault(d,1)-1);
                    }
                }

            }
            return result;
        }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p ="abc";
        System.out.println(new FindAnagrams().findAnagrams(s,p));
    }

}
