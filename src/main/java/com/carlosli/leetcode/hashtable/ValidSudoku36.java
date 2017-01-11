package com.carlosli.leetcode.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yulongli on 2017/1/10.
 */
public class ValidSudoku36 {
    public static boolean isValidSudoku(char[][] board) {
        // 对每一横行进行判断，看是否有重复数字
        for (int hang = 0; hang < board.length; hang++) {
            char[] chars = board[hang];
            Set<Character> set = new HashSet<>();
            for (int lie = 0; lie < chars.length; lie++) {
                char c = chars[lie];
                if (c != '.') {
                    boolean contains = set.contains(c);
                    if (contains) {
                        System.out.println("hang:" + hang + ":" + lie + ":" + c);
                        return false;
                    } else {
                        set.add(c);
                    }
                }
            }
        }
        // 对每一列进行判断，看是否有重复数字
        for (int lie = 0; lie < board.length; lie++) {
            Set<Character> set = new HashSet<>();
            for (int hang = 0; hang < board[lie].length; hang++) {
                char c = board[hang][lie];
                if (c != '.') {
                    boolean contains = set.contains(c);
                    if (contains) {
                        System.out.println("lie:" + lie + ":" + hang + ":" + c);
                        return false;
                    } else {
                        set.add(c);
                    }
                }
            }
        }

        // 对9个小方格分别检测
        for (int hang = 0; hang < 9; ) {
            for (int lie = 0; lie < 9; ) {
                Set<Character> set = new HashSet<>();
                for (int xHang = hang; xHang < hang + 3; xHang++) {
                    for (int xLei = lie; xLei < lie + 3; xLei++) {
                        System.out.println(hang + ":" + xHang + ":" + lie + ":" + xLei);
                        char c = board[xHang][xLei];
                        if (c != '.') {
                            boolean contains = set.contains(c);
                            if (contains) {
                                System.out.println("@:" + xHang + ":" + xLei + ":" + c);
                                return false;
                            } else {
                                set.add(c);
                            }
                        }
                    }
                }
                lie += 3;
            }
            hang += 3;
        }
        return true;
    }

    public static boolean isValidSudoku2(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> rows = new HashSet<Character>();
            HashSet<Character> columns = new HashSet<Character>();
            HashSet<Character> cube = new HashSet<Character>();
            for (int j = 0; j < 9; j++) {
                // 对行进行判断
                if (board[i][j] != '.' && !rows.add(board[i][j]))
                    return false;
                // 对列进行判断
                if (board[j][i] != '.' && !columns.add(board[j][i]))
                    return false;

                // 这里想的时候，不要吧i、j当成行列，就当成数字来理解
                int RowIndex = 3 * (i / 3);
                int ColIndex = 3 * (i % 3);
                System.out.println(i + ":" + j + " | " + RowIndex + ":" + ColIndex + " | " + (RowIndex + j / 3) + ":" + (ColIndex + j % 3));
                if (board[RowIndex + j / 3][ColIndex + j % 3] != '.' && !cube.add(board[RowIndex + j / 3][ColIndex + j % 3]))
                    return false;
            }
        }
        return true;
    }

    public static boolean isValidSudoku3(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isParticallyValid(board, i, 0, i, 8)) return false;
            if (!isParticallyValid(board, 0, i, 8, i)) return false;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!isParticallyValid(board, i * 3, j * 3, i * 3 + 2, j * 3 + 2)) return false;
            }
        }
        return true;
    }

    private static boolean isParticallyValid(char[][] board, int x1, int y1, int x2, int y2) {
        Set singleSet = new HashSet();
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (board[i][j] != '.') if (!singleSet.add(board[i][j])) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] sudoku = makeSudoku();
        boolean validSudoku = isValidSudoku2(sudoku);
        System.out.println(validSudoku);
    }

    private static char[][] makeSudoku() {
        char[][] sudoku = new char[9][9];

        sudoku[0][0] = '5';
        sudoku[0][1] = '3';
        sudoku[0][2] = '.';
        sudoku[0][3] = '.';
        sudoku[0][4] = '7';
        sudoku[0][5] = '.';
        sudoku[0][6] = '.';
        sudoku[0][7] = '.';
        sudoku[0][8] = '.';

        sudoku[1][0] = '6';
        sudoku[1][1] = '.';
        sudoku[1][2] = '.';
        sudoku[1][3] = '1';
        sudoku[1][4] = '9';
        sudoku[1][5] = '5';
        sudoku[1][6] = '.';
        sudoku[1][7] = '.';
        sudoku[1][8] = '.';

        sudoku[2][0] = '.';
        sudoku[2][1] = '9';
        sudoku[2][2] = '8';
        sudoku[2][3] = '.';
        sudoku[2][4] = '.';
        sudoku[2][5] = '.';
        sudoku[2][6] = '.';
        sudoku[2][7] = '6';
        sudoku[2][8] = '.';

        sudoku[3][0] = '8';
        sudoku[3][1] = '.';
        sudoku[3][2] = '.';
        sudoku[3][3] = '.';
        sudoku[3][4] = '6';
        sudoku[3][5] = '.';
        sudoku[3][6] = '.';
        sudoku[3][7] = '.';
        sudoku[3][8] = '3';

        sudoku[4][0] = '4';
        sudoku[4][1] = '.';
        sudoku[4][2] = '.';
        sudoku[4][3] = '8';
        sudoku[4][4] = '.';
        sudoku[4][5] = '3';
        sudoku[4][6] = '.';
        sudoku[4][7] = '.';
        sudoku[4][8] = '1';

        sudoku[5][0] = '7';
        sudoku[5][1] = '.';
        sudoku[5][2] = '.';
        sudoku[5][3] = '.';
        sudoku[5][4] = '2';
        sudoku[5][5] = '.';
        sudoku[5][6] = '.';
        sudoku[5][7] = '.';
        sudoku[5][8] = '6';

        sudoku[6][0] = '.';
        sudoku[6][1] = '6';
        sudoku[6][2] = '.';
        sudoku[6][3] = '.';
        sudoku[6][4] = '.';
        sudoku[6][5] = '.';
        sudoku[6][6] = '2';
        sudoku[6][7] = '8';
        sudoku[6][8] = '.';

        sudoku[7][0] = '.';
        sudoku[7][1] = '.';
        sudoku[7][2] = '.';
        sudoku[7][3] = '4';
        sudoku[7][4] = '1';
        sudoku[7][5] = '9';
        sudoku[7][6] = '.';
        sudoku[7][7] = '.';
        sudoku[7][8] = '5';

        sudoku[8][0] = '.';
        sudoku[8][1] = '.';
        sudoku[8][2] = '.';
        sudoku[8][3] = '.';
        sudoku[8][4] = '8';
        sudoku[8][5] = '.';
        sudoku[8][6] = '.';
        sudoku[8][7] = '7';
        sudoku[8][8] = '9';

        return sudoku;
    }
}
