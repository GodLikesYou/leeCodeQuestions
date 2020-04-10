package Questions.Question31To60;

/**
 * 52. N皇后 II
 * <p>
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 * <p>
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 */
class QuestionNumber52 {
    public boolean is_not_under_attack(int row, int col, int n, int[] rows, int[] hills, int[] dales) {
        int res = rows[col] + hills[row - col + 2 * n] + dales[row + col];
        return (res == 0) ? true : false;
    }

    public int backtrack(int row, int count, int n, int[] rows, int[] hills, int[] dales) {
        for (int col = 0; col < n; col++) {
            if (is_not_under_attack(row, col, n, rows, hills, dales)) {
                rows[col] = 1;
                hills[row - col + 2 * n] = 1;
                dales[row + col] = 1;
                if (row + 1 == n) {
                    count++;
                } else {
                    count = backtrack(row + 1, count, n, rows , hills, dales);
                }
                rows[col] = 0;
                hills[row - col + 2 * n] = 0;
                dales[row + col] = 0;
            }
        }
        return count;
    }

    public int totalNQueens(int n) {
        int rows[] = new int[n];
        int hills[] = new int[4 * n - 1];
        int dales[] = new int[2 * n - 1];
        return backtrack(0, 0, n, rows, hills, dales);
    }
}
