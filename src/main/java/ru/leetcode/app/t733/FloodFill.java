package ru.leetcode.app.t733;

public class FloodFill {
    /**
     * https://leetcode.com/problems/flood-fill/
     *
     * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
     *
     * You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from
     * the pixel image[sr][sc].
     *
     * To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting
     * pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels
     * (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.
     *
     * Return the modified image after performing the flood fill.
     */

    class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            if (color == image[sr][sc]) return image;
            fill(image, sr,sc,color, image[sr][sc]);
            return image;
        }

        private void fill(int[][] image, int i, int j, int color, int oldColor) {
            if (
                    i < 0 ||
                            i >= image.length ||
                            j < 0 ||
                            j >= image[i].length ||
                            image[i][j] != oldColor
            )
                return;
            image[i][j] = color;
            fill(image, i + 1, j, color, oldColor);
            fill(image, i - 1, j, color, oldColor);
            fill(image, i, j + 1, color, oldColor);
            fill(image, i, j - 1, color, oldColor);
        }
    }
}
