package ru.leetcode.app.t417;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
    /**
     * https://leetcode.com/problems/pacific-atlantic-water-flow/
     * There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific
     * Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
     *
     * The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where
     * heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
     *
     * The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east,
     * and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow
     * from any cell adjacent to an ocean into the ocean.
     *
     * Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from
     * cell (ri, ci) to both the Pacific and Atlantic oceans.
     */

    class Solution {
        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            List<List<Integer>> result = new ArrayList<>();
            int rows = heights.length;
            int columns = heights[rows - 1].length;
            boolean[][] pacific = new boolean[rows][columns];
            boolean[][] atlantic = new boolean[rows][columns];
            for (int i = 0; i < rows; i++){
                mark(heights, i, 0, pacific, Integer.MIN_VALUE);
                mark(heights, i, columns - 1, atlantic, Integer.MIN_VALUE);
            }

            for(int j = 0; j < columns; j++) {
                mark(heights, 0, j, pacific, Integer.MIN_VALUE);
                mark(heights, rows - 1, j, atlantic, Integer.MIN_VALUE);
            }

            for(int i = 0; i < rows; i++) {
                for(int j = 0; j < columns; j++) {
                    if (pacific[i][j] && atlantic[i][j]){
                        result.add(List.of(i,j));
                    }
                }
            }
            return result;
        }

        private void mark(int[][] heights, int i, int j, boolean[][] ocean, int prevValue) {
            if (
                    i < 0 ||
                            i >= heights.length ||
                            j < 0 ||
                            j >= heights[i].length ||
                            ocean[i][j] ||
                            heights[i][j] < prevValue
            ) return;
            ocean[i][j] = true;
            mark(heights, i + 1, j, ocean, heights[i][j]);
            mark(heights, i - 1, j, ocean, heights[i][j]);
            mark(heights, i, j + 1, ocean, heights[i][j]);
            mark(heights, i, j - 1, ocean, heights[i][j]);
        }
    }
}
