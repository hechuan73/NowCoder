package sword_offers;

/**
 * @author hechuan
 */
public class RobotMoving_65 {

    /**
     * Simple method with DFS.
     *
     * @param threshold the threshold
     * @param rows number of rows
     * @param cols number of columns
     * @return the count that robot can moving
     */
    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        // now we start ar (0,0), if we can start at anywhere, we need to traverse all coordinates.
        return dfs(threshold, rows, cols, 0, 0, visited);
    }

    private int dfs(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {
        if (col < 0 || col >= cols || row < 0 || row >= rows) { return 0; }
        if (visited[row][col] || !canReach(threshold, row, col)) { return 0; }
        visited[row][col] = true;
        return 1 + dfs(threshold, rows, cols, row-1, col, visited)
                + dfs(threshold, rows, cols, row+1, col, visited)
                + dfs(threshold, rows, cols, row, col-1, visited)
                + dfs(threshold, rows, cols, row, col+1, visited);
    }

    private boolean canReach(int threshold, int row, int col) {
        int res = 0;
        while (row > 0) {
            res += (row % 10);
            row /= 10;
        }

        while (col > 0) {
            res += (col % 10);
            col /= 10;
        }

        return res <= threshold;
    }
}
