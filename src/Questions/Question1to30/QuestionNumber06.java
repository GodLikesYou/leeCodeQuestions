package Questions.Question1to30;

/**
 * 6. Z 字形变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * 来源：力扣（LeetCode）
 *
 * 思路
 * 标签：字符串
 * 整体的思路是遍历字符串，遍历过程中将每行都看成新的字符串构成字符串数组，最后再将该数组拼接起来即可
 * 如果 numRows=1numRows=1 则说明当前字符串即为结果，直接返回
 * 否则整个字符串需要经历，向下向右，向下向右，这样的反复循环过程，设定 downdown 变量表示是否向下，locloc 变量表示当前字符串数组的下标
 * 如果 downdown 为 truetrue，则 loc+=1loc+=1，字符串数组下标向后移动，将当前字符加入当前字符串中
 * 如果 downdown 为 falsefalse，则表示向右，则 loc-=1loc−=1，字符串数组下标向前移动，将当前字符加入当前字符串中
 * 时间复杂度：O(n)O(n)，nn为字符串s的长度
 *
 * 作者：guanpengchn
 *
 * 来源：力扣（LeetCode）
 */
class QuestionNumber06 {
    public String convert(String s, int numRows){
        if (numRows == 1) {
            return s;
        }
        int len = Math.min(s.length(),numRows);
        String[] rows = new String[len];
        for (int i = 0; i<s.length();i++){
            rows[i] = "";
        }
        int loc = 0;
        boolean down = false;
        for (int i = 0;i<s.length();i++){
            rows[loc] += s.substring(i,i+1);
            if (loc == 0 || loc == numRows -1){
                down =! down;
            }
            loc += down ? 1 : -1;
        }
        String  ans = "";
        for (String row:rows){
            ans += row;
        }
        return ans;
    }
}
