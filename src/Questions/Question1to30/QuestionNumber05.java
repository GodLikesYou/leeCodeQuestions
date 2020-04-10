package Questions.Question1to30;

/**
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 *
 * 解法 2: 最长公共子串
 * 根据回文串的定义，正着和反着读一样，那我们是不是把原来的字符串倒置了，然后找最长的公共子串就可以了。例如 S = "caba" ，S = "abac"，最长公共子串是 "aba"，所以原字符串的最长回文串就是 "aba"。
 * <p>
 * 关于求最长公共子串（不是公共子序列），有很多方法，这里用动态规划的方法， 整体思想就是，申请一个二维的数组初始化为 0，然后判断对应的字符是否相等，相等的话
 * <p>
 * arr [ i ][ j ] = arr [ i - 1 ][ j - 1] + 1 。
 * <p>
 * 当 i = 0 或者 j = 0 的时候单独分析，字符相等的话 arr [ i ][ j ] 就赋为 1 。
 * <p>
 * arr [ i ][ j ] 保存的就是公共子串的长度。
 * <p>
 * 作者：windliang
 * 来源：力扣（LeetCode）
 */
class QuestionNumber05 {
    public String longestPalindrome(String s) {
        if (s.equals("")) {
            return "";
        }
        String origin = s;
        String reverse = new StringBuffer(s).reverse().toString();
        int length = s.length();
        int[][] arr = new int[length][length];
        int maxLen = 0;
        int maxEnd = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (origin.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    }
                }
                if (arr[i][j] > maxLen) {
                    maxLen = arr[i][j];
                    maxEnd = i;
                }
            }
        }
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }
}
