import java.util.*;

class Solution {
    // Class to represent each state in the BFS queue
    class State {
        int r, c, t, ene, mask;
        State(int r, int c, int t, int ene, int mask) {
            this.r = r;
            this.c = c;
            this.t = t;
            this.ene = ene;
            this.mask = mask;
        }
    }

    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        char[][] grid = new char[m][n];
        
        int si = 0, sj = 0;
        int laptopCount = 0;
        
        // Map to give each laptop 'L' a unique ID (0 to laptopCount - 1)
        int[][] laptopId = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            String str = classroom[i];
            for (int j = 0; j < n; j++) {
                grid[i][j] = str.charAt(j);
                if (grid[i][j] == 'S') {
                    si = i;
                    sj = j;
                } else if (grid[i][j] == 'L') {
                    laptopId[i][j] = laptopCount++;
                }
            }
        }

        // Target mask when all laptops are collected
        int allCollected = (1 << laptopCount) - 1;
        int[][] adj = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        
        // 4D Visited array: [row][col][remaining_energy][collected_laptops_mask]
        boolean[][][][] vis = new boolean[m][n][energy + 1][1 << laptopCount];
        
        Queue<State> q = new LinkedList<>();
        q.add(new State(si, sj, 0, energy, 0));
        vis[si][sj][energy][0] = true;

        while (!q.isEmpty()) {
            State curr = q.poll();

            // If all laptops collected, return total moves/time taken
            if (curr.mask == allCollected) {
                return curr.t;
            }

            // Out of energy, cannot move further from this state
            if (curr.ene == 0) {
                continue;
            }

            for (int i = 0; i < adj.length; i++) {
                int row = curr.r + adj[i][0];
                int col = curr.c + adj[i][1];

                // Boundary and obstacle check
                if (row >= 0 && row < m && col >= 0 && col < n && grid[row][col] != 'X') {
                    int nextEne = curr.ene - 1;
                    int nextMask = curr.mask;

                    // Recharge station resets energy to initial full capacity
                    if (grid[row][col] == 'R') {
                        nextEne = energy;
                    } 
                    // Laptop collection updates the state mask
                    else if (grid[row][col] == 'L') {
                        int id = laptopId[row][col];
                        nextMask |= (1 << id);
                    }

                    // Process if this specific state configuration hasn't been visited
                    if (!vis[row][col][nextEne][nextMask]) {
                        vis[row][col][nextEne][nextMask] = true;
                        q.add(new State(row, col, curr.t + 1, nextEne, nextMask));
                    }
                }
            }
        }

        // Return -1 if it's impossible to collect all laptops
        return -1;
    }
}
