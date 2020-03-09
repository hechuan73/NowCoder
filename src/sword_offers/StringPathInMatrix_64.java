package sword_offers;

/**
 * @author hechuan
 */
public class StringPathInMatrix_64 {

    /**
     * Backtracking solution.
     *
     * @param matrix char matrix
     * @param rows number of rows
     * @param cols number of columns
     * @param str target char array
     * @return whether there is a path for target string
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[] visited = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backtracking(matrix, rows, cols, i, j, str, 0, visited)) { return true; }
            }
        }

        return false;
    }

    private boolean backtracking(char[] matrix, int rows, int cols, int row, int col,
                                 char[] str, int index, boolean[] visited) {
        if (index == str.length) { return true; }
        if (row >= rows || row < 0 || col >= cols || col < 0) { return false; }
        int idx = row*cols+col;
        if (visited[idx] || str[index] != matrix[idx]) { return false; }
        visited[idx] = true;
        if (backtracking(matrix, rows, cols, row+1, col, str, index+1, visited)
                || backtracking(matrix, rows, cols, row-1, col, str, index+1, visited)
                || backtracking(matrix, rows, cols, row, col+1, str, index+1, visited)
                || backtracking(matrix, rows, cols, row, col-1, str, index+1, visited)) {
            return true;
        }

        return visited[idx] = false;
    }
}
