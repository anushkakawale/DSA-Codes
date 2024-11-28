class WordDictionary {

    private class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode() {
            children = new TrieNode[26]; // For 26 lowercase letters
            isEndOfWord = false;
        }
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode(); // Initialize the root of the Trie
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a'; // Map 'a' to 0, 'b' to 1, ..., 'z' to 25
            if (node.children[index] == null) {
                node.children[index] = new TrieNode(); // Create new node if not present
            }
            node = node.children[index];
        }
        node.isEndOfWord = true; // Mark the end of the word
    }

    public boolean search(String word) {
        return searchInNode(word, root);
    }

    private boolean searchInNode(String word, TrieNode node) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode child : node.children) {
                    if (child != null && searchInNode(word.substring(i + 1), child)) {
                        return true; 
                    }
                }
                return false; 
            } else {
                int index = c - 'a';
                if (node.children[index] == null) {
                    return false; 
                }
                node = node.children[index];
            }
        }
        return node.isEndOfWord; 
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
