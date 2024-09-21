public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);  // Create a set of words for fast lookup
        if (!wordSet.contains(endWord)) return 0;  // If endWord is not in the wordList, no transformation is possible
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);  // Start the BFS from the beginWord
        int level = 1;  // At the beginning, the transformation level is 1 (just the beginWord)
        
        while (!queue.isEmpty()) {
            int size = queue.size();  // Number of words to process at the current level
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();  // Get the next word to process
                
                // Try all possible one-letter transformations
                for (int j = 0; j < currentWord.length(); j++) {
                    char[] currentWordArray = currentWord.toCharArray();
                    
                    // Change the j-th character to every possible lowercase letter
                    for (char c = 'a'; c <= 'z'; c++) {
                        char oldChar = currentWordArray[j];
                        currentWordArray[j] = c;
                        String newWord = new String(currentWordArray);
                        
                        // If the new word is the endWord, we have found the solution
                        if (newWord.equals(endWord)) {
                            return level + 1;
                        }
                        
                        // If the new word is in the wordSet and hasn't been visited yet
                        if (wordSet.contains(newWord)) {
                            queue.offer(newWord);  // Add it to the queue for further processing
                            wordSet.remove(newWord);  // Remove it from the set to mark it as visited
                        }
                        
                        // Restore the original word character
                        currentWordArray[j] = oldChar;
                    }
                }
            }
            level++;  // Increment the level as we move to the next set of transformations
        }
        
        return 0;  // If no transformation was found
    }
}
