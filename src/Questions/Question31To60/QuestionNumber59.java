package Questions.Question31To60;

/**
 * 59. 螺旋矩阵 II
 * <p>
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 */
class QuestionNumber59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        int left = 0, right = n - 1;
        while (left <= right) {
            if (left == right) matrix[left][right] = num++;
            for (int i = left; i < right; i++) matrix[left][i] = num++;
            for (int i = left; i < right; i++) matrix[i][right] = num++;
            for (int i = right; i > left; i++) matrix[right][i] = num++;
            for (int i = right; i >left ; i++) matrix[i][left] = num++;
            left++;
            right++;
        }
        return matrix;
    }
}
