package com.algorithm.basic.brackets;

import java.util.Stack;

/**
 * @projectName: algorithm
 * @description: 判断合法括号串
 * @author: lincong
 * @date: 2022-07-25 16:20
 * @version: 0.0.1
 **/
public class ValidBracket {

	//遇到左括号就?栈，遇到右括号就去栈中寻找最近的左括号，看是否匹配
    boolean isValid(String str){
        Stack<Character> left = new Stack<>();
        for(char c:str.toCharArray()){
            if('('==c || '['==c || '{'==c){
                left.push(c);
            }else{
                if(!left.isEmpty()&&leftOf(c)==left.peek())
                    left.pop();
                else
                    return false;
            }
        }
        return left.isEmpty();
    }

    private Character leftOf(char c) {
        if(')'==c) return '(';
        if(']'==c) return '[';
        return '{';
    }
}
