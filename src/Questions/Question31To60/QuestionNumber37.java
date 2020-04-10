package Questions.Question31To60;

/**
 *37. 解数独
 * 编写一个程序，通过已填充的空格来解决数独问题。
 *
 * 一个数独的解法需遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 *
 * 来源：力扣（LeetCode）
 *
 * Note:
 *
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 */
class QuestionNumber37 {
    /**
     * 解数独思路：
     * 类似人的思考方式去尝试，行，列，还有 3*3 的方格内数字是 1~9 不能重复。
     *
     * 我们尝试填充，如果发现重复了，那么擦除重新进行新一轮的尝试，直到把整个数组填充完成。
     *
     * 算法步骤:
     * 数独首先行，列，还有 3*3 的方格内数字是 1~9 不能重复。
     *
     * 声明布尔数组，表明行列中某个数字是否被使用了， 被用过视为 true，没用过为 false。
     *
     * 初始化布尔数组，表明哪些数字已经被使用过了。
     *
     * 尝试去填充数组，只要行，列， 还有 3*3 的方格内 出现已经被使用过的数字，我们就不填充，否则尝试填充。
     *
     * 如果填充失败，那么我们需要回溯。将原来尝试填充的地方改回来。
     *
     * 递归直到数独被填充完成。
     *
     * 作者：I_use_python
     *
     * 来源：力扣（LeetCode）
     *
     * @param board
     */
    public void solveSudoku(char[][] board){
        boolean[][] rowUsed = new boolean[9][10];
        boolean[][] colUsed = new boolean[9][10];
        boolean[][][] boxUsed = new boolean[3][3][10];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                int num = board[row][col] -'0';
                if (1 <= num && num <= 9){
                    rowUsed[row][num] = true;
                    colUsed[row][num] = true;
                    boxUsed[row/3][col/3][num] = true;
                }
            }
        }
        recursiveSolveSudoku(board,rowUsed,colUsed,boxUsed,0,0);
    }
    private boolean recursiveSolveSudoku(char[][] board , boolean[][] rowUsed, boolean[][] colUsed , boolean[][][] boxUsed ,int row ,int col){
        if (col == board[0].length){
            col = 0;
            row++;
            if (row == board.length){
                return true;
            }
        }
        if (board[row][col] == '.'){
            for (int num = 1; num <=9 ; num++) {
                boolean canUsed = !(rowUsed[row][num] || colUsed[col][num] || boxUsed[row/3][col/3][num]);
                if (canUsed){
                    rowUsed[row][num] = true;
                    colUsed[row][num] = true;
                    boxUsed[row/3][col/3][num] = true;

                    board[row][col] = (char)('0' + num);
                    if (recursiveSolveSudoku(board,rowUsed,colUsed,boxUsed,row,col+1)){
                        return true;
                    }
                    board[row][col] = '.';
                    rowUsed[row][num] = false;
                    colUsed[row][num] = false;
                    boxUsed[row/3][col/3][num] = false;
                }
            }
        }else{
            return recursiveSolveSudoku(board,rowUsed,colUsed,boxUsed,row,col+1);
        }
        return false;
    }
}
