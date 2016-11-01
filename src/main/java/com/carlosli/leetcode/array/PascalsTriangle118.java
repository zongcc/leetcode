package com.carlosli.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yulongli on 2016/11/1.
 */
public class PascalsTriangle118 {
    /**
     * i位置的，等于上一行 i-1   + i 的和
     *
     * @param numRows
     * @return
     */
    public static List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (numRows == 0) return lists;


        List<Integer> firstLine = new ArrayList<Integer>();
        firstLine.add(1);
        lists.add(firstLine);

        for (int i = 2; i <= numRows; i++) {
            List<Integer> line = new ArrayList<Integer>();

            List<Integer> lastLine = lists.get(i - 2);
            for (int j = 1; j <= i; j++) {
                Integer lastIPre = 0;
                try {
                    lastIPre = lastLine.get(j - 1 - 1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Integer lastI = 0;
                try {
                    lastI = lastLine.get(j - 1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                line.add(lastI + lastIPre);
            }
            lists.add(line);
        }
        return lists;
    }

    public static List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows > 0) {
            List<Integer> row = new ArrayList<Integer>();
            row.add(1);
            result.add(row);
        }

        if (numRows > 1) {
            for (int i = 0; i < numRows - 1; i++) {
                List<Integer> lastRow = result.get(i);
                List<Integer> newRow = new ArrayList<Integer>();

                newRow.add(1);
                for (int j = 0; j < lastRow.size() - 1; j++) {
                    newRow.add(lastRow.get(j) + lastRow.get(j + 1));
                }
                newRow.add(1);

                result.add(newRow);
            }
        }

        return result;

    }


    public static void main(String[] args) {
        List<List<Integer>> generate = generate2(5);

        for (List<Integer> outList : generate) {
            Object[] innerList = outList.toArray();
            System.out.println(Arrays.toString(innerList));
        }
    }

}
