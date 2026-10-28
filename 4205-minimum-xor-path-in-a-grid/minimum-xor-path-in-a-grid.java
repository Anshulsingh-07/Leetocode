import java.util.Arrays;

class Solution {
    // 1024 covers all XOR values up to 10 bits (0 to 1023)
    private int[][][] memo; 
    private int M, N;

    public int minCost(int[][] grid) {
        M = grid.length;
        N = grid[0].length;
        
        // Initialize memoization table with -1
        memo = new int[M][N][1024];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        return dfs(grid, 0, 0, grid[0][0]);
    }

    private int dfs(int[][] grid, int i, int j, int currentXor) {
        // Base Case: Reached the bottom-right corner
        if (i == M - 1 && j == N - 1) {
            return currentXor;
        }

        // Return cached result if already calculated
        if (memo[i][j][currentXor] != -1) {
            return memo[i][j][currentXor];
        }

        int minPathXor = Integer.MAX_VALUE;

        // Move Down
        if (i + 1 < M) {
            minPathXor = Math.min(minPathXor, dfs(grid, i + 1, j, currentXor ^ grid[i + 1][j]));
        }

        // Move Right
        if (j + 1 < N) {
            minPathXor = Math.min(minPathXor, dfs(grid, i, j + 1, currentXor ^ grid[i][j + 1]));
        }

        // Store and return result
        return memo[i][j][currentXor] = minPathXor;
    }
}
