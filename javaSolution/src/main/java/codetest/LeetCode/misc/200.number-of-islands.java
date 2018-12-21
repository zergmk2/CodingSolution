import java.util.LinkedList;
import java.util.Queue;

/*
 * [200] Number of Islands
 *
 * https://leetcode.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (37.66%)
 * Total Accepted:    205.4K
 * Total Submissions: 545.1K
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
 * islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of
 * the grid are all surrounded by water.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * 
 * Output: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * 
 * Output: 3
 * 
 * 
 */
class Solution {
    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0)
        {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        //boolean[][] checked = new boolean[m][n];
        int cnt = 0;

        int[][] directions = new int[][] {
                // bottom
            {0, 1},
            {1, 0}, // right
            {0, -1}, // top
            {-1, 0} // left
        };

        Queue<int[]> queue = new LinkedList<int[]>();

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] == '1')
                {
                    queue.add(new int[] {i, j});
                    cnt++;

                    while(queue.size() != 0)
                    {
                        int[] cell = queue.poll();
                        int row = cell[0];
                        int col = cell[1];
                        if (grid[row][col] == 'T')
                        {
                            continue;
                        }
                        grid[row][col] = 'T';

                        for(int[] d : directions)
                        {
                            int r = d[0] + row;
                            int c = d[1] + col;
                            if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == '0') {
                                continue;
                            }

                            queue.add(new int[] {r, c});
                        }
                    }
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        char[][] grid = new char[][]
                {
                        {'1','1','1','1','0'},
                        {'1','1','0','1','0'},
                        {'1','1','0','0','0'},
                        {'0','0','0','0','0'}
                };
        System.out.println(s.numIslands(grid));
    }
//
//    private void dfs(int[][] grid, int r, int c)
//    {
//
//    }
}
