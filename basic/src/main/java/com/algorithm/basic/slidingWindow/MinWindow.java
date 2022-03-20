package com.algorithm.basic.slidingWindow;

import java.util.HashMap;


/**
 * @projectName: algorithm
 * @description: 76. 最小覆盖子串
 * @author: lincong
 * @date: 2022-03-20 15:20
 * @version: 0.0.1
 **/
public class MinWindow {
    /**
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     *
     * 
     *
     * 注意：
     *
     * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
     * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
     * 
     *
     * 示例 1：
     *
     * 输入：s = "ADOBECODEBANC", t = "ABC"
     * 输出："BANC"
     * 示例 2：
     *
     * 输入：s = "a", t = "a"
     * 输出："a"
     * 示例 3:
     *
     * 输入: s = "a", t = "aa"
     * 输出: ""
     * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
     * 因此没有符合条件的子字符串，返回空字符串。
     * 
     *
     * 提示：
     *
     * 1 <= s.length, t.length <= 105
     * s 和 t 由英文字母组成
     * 
     *
     * 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？
     *
     * 解析：
     * 1、我们在字符串 S 中使⽤双指针中的左右指针技巧，初始化 left = right = 0，把索引左闭右开区间 [left, right) 称为⼀个「窗⼝」。
     * 2、我们先不断地增加 right 指针扩⼤窗⼝ [left, right)，直到窗⼝中的字符串符合要求（包含了T中的所有字符）。
     * 3、此时，我们停⽌增加 right，转⽽不断增加 left 指针缩⼩窗⼝ [left, right)，直到窗⼝中的字符串 不再符合要求（不包含 T 中的所有字符了）。
     * 同时，每次增加 left，我们都要更新⼀轮结果。
     * 4、重复第 2 和第 3 步，直到 right 到达字符串 S 的尽头。
     *
     * 第 2 步相当于在寻找⼀个「可⾏解」，然后第 3 步在优化这个「可⾏解」
     *
     * 滑动窗⼝代码框架的使用：
     *  1.⾸先，初始化 window 和 need 两个哈希表，记录窗⼝中的字符和需要凑⻬的字符：
     *      Map<Character,Integer> need, window;
     *      for (char c : t) need[c]++;
     *  2.然后，使⽤ left 和 right 变量初始化窗⼝的两端，不要忘了，区间 [left, right) 是左闭右开的，所以
     *  初始情况下窗⼝没有包含任何元素：
     *      int left = 0, right = 0;
     *      int valid = 0;
     *      while (right < s.size()) {
     *          // 开始滑动
     *      }
     * 其中 valid 变量表示窗⼝中满⾜ need 条件的字符个数，如果 valid 和 need.size 的⼤⼩相同，则说明窗
     * ⼝已满⾜条件，已经完全覆盖了串 T。
     *
     * 现在开始套模板，只需要思考以下四个问题：
     *  1、当移动 right 扩⼤窗⼝，即加⼊字符时，应该更新哪些数据？
     *  2、什么条件下，窗⼝应该暂停扩⼤，开始移动 left 缩⼩窗⼝？
     *  3、当移动 left 缩⼩窗⼝，即移出字符时，应该更新哪些数据？
     *  4、我们要的结果应该在扩⼤窗⼝时还是缩⼩窗⼝时进⾏更新？
     *
     *  如果⼀个字符进⼊窗⼝，应该增加 window 计数器；
     *  如果⼀个字符将移出窗⼝的时候，应该减少 window 计 数器；
     *   当 valid 满⾜ need 时应该收缩窗⼝；
     *   应该在收缩窗⼝的时候更新最终结果。
     *
     *
     */

    public String minWindow(String s, String t) {
        //⾸先，初始化 window 和 need 两个哈希表，记录窗⼝中的字符和需要凑⻬的字符：
        HashMap<Character,Integer> need = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();
        char[] needChars = t.toCharArray();
        char[] sourceChars = s.toCharArray();
        for(char c:needChars){
            need.put(c,need.getOrDefault(c,0)+1);
        }
        //然后，使⽤ left 和 right 变量初始化窗⼝的两端，不要忘了，区间 [left, right) 是左闭右开的，所以
        //初始情况下窗⼝没有包含任何元素：
        int left=0,right=0;
        //已验证的元素，其中 valid 变量表示窗⼝中满⾜ need 条件的字符个数，
        // 如果 valid 和 need.size 的⼤⼩相同，则说明窗 ⼝已满⾜条件，已经完全覆盖了串 T。
        int valid = 0;
        //记录最小覆盖子串的起始索引以及长度
        int start=0,len = Integer.MAX_VALUE;
        while(right<sourceChars.length){
            //c是将移入窗口的字符
            char c = sourceChars[right];
            //右移窗口
            right++;
            System.out.printf("window: [%d, %d)\n", left, right);
            //更新窗口内的数据
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                //如果滑动窗口中含有字符的数量同需要的字符数量相同，更新结果
                if(window.get(c).equals(need.get(c))){
                    valid++;
                }
            }

            //判断左侧窗口是否需要收缩
            while(valid == need.size()){
                //在这里更新最小覆盖子串
                if(right-left<len){
                    start = left;
                    len = right - left;
                }
                //d是将移出窗口的字符
                char d = sourceChars[left];
                //左移窗口
                left++;
                //更新窗口
                if(need.containsKey(d)){
                    if(window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d,window.getOrDefault(d,1)-1);
                }
            }
        }
        return len==Integer.MAX_VALUE?"":s.substring(start,start+len);
    }

    public static void main(String[] args) {
        //String s = "ADOBECODEBANC", t = "ABC";
        String s = "a", t = "aa";
        System.out.println("result:"+new MinWindow().minWindow(s,t));
    }
}
