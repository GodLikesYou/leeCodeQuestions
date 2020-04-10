package Questions.Question31To60;

import java.util.Stack;

/**
 * 32. 最长有效括号
 *
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 * 来源：力扣（LeetCode）
 *
 */
class QuestionNumber32 {
    /**
     * 解法三 动态规划
     * 首先定义动态规划的数组代表什么
     *
     * dp [ i ] 代表以下标 i 结尾的合法序列的最长长度，
     * 下标 1 结尾的最长合法字符串长度是 2，下标 3 结尾的最长字符串是 str [ 0 , 3 ]，长度是 4 。
     *
     * 我们来分析下 dp 的规律。
     *
     * 首先我们初始化所有的 dp 都等于零。
     *
     * 以左括号结尾的字符串一定是非法序列，所以 dp 是零，不用更改。
     *
     * 以右括号结尾的字符串分两种情况。
     *
     * 右括号前边是 ( ，类似于 ……（）。
     *
     * dp [ i ] = dp [ i - 2] + 2 （前一个合法序列的长度，加上当前新增的长度 2）
     *
     * 类似于上图中 index = 3 的时候的情况。
     *
     * dp [ 3 ] = dp [ 3 - 2 ] + 2 = dp [ 1 ] + 2 = 2 + 2 = 4
     *
     * 右括号前边是 )，类似于 ……））。
     *
     * 此时我们需要判断 i - dp[i - 1] - 1 （前一个合法序列的前边一个位置） 是不是左括号。
     *
     * 例如上图的 index = 7 的时候，此时 index - 1 也是右括号，我们需要知道 i - dp[i - 1] - 1 = 7 - dp [ 6 ] - 1 = 4 位置的括号的情况。
     *
     * 而刚好 index = 4 的位置是左括号，此时 dp [ i ] = dp [ i - 1 ] + dp [ i - dp [ i - 1] - 2 ] + 2 （当前位置的前一个合法序列的长度，加上匹配的左括号前边的合法序列的长度，加上新增的长度 2），也就是 dp [ 7 ] = dp [ 7 - 1 ] + dp [ 7 - dp [ 7 - 1] - 2 ] + 2 = dp [ 6 ] + dp [7 - 2 - 2] + 2 = 2 + 4 + 2 = 8。
     *
     * 如果 index = 4 不是左括号，那么此时位置 7 的右括号没有匹配的左括号，所以 dp [ 7 ] = 0 ，不需要更新。
     *
     * 下边看下代码。
     *
     * 作者：windliang
     *
     * 来源：力扣（LeetCode）
     *
     */
    public int longestValidParentheses(String s){
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i= 1; i < s.length();i++){
            if (s.charAt(i) == ')'){
                if (s.charAt(i - 1) == '('){
                    dp[i] = (i >= 2 ? dp[ i - 2] : 0 ) + 2;
                }else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i -1]  -1) == '('){
                    dp[i] = dp[i -1] + ((i -dp[i - 1]) >= 2 ? dp[i -dp[i - 1] -2] : 0 ) +2;
                }
                maxans = Math.max(maxans,dp[i]);
            }
        }
        return maxans;
    }
    /**
     * 解法四 使用栈
     * 从左到右扫描字符串，栈顶保存当前扫描的时候，合法序列前的一个位置位置下标是多少，啥意思嘞？
     *
     * 我们扫描到左括号，就将当前位置入栈。
     *
     * 扫描到右括号，就将栈顶出栈（代表栈顶的左括号匹配到了右括号），然后分两种情况。
     *
     * 栈不空，那么就用当前的位置减去栈顶的存的位置，然后就得到当前合法序列的长度，然后更新一下最长长度。
     *
     * 栈是空的，说明之前没有与之匹配的左括号，那么就将当前的位置入栈。
     *
     * 作者：windliang
     *
     * 来源：力扣（LeetCode）
     *
     *
     */
    public int longestValidParentheses1(String s){
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0;i < s.length(); i++){
            if (s.charAt(i) == '('){
                stack.push(i);
            }else {
                maxans = Math.max(maxans, i -stack.peek());
            }
        }
        return maxans;
    }

    /**
     * 解法五 神奇解法
     * 保持时间复杂度是 O（n），将空间复杂度优化到了 O（1），它的动机是怎么想到的没有理出来，就介绍下它的想法吧。
     *
     * 从左到右扫描，用两个变量 left 和 right 保存的当前的左括号和右括号的个数，都初始化为 0 。
     *
     * 如果左括号个数等于右括号个数了，那么就更新合法序列的最长长度。
     * 如果左括号个数大于右括号个数了，那么就接着向右边扫描。
     * 如果左括号数目小于右括号个数了，那么后边无论是什么，此时都不可能是合法序列了，此时 left 和 right 归 0，然后接着扫描。
     * 从左到右扫描完毕后，同样的方法从右到左再来一次，因为类似这样的情况 ( ( ( ) ) ，如果从左到右扫描到最后，left = 3，right = 2，期间不会出现 left == right。但是如果从右向左扫描，扫描到倒数第二个位置的时候，就会出现 left = 2，right = 2 ，就会得到一种合法序列。
     *
     * 作者：windliang
     *
     * 来源：力扣（LeetCode）
     *
     */
    public int longestValidParentheses2(String s){
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                left++;
            }else{
                right++;
            }
            if (left == right){
                maxlength = Math.max(maxlength, 2* right);
            } else if (right >= left){
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() -1;i >= 0; i--){
            if (s.charAt(i) == '('){
                left++;
            }else{
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2* left);
            }else if (left >= right){
                left = right = 0;
            }
        }
        return maxlength;
    }
}
