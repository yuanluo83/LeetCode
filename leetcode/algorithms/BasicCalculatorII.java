/*
 * 227. Basic Calculator II

Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
Note: Do not use the eval built-in library function.

 */

package algorithms;

import java.util.Stack;

public class BasicCalculatorII {

	public int calculate(String s) {
        int len;
        if(s==null || (len = s.length())==0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        char ch;
        for(int i=0;i<len;i++){
            ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num = num*10 + ch -'0';
            }
            if((!Character.isDigit(ch) && ch !=' ') || i==len-1){
                if(sign=='-'){
                    stack.push(-num);
                }
                if(sign=='+'){
                    stack.push(num);
                }
                if(sign=='*'){
                    stack.push(stack.pop()*num);
                }
                if(sign=='/'){
                    stack.push(stack.pop()/num);
                }
                sign = ch;
                num = 0;
            }
        }
    
        int result = 0;
        for(int i : stack){
            result += i;
        }
        return result;
    }
}
