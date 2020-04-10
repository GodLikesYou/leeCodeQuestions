package Questions.Question31To60;


/**
 * 43. 字符串相乘
 * <p>
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * <p>
 * 来源：力扣（LeetCode）
 */
class QuestionNumber43 {
    /**
     * 1.此题整体的思路就是将第二个乘数的每一位和第一个乘数相乘,
     * 将得到的每一行数字放入二维数组中,
     * 比如123 * 456,, 6 * 123得到第一行数字 738,5 * 123 得到第二行数字 6150,
     * 4 * 123 得到第三行数字 49200,(第二行之后的低位用0补齐),
     * 然后将他们加起来即是结果;
     * <p>
     * 作者：spirit-9
     * <p>
     * 来源：力扣（LeetCode）
     *
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int len1 = num1.length(), len2 = num2.length();
        int[][] arr = new int[len2][len1 + len2];
        int pos = 0;
        for (int j = len2 - 1; j >= 0; j--) {
            StringBuffer s = new StringBuffer();
            int temp = 0;
            for (int i = len1 - 1; i >= 0; i--) {
                temp += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                s.append(temp % 10);
                temp /= 10;
            }
            if (temp != 0) {
                s.append(temp);
            }
            int k = 0;
            int index = arr[0].length - 1 - pos;
            while (k < s.length()) {
                arr[pos][index--] = s.charAt(k) - '0';
                k++;
            }
            pos++;
        }
        StringBuilder s = new StringBuilder();
        int temp = 0;
        for (int k = arr[0].length - 1; k >= 0; k--) {
            for (int i = 0; i < arr.length; i++) {
                temp += arr[i][k];
            }
            s.append(temp % 10);
            temp /= 10;
        }
        String res = s.reverse().toString();
        int i = 0;
        while (res.charAt(i) == '0') {
            i++;
        }
        return res.substring(i);
    }
}
