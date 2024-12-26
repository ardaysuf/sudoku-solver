public class SudokuSolver {
    boolean controller(int[][] board, int n, int i, int j) { //this method controls row and column for same numbers
        for (int a = 0; a < board.length; a++) {
            if (board[i][a] == n || board[a][j] == n) return true;
        }
        return false;
    }

    boolean solveSudoku(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) { //if cell is empty
                    for (int num = 1; num <= board.length; num++) { //round the numbers from 1 to size
                        if (!controller(board, num, i, j)) { //if num doesn't exist in that row and column
                            board[i][j] = num; //assign that cell the num
                            if (solveSudoku(board)) { //if sudoku has resolved, return true
                                return true;
                            } else {
                                board[i][j] = 0; //if sudoku has not, zero the cell
                            }
                        }
                    }
                    return false; //if no number is suitable, return false
                }
            }
        }
        return true; //if all cells are full, that means sudoku has resolved
    }

    void display(int[][] board) {
        System.out.println("------------------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("------------------");
    }

    public static void main(String[] args) {
        SudokuSolver ss = new SudokuSolver();
        int n = 9; //the size of the board
        int[][] board = new int[n][n];

        board[0][0] = 5; //random values for create the board
        board[1][1] = 6;
        board[2][2] = 7;

        System.out.println("The First State:");
        ss.display(board);
        if (ss.solveSudoku(board)) {
            System.out.println("The Final State:");
            ss.display(board);
        } else {
            System.out.println("Sudoku couldn't solve...");
        }
    }
}
