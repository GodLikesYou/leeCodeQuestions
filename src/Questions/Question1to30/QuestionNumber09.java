package Questions.Question1to30;

/**
 * 9. 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 *
 * 思路
 * 标签：数学
 * 如果是负数则一定不是回文数，直接返回 false
 * 如果是正数，则将其倒序数值计算出来，然后比较和原数值是否相等
 * 如果是回文数则相等返回 true，如果不是则不相等 false
 * 比如 123 的倒序 321，不相等；121 的倒序 121，相等
 *
 * 作者：guanpengchn
 *
 * 来源：力扣（LeetCode）
 *
 */
class QuestionNumber09 {
    public boolean isPalindrome(int x){
        if (x < 0){
            return false;
        }
        int cur = 0;
        int num = x;
        while (num != 0){
            cur = cur * 10 +num %10;
            num /= 10;
        }
        return cur == x;
    }
}
