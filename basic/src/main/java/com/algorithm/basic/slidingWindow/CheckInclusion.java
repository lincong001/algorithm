package com.algorithm.basic.slidingWindow;

import java.util.HashMap;

/**
 * @projectName: algorithm
 * @description: 567. 字符串的排列
 * @author: lincong
 * @date: 2022-03-20 17:01
 * @version: 0.0.1
 **/
public class CheckInclusion {
    /**
     * 给你两个字符串s1和s2 ，写一个函数来判断 s2 是否包含 s1的排列。如果是，返回 true ；否则，返回 false 。
     * 换句话说，s1 的排列之一是 s2 的 子串 。
     * 示例 1：
     *
     * 输入：s1 = "ab" s2 = "eidbaooo"
     * 输出：true
     * 解释：s2 包含 s1 的排列之一 ("ba").
     * 示例 2：
     *
     * 输入：s1= "ab" s2 = "eidboaoo"
     * 输出：false
     * 
     *
     * 提示：
     *
     * 1 <= s1.length, s2.length <= 104
     * s1 和 s2 仅包含小写字母
     *
     */

    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> need = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();
        char[] source= s2.toCharArray();

        for(char c:s1.toCharArray()){
            need.put(c,need.getOrDefault(c,0)+1);
        }
        int left = 0,right = 0;
        int valid = 0;
        while(right<source.length){
            char c = source[right];
            right++;

            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(need.get(c).equals(window.get(c))){
                    valid ++;
                }
            }

            //判断左侧是否需要收缩
            while(right-left>=s1.toCharArray().length){
                //找到了合法子串
                if(valid == need.size()){
                    return true;
                }
                char d = source[left];
                left ++;
                //更新窗口
                if(need.containsKey(d)){
                    if(need.get(d).equals(window.get(d))){
                        valid--;
                    }
                    window.put(d,window.getOrDefault(d,1)-1);
                }
            }
        }

        return false;
    }
}
