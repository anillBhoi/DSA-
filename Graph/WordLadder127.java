


import java.util.*;

class WordLadder127{  // Solution using BFS 

    // Helper function to find neighbors (valid transformations)
    public List<String> getNeighbors(String node, HashSet<String> set) {
        List<String> neighbors = new ArrayList<>();
        // Iterate through each character of the node
        for (int i = 0; i < node.length(); i++) {
            char[] charArray = node.toCharArray();
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch == node.charAt(i)) {
                    continue;
                }
                charArray[i] = ch;
                String newWord = new String(charArray);
                if (set.contains(newWord)) {
                    neighbors.add(newWord);
                }
            }
        }
        return neighbors;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {   // tc O(N*L^2)
        // Convert the list of words into a HashSet for O(1) lookups
        HashSet<String> set = new HashSet<>(wordList); // O(N)

        // Corner case: if the endWord is not in the set, no solution exists
        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        // Insert the beginWord into the queue
        q.offer(beginWord);

        // Remove beginWord from the set if present
        set.remove(beginWord);

        int level = 1; // Initial level starts at 1
        while (!q.isEmpty()) {
            int curLevelSize = q.size();
            // Process all nodes in the current level
            for (int i = 0; i < curLevelSize; i++) {
                String node = q.poll();

                // If the endWord is found, return the current level
                if (node.equals(endWord)) {
                    return level;
                }

                // Generate neighbors for the current node
                List<String> neighbors = getNeighbors(node, set);

                // Add all valid neighbors to the queue and remove them from the set
                for (String word : neighbors) {
                    q.offer(word);
                    set.remove(word);
                }
            }
            level++; // Increment level after processing the current level
        }

        // If no path is found, return 0
        return 0;
    }
}
