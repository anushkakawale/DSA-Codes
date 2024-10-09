/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* spiralOrder(int** matrix, int matrixSize, int* matrixColSize, int* returnSize) {
    int minr = 0, maxr = matrixSize - 1;
    int minc = 0, maxc = *matrixColSize - 1;
    int totalElements = matrixSize * (*matrixColSize);
    int* result = (int*)malloc(totalElements * sizeof(int));
    int count = 0;

    *returnSize = totalElements;  

    while (count < totalElements) {
        for (int i = minc; i <= maxc && count < totalElements; i++) {
            result[count++] = matrix[minr][i];
        }
        minr++;  
        for (int i = minr; i <= maxr && count < totalElements; i++) {
            result[count++] = matrix[i][maxc];
        }
        maxc--; 
        for (int i = maxc; i >= minc && count < totalElements; i--) {
            result[count++] = matrix[maxr][i];
        }
        maxr--;  
        for (int i = maxr; i >= minr && count < totalElements; i--) {
            result[count++] = matrix[i][minc];
        }
        minc++; 
    }

    return result;
}