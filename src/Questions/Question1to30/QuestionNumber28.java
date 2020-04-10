package Questions.Question1to30;

/**
 * 28. 实现 strStr()
 *
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 * 来源：力扣（LeetCode）
 *
 * 思路:
 *设置两个指针i和j，分别用于指向主串(haystack)和模式串(needle)
 * 从左到右开始一个个字符匹配
 * 如果主串和模式串的两字符相等，则i和j同时后移比较下一个字符
 * 如果主串和模式串的两字符不相等，就跳回去，即模式串向右移动，同时模式串指针归零(i = 1; j = 0)
 * 所有字符匹配结束后，如果模式串指针指到串尾(j = needle.length)，说明完全匹配，此时模式串出现的第一个第一个位置为：i - j
 * 代码：
 *
 * 作者：phantom_eve
 *
 * 来源：力扣（LeetCode）
 *
 */
class QuestionNumber28 {
    public int strStr(String haystack, String needle){
        char[] hayArr = haystack.toCharArray();
        char[] needArr =needle.toCharArray();
        int i =0;
        int j = 0;
        while (i < hayArr.length && j < needArr.length){
            if (hayArr[i] == needArr[j]){
                i++;
                j++;
            }else{
                i =i - j+1;
                j =0;
            }
        }
        if (j == needArr.length){
            return i - j;
        }else {
            return -1;
        }
    }
}
