class TrieNode {
    public boolean isEndOfWord; 
    public TrieNode[] children; 

    public TrieNode() {
        this.isEndOfWord = false;
        this.children = new TrieNode[26]; 
    }
}

class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode(); 
    }
    
    // Insert a word into the Trie
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a'; 
            if (node.children[index] == null) {
                node.children[index] = new TrieNode(); 
            }
            node = node.children[index];
        }
        node.isEndOfWord = true; 
    }
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a'; 
            if (node.children[index] == null) {
                return false; 
            }
            node = node.children[index];
        }
        return node.isEndOfWord; 
    }
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a'; 
            if (node.children[index] == null) {
                return false; 
            }
            node = node.children[index];
        }
        return true; 
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
