package Questions.Question1to30;

import java.util.Stack;

/**
 * 20. 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 *
 *
 */
class QuestionNumber20 {
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        char[] str = s.toCharArray();
        for (char i:str) {
            if (stack.isEmpty() || !isCompare(stack.peek(),i)){
                stack.push(i);
            }else if (isCompare(stack.peek(),i)){
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    private boolean isCompare(char a, char b){
        if (a == '{' && b == '}'){
            return true;
        }else if (a == '(' && b == ')'){
            return true;
        }else {
            return a == '[' && b == ']';
        }
    }

}
