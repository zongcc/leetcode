package com.carlosli.leetcode.array;

import java.util.ArrayList;
import java.util.List;

import static com.carlosli.leetcode.array.PascalsTriangle118.generate;

/**
 * Created by yulongli on 2016/11/1.
 */
public class PascalsTriangleII119 {

    /**
     * i位置的，等于上一行 i-1   + i 的和
     *
     * @return
     */
    public static List<Integer> getRow(int rowIndex) {
        ArrayList<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> firstLine = new ArrayList<Integer>();
        firstLine.add(1);
        lists.add(firstLine);

        for (int i = 2; i <= rowIndex + 1; i++) {
            List<Integer> line = new ArrayList<Integer>();

            List<Integer> lastLine = lists.get(i - 2);
            for (int j = 1; j <= i; j++) {
                Integer lastIPre = 0;
                try {
                    lastIPre = lastLine.get(j - 1 - 1);
                } catch (Exception e) {
                }
                Integer lastI = 0;
                try {
                    lastI = lastLine.get(j - 1);
                } catch (Exception e) {
                }
                line.add(lastI + lastIPre);
            }
            lists.add(line);
        }
        return lists.get(rowIndex);
    }

    public static List<Integer> getRow2(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        if (rowIndex < 0)
            return list;

        for (int i = 0; i < rowIndex + 1; i++) {
            list.add(0, 1);
            for (int j = 1; j < list.size() - 1; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
        }
        return list;
    }


    public static void main(String[] args) {
        List<Integer> generate = getRow2(4);
        for (Integer integer : generate) {
            System.out.print(integer+",");
        }
    }

}
