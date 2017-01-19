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

    /*
        1.遍历矩阵，统计岛屿（1）的个数
        2.若当前节点是岛屿，统计是否有右和下的邻居数量
        3.结果通过公式计算得出islands * 4 - neighbours * 2
        ** 重点在于：因为每个相邻岛，中间的两个边界消失。
     */
    public static int islandPerimeter2(int[][] grid) {
        int islands = 0, neighbours = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++; // count islands
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++; // 统计下邻居
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) neighbours++; // 统计右邻居
                    /* 多种方法统计邻居  上左， 上右， 下左， 下右 */
                    /* 不可同时统计上下  或 左右 ，前者【1,1】  后者【1】【1】会出现判断错误 */

//                    if (i >0&& grid[i-1][j] == 1) neighbours++; // 统计上邻居
//                    if (j >0&& grid[i][j-1] == 1) neighbours++; // 统计左邻居
                }
            }
        }
        return islands * 4 - neighbours * 2;
    }

    /*
    所有在一侧具有水和在另一侧具有土地的侧部将是周界的一部分。 这里有两种方法来编写这个想法：
    迭代所有的单元格，如果当前单元格是陆地单元格，然后检查是否有邻近这个陆地单元格的水单元格
    要么
    迭代所有的细胞，如果当前细胞是水细胞，然后检查是否有邻近这个水细胞的每一侧的陆地细胞
     */
    public static int islandPerimeter3(int[][] grid) {
        // 这个用来判断每个节点的上下左右的坐标变换
        int[][] d = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0)
                    continue;

                // 判断当前陆地的上下左右是否为水 或 边界外，循环4次
                for (int k = 0; k < d.length; k++) {
                    int x = i + d[k][0], y = j + d[k][1];
                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0)
                        perimeter++;
                }
            }
        }
        return perimeter;
    }

    public static void main(String[] args) {
        int grid[][] = new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(islandPerimeter(grid));

        System.out.println("----------------");
        int grid1[][] = new int[][]{{1, 1, 0}, {1, 0, 0}, {0, 0, 0}};
        System.out.println(islandPerimeter2(grid1));

        System.out.println("----------------");
        int grid2[][] = new int[][]{{1}};
        System.out.println(islandPerimeter(grid2));

        System.out.println("----------------");
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

        System.out.println("----------------");
        int grid4[][] = new int[][]{{1, 0, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(islandPerimeter3(grid4));
    }
}
