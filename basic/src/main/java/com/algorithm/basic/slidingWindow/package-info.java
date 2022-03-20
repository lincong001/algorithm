/**
 * 维护⼀个窗⼝，不断滑动，然后更新答案
 * 思想不难，细节繁多，如：
 *  如何向窗⼝中添加新元素，
 *  如何缩⼩窗⼝，
 *  如何在窗⼝滑动的哪个阶段更新结果
 *
 * 76. 最⼩覆盖⼦串（困难）
 * 567. 字符串的排列（中等）
 * 438. 找到字符串中所有字⺟异位词（中等）
 * 3. ⽆重复字符的最⻓⼦串（中等）
 */
package com.algorithm.basic.slidingWindow;


        /*int left = 0, right = 0;

        while (right < s.size()) {
        // 增⼤窗⼝
        window.add(s[right]);
        right++;

        while (window needs shrink) {
            // 缩⼩窗⼝
            window.remove(s[left]);
            left++;
            }
        }*/


/* 滑动窗⼝算法框架 */
    /*void slidingWindow(String s, String t) {

        HashMap<Character,Integer> need,window;
        for(char c:t.toCharArray()){
            need.put(c,need.getOrDefault(c,0)+1);
        }

        int left = 0, right = 0;
        int valid = 0;
        while (right < s.toCharArray().length) {
            // c 是将移⼊窗⼝的字符
            char c = s.charAt(right);
            // 右移窗⼝
            right++;
            // 进⾏窗⼝内数据的⼀系列更新
            //...

            *//*** debug 输出的位置 ***//*
            print("window: [%d, %d)\n", left, right);
            *//********************//*

            // 判断左侧窗⼝是否要收缩
            while (window needs shrink) {
                // d 是将移出窗⼝的字符
                char d = s[left];
                // 左移窗⼝
                left++;
                // 进⾏窗⼝内数据的⼀系列更新
                //...
            }
        }
    }*/
