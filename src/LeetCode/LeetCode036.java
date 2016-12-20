package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Valid Sudoku
 *
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 *
 * KeyWords: HashTable
 * Difficulty: Easy
 */
public class LeetCode036 {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> rl = new ArrayList<Set<Character>>();
        List<Set<Character>> cl = new ArrayList<Set<Character>>();
        List<Set<Character>> sl = new ArrayList<Set<Character>>();

        for(int i=0; i<9; i++) {
            rl.add(new HashSet<Character>());
            cl.add(new HashSet<Character>());
            sl.add(new HashSet<Character>());
        }
        int n = board.length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                char c = board[i][j];
                if(c=='.') continue;
                else if(rl.get(i).contains(c) || cl.get(j).contains(c) || sl.get(i/3*3 + j/3).contains(c)) return false;
                else {
                    rl.get(i).add(c);
                    cl.get(j).add(c);
                    sl.get(i/3*3+j/3).add(c);
                }
            }
        }

        return true;
    }

    //Better Solution
    public boolean isValidSudoku2(char[][] board) {
        for(int i = 0; i<9; i++){
            HashSet<Character> rows = new HashSet<Character>();
            HashSet<Character> columns = new HashSet<Character>();
            HashSet<Character> cube = new HashSet<Character>();
            for (int j = 0; j < 9;j++){
                if(board[i][j]!='.' && !rows.add(board[i][j]))
                    return false;
                if(board[j][i]!='.' && !columns.add(board[j][i]))
                    return false;
                int RowIndex = 3*(i/3);
                int ColIndex = 3*(i%3);
                if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
                    return false;
            }
        }
        return true;
    }
}
