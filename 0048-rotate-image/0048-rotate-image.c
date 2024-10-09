void rotate(int** matrix, int matrixSize, int* matrixColSize) {
    // Step 1: Transpose the matrix
    for (int i = 0; i < matrixSize; i++) {
        for (int j = i + 1; j < matrixSize; j++) {
            // Swap matrix[i][j] and matrix[j][i]
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }

    // Step 2: Reverse each row
    for (int i = 0; i < matrixSize; i++) {
        for (int j = 0, k = matrixSize - 1; j < k; j++, k--) {
            // Swap elements matrix[i][j] and matrix[i][k]
            int temp = matrix[i][j];
            matrix[i][j] = matrix[i][k];
            matrix[i][k] = temp;
        }
    }
}