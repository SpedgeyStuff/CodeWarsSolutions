package SudokuSolutionValidator;

import java.util.HashSet;
import java.util.Set;

public class SudokuValidator {

    public static void main(String[] args){
        SudokuValidator validator = new SudokuValidator();
        int[][] sudoku = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        validator.check(sudoku);
    }

    public static boolean check(int[][] sudoku){
        return validate(sudoku);
    }

    public static boolean validate(int[][] sudoku){
        if(!checkIfComplete(sudoku) || !checkBlocks(sudoku) || !checkRowsAndColumns(sudoku)){
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkIfComplete(int[][] sudoku){
        int emptyCounter=0;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(sudoku[i][j] == 0){
                    emptyCounter++;
                }
            }
        }
        if(emptyCounter > 0){
            System.out.println("You left " + emptyCounter + " spaces empty!");
            return false;
        } else {
            System.out.println("true - checkIfComplete");
            return true;
        }
    }

    public static boolean checkBlocks(int[][] sudoku){ // returns true if correct, return false if incorrect
        for(int i = 0; i < 9; i= i+3){
            for(int j = 0; j < 9; j=j+3){
                if(!checkBlock(sudoku, i, j)){
                    System.out.println("false - checkBlocks");

                    return false;
                }
            }
        }
        System.out.println("true - checkBlocks");
        return true;
    }

    public static boolean checkBlock(int[][] sudoku, int x, int y){
        Set<Integer> resultSet = new HashSet<>();
        for(int k = x; k < x+3; k++){
            for(int l = y; l < y+3; l++) {
                if(!resultSet.add(sudoku[k][l])){
                    System.out.println("false - checkBlock");
                    return false;
                }
            }
        }
        System.out.println("true - checkBlock");
        return true;
    }

    public static boolean checkRowsAndColumns(int[][] sudoku){
        Set<Integer> xResultSet = new HashSet<>();
        Set<Integer> yResultSet = new HashSet<>();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(!yResultSet.add(sudoku[i][j])){
                    System.out.println("false - checkRowsAndColumns");
                    return false;
                }
                if(!xResultSet.add(sudoku[j][i])) {
                    System.out.println("false - checkRowsAndColumns");
                    return false;
                }
                if(j==8){
                    yResultSet.clear();
                    xResultSet.clear();
                }
            }
        }
        System.out.println("true - checkRowsAndColumns");
        return true;
    }
}
