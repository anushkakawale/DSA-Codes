class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;  // Size of the Sudoku board (9x9)

        // Arrays of HashSets to track the characters in each row, column, and 3x3 sub-box
        HashSet<Character>[] rows = new HashSet[N];
        HashSet<Character>[] cols = new HashSet[N];
        HashSet<Character>[] boxes = new HashSet[N];

        // Initialize the HashSet arrays
        for (int i = 0; i < N; i++) {
            rows[i] = new HashSet<Character>();
            cols[i] = new HashSet<Character>();
            boxes[i] = new HashSet<Character>();
        }

        // Iterate over each cell in the Sudoku board
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                char val = board[r][c];

                // Skip empty cells (represented by '.')
                if (val == '.') {
                    continue;
                }

                // Check for duplicates in the current row
                if (rows[r].contains(val)) {
                    return false;
                }
                rows[r].add(val);  // Add the value to the current row's HashSet

                // Check for duplicates in the current column
                if (cols[c].contains(val)) {
                    return false;
                }
                cols[c].add(val);  // Add the value to the current column's HashSet

                // Calculate the index for the corresponding 3x3 sub-box
                int idx = (r / 3) * 3 + c / 3;

                // Check for duplicates in the current 3x3 sub-box
                if (boxes[idx].contains(val)) {
                    return false;
                }
                boxes[idx].add(val);  // Add the value to the current sub-box's HashSet
            }
        }

        // If no duplicates are found, the Sudoku board is valid
        return true;
    }
}
