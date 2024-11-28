class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null; 
    }
    TrieNode root;
    private void insertWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.word = word; 
    }

    public List<String> findWords(char[][] board, String[] words) {
        // Initialize the Trie
        root = new TrieNode();
        for (String word : words) {
            insertWord(word);
        }

        List<String> result = new ArrayList<>();
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                backtrack(board, i, j, root, result);
            }
        }
        return result;
    }

    private void backtrack(char[][] board, int row, int col, TrieNode node, List<String> result) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == '#') {
            return;
        }

        char c = board[row][col];
        int index = c - 'a';
        if (node.children[index] == null) {
            return;
        }
        node = node.children[index];
        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }
        board[row][col] = '#';

        backtrack(board, row - 1, col, node, result); // Up
        backtrack(board, row + 1, col, node, result); // Down
        backtrack(board, row, col - 1, node, result); // Left
        backtrack(board, row, col + 1, node, result); // Right

        board[row][col] = c;
    }
}
