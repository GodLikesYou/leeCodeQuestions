package Questions.Question1to30;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * <p>
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * <p>
 * 思路：n对括号包含2n个括号，第一个括号必定为左括号，在添加括号的中途，只需要处理如下情况即可：
 * 变量定义：
 * n：剩余需匹配的括号数，初始为2n。
 * num：当前已生成字符串str中左括号大于有括号的个数
 * (1)下一个可添加的括号为左括号或有括号，成立条件，当且仅当n的数目减去num还有剩余
 * 解释：剩余匹配字符数n首先需要考虑括号配对情况，保证最终括号字符串左右括号数相等
 * (2)下一个可添加的括号为左括号，num为0时成立
 * 解释：说明此时生成的字符串中左右括号已经匹配完成，下一个若添加右括号，则该右括号左边无左括号与其对应。此时只能添加左括号。
 * (3)下一个可添加的括号为右括号，n-num无剩余时成立
 * 此时剩下的n均用于添加右括号以保证左右括号个数的匹配
 * <p>
 * 作者：ssimz
 * <p>
 * 来源：力扣（LeetCode）
 */
class QuestionNumber22 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        String str = new String("(");
        find(list,str,2*n-1,1);
        return list;
    }

    public void find(List list, String s, int n, int num) {
        if (n == 0) {
            list.add(s);
            return;
        }
        if (n >= num + 2 && num >= 1) {
            find(list, s + "(", n - 1, num + 1);
            find(list, s + ")", n - 1, num - 1);
        } else if (num == 0) {
            find(list, s + "(", n - 1, num + 1);
            find(list, s + ")", n - 1, num - 1);
        }
    }
}
