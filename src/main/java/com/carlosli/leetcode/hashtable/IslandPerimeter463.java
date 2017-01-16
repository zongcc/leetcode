package com.carlosli.leetcode.hashtable;

import java.util.HashMap;

/**
 * Created by yulongli on 2017/1/16.
 */
public class IslandPerimeter463 {

    public static int islandPerimeter(int[][] grid) {
        HashMap<String, Integer> landMap = new HashMap<>();

        // 1.把陆地就放到landMap中，构建陆地map
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                if (grid[row][column] == 1)
                    // 原来key用的 rowcolumn连在一起  会出现 1行13列与11行3列冲突的情况，所以这里用-隔断
                    landMap.put(row + "-" + column, 0);
            }
        }
        // 2.对陆地进行边际判断
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                // 陆地进行边际判断，海水跳过
                if (grid[row][column] == 1) {
                    int boundaryCount = 0;

                    // 判断它上下左右四个坐标哪个是空（海水）
                    boundaryCount = setBoundaryCountByRowAndColumn(row - 1, column, boundaryCount, landMap);
                    boundaryCount = setBoundaryCountByRowAndColumn(row, column - 1, boundaryCount, landMap);
                    boundaryCount = setBoundaryCountByRowAndColumn(row + 1, column, boundaryCount, landMap);
                    boundaryCount = setBoundaryCountByRowAndColumn(row, column + 1, boundaryCount, landMap);

                    // 更新当前陆地的边际数量
                    landMap.put(row + "-" + column, boundaryCount);
                }
            }
        }
        int total = 0;
        for (Integer integer : landMap.values()) {
            total += integer;
        }
        return total;
    }

    private static int setBoundaryCountByRowAndColumn(int row, int column, int boundary, HashMap<String, Integer> landMap) {
        Integer integer = landMap.get(row + "-" + column);
        if (integer == null) boundary++;
        return boundary;
    }


    public static void main(String[] args) {
        int grid[][] = new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(islandPerimeter(grid));
        int grid2[][] = new int[][]{{1}};
        System.out.println(islandPerimeter(grid2));
        int grid3[][] = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}
        };
        System.out.println(islandPerimeter(grid3));
    }
}
