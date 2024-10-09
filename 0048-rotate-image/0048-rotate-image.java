class Solution {
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < row; i++) {
            for (int j = i + 1; j < col; j++) {
                // Swap elements matrix[i][j] and matrix[j][i] to transpose the matrix
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row to complete the 90-degree rotation
        for (int i = 0; i < row; i++) {
            for (int j = 0, k = col - 1; j < k; j++, k--) {
                // Swap elements matrix[i][j] and matrix[i][k] to reverse the row
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
            }
        }
    }
}
