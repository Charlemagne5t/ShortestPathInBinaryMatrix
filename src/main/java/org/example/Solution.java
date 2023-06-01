package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        return bfs(grid);
    }

    private int bfs(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        boolean[][] visited = new boolean[n][n];
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curCoord = queue.poll();
                if (grid[curCoord[0]][curCoord[1]] == 1) continue;
                if (curCoord[0] == n - 1 && curCoord[1] == n - 1) return level;
                //NORTH
                if (curCoord[0] > 0 && !visited[curCoord[0] - 1][curCoord[1]]) {
                    queue.add(new int[]{curCoord[0] - 1, curCoord[1]});
                    visited[curCoord[0] - 1][curCoord[1]] = true;
                }
                //NORTH-EAST
                if (curCoord[0] > 0 && curCoord[1] < n - 1 && !visited[curCoord[0] - 1][curCoord[1] + 1]) {
                    queue.add(new int[]{curCoord[0] - 1, curCoord[1] + 1});
                    visited[curCoord[0] - 1][curCoord[1] + 1] = true;
                }
                //EAST
                if (curCoord[1] < n - 1 && !visited[curCoord[0]][curCoord[1] + 1]) {
                    queue.add(new int[]{curCoord[0], curCoord[1] + 1});
                    visited[curCoord[0]][curCoord[1] + 1] = true;
                }
                //SOUTH-EAST
                if (curCoord[0] < n - 1 && curCoord[1] < n - 1 && !visited[curCoord[0] + 1][curCoord[1] + 1]) {
                    queue.add(new int[]{curCoord[0] + 1, curCoord[1] + 1});
                    visited[curCoord[0] + 1][curCoord[1] + 1] = true;
                }
                //SOUTH
                if (curCoord[0] < n - 1 && !visited[curCoord[0] + 1][curCoord[1]]) {
                    queue.add(new int[]{curCoord[0] + 1, curCoord[1]});
                    visited[curCoord[0] + 1][curCoord[1]] = true;
                }

                //SOUTH-WEST
                if (curCoord[0] < n - 1 && curCoord[1] > 0 && !visited[curCoord[0] + 1][curCoord[1] - 1]) {
                    queue.add(new int[]{curCoord[0] + 1, curCoord[1] - 1});
                    visited[curCoord[0] + 1][curCoord[1] - 1] = true;
                }
                //WEST
                if (curCoord[1] > 0 && !visited[curCoord[0]][curCoord[1] - 1]) {
                    queue.add(new int[]{curCoord[0], curCoord[1] - 1});
                    visited[curCoord[0]][curCoord[1] - 1] = true;
                }
                //NORTH-WEST
                if (curCoord[0] > 0 && curCoord[1] > 0 && !visited[curCoord[0] - 1][curCoord[1] - 1]) {
                    queue.add(new int[]{curCoord[0] - 1, curCoord[1] - 1});
                    visited[curCoord[0] - 1][curCoord[1] - 1] = true;
                }
            }
            level++;
        }
        return -1;
    }
}
