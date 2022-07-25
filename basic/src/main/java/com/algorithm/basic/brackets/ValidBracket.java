package com.algorithm.basic.brackets;

import java.util.Stack;

/**
 * @projectName: algorithm
 * @description: �жϺϷ����Ŵ�
 * @author: lincong
 * @date: 2022-07-25 16:20
 * @version: 0.0.1
 **/
public class ValidBracket {

	//���������ž�?ջ�����������ž�ȥջ��Ѱ������������ţ����Ƿ�ƥ��
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
