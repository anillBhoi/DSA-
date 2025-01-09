public class Matrix01 {
    
}

// leetcode 42




class Solution {
    int m, n; // Variables to store the dimensions of the matrix
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Directions for BFS (up, down, left, right)

    public int[][] updateMatrix(int[][] mat) {
        m = mat.length; // Number of rows in the matrix
        n = mat[0].length; // Number of columns in the matrix

        // Initialize a result matrix to store the distances
        int[][] result = new int[m][n];

        // Queue to perform BFS
        Queue<int[]> queue = new LinkedList<>();
        // Loop through each cell in the matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    result[i][j] = 0; // Distance for cells with 0 is 0
                    queue.offer(new int[]{i, j}); // Add cell to queue for BFS
                } else {
                    result[i][j] = -1; // Set the cell's distance to -1 (indicating not calculated yet)
                }
            }
        }

        // Process each cell in the queue
        while (!queue.isEmpty()) {
            int[] cell = queue.poll(); // Retrieve and remove the head of the queue
            int i = cell[0]; // Current cell's row index
            int j = cell[1]; // Current cell's column index

            // Explore all possible directions from the current cell
            for (int[] dir : directions) {
                int new_i = i + dir[0]; // Calculate row index for the neighboring cell
                int new_j = j + dir[1]; // Calculate column index for the neighboring cell

                // Check if the new indices are within bounds and if the neighbor's distance is not calculated
                if (new_i >= 0 && new_i < m && new_j >= 0 && new_j < n && result[new_i][new_j] == -1) {
                    result[new_i][new_j] = result[i][j] + 1; // Update the neighbor's distance
                    queue.add(new int[]{new_i, new_j}); // Add the neighbor to the queue to continue BFS
                }
            }
        }

        // Return the updated result matrix with distances
        return result;
    }
}

