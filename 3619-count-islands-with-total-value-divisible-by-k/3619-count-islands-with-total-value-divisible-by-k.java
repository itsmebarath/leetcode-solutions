class Solution {

    int m, n;
    boolean[][] visited;

    int[] rowDir = {-1, 1, 0, 0};
    int[] colDir = {0, 0, -1, 1};

    public int countIslands(int[][] grid, int k) {

        m = grid.length;
        n = grid[0].length;

        visited = new boolean[m][n];

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] > 0 && !visited[i][j]) {

                    long sum = dfs(grid, i, j);

                    if (sum % k == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private long dfs(int[][] grid, int r, int c) {

        if (r < 0 || c < 0 || r >= m || c >= n
                || grid[r][c] == 0 || visited[r][c]) {
            return 0;
        }

        visited[r][c] = true;

        long sum = grid[r][c];

        for (int d = 0; d < 4; d++) {

            int nr = r + rowDir[d];
            int nc = c + colDir[d];

            sum += dfs(grid, nr, nc);
        }

        return sum;
    }
}