package Questions.Question1to30;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * <p>
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序
 * <p>
 * 解法思路
 * 这是个排列组合问题对吧？这个排列组合可以用树的形式表示出来；
 * 当给定了输入字符串，比如："23"，那么整棵树就构建完成了.问题转化成了从根节点到空节点一共有多少条路径；
 */
class QuestionNumber17 {
    private String letterMap[] = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private ArrayList<String> res;

    public List<String> letterCombinayions(String digits) {

        res = new ArrayList<>();
        if (digits.equals("")) {
            return res;
        }
        findCombination(digits, 0, "");
        return res;
    }

    private void findCombination(String digits, int index, String s) {
        if (index == digits.length()) {
            res.add(s);
            return;
        }
        Character c = digits.charAt(index);
        String letters = letterMap[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            findCombination(digits, index + 1, s + letters.charAt(i));
        }
        return;
    }
}
