/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
int** generateMatrix(int n, int* returnSize, int** returnColumnSizes) {
    int** matrix = (int**)malloc(n * sizeof(int*));
    for (int i = 0; i < n; i++) {
        matrix[i] = (int*)malloc(n * sizeof(int));
    }
    *returnColumnSizes = (int*)malloc(n * sizeof(int));
    for (int i = 0; i < n; i++) {
        (*returnColumnSizes)[i] = n;
    }

 
    int top = 0, bottom = n - 1;
    int left = 0, right = n - 1;
    int num = 1;

    while (top <= bottom && left <= right) {
        // Move from left to right on the top boundary
        for (int i = left; i <= right; i++) {
            matrix[top][i] = num++;
        }
        top++;  // Move the top boundary down

        // Move from top to bottom on the right boundary
        for (int i = top; i <= bottom; i++) {
            matrix[i][right] = num++;
        }
        right--;  // Move the right boundary to the left

        // Move from right to left on the bottom boundary
        for (int i = right; i >= left; i--) {
            matrix[bottom][i] = num++;
        }
        bottom--;  // Move the bottom boundary up

        // Move from bottom to top on the left boundary
        for (int i = bottom; i >= top; i--) {
            matrix[i][left] = num++;
        }
        left++;  // Move the left boundary to the right
    }

    *returnSize = n;  // Set the size of the matrix

    return matrix;  // Return the filled spiral matrix
}