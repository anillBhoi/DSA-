// time complexity O(N * L^2)
// space complexity O(n * L)
class WordLadder126 {
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
   public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // Convert the list of words into a HashSet for O(1) lookups
       HashSet<String> set = new HashSet<>(wordList); // O(N)
       List<List<String>> res = new ArrayList<>();

       // Corner case: if the endWord is not in the set, no solution exists
       if (!set.contains(endWord)) {
           return res;
       }
       List<String>subList = new ArrayList<>();
       subList.add(beginWord);

       Queue<List<String>> q = new LinkedList<>();
       // Insert the beginWord into the queue
       q.offer(subList);

       // Remove beginWord from the set if present
       set.remove(beginWord);

       int level = 1; 
       int resLevel = -1;

       while (!q.isEmpty()) {
           HashSet<String> usedWords = new HashSet<>();
           int curLevelSize = q.size();
           // Process all nodes in the current level
           for (int i = 0; i < curLevelSize; i++) {
               List<String> nodeList = q.poll();
               String node = nodeList.get(nodeList.size()-1);


               // If the endWord is found, return the current level
               if (node.equals(endWord)) {
                   resLevel = level;
                   res.add(nodeList);
                   //return level;
               }

               // Generate neighbors for the current node
               List<String> neighbors = getNeighbors(node, set);

               // Add all valid neighbors to the queue and remove them from the set
               for (String word : neighbors) {
                   
                       nodeList.add(word);
                      q.offer(new ArrayList<>(nodeList));
                      nodeList.remove(word);
                      usedWords.add(word);
                     // set.remove(word);
                   
                   
               }
           }
           for(String visited : usedWords){
               set.remove(visited);
           }
           if(level == resLevel){
               break;
           }
           level++; // Increment level after processing the current level
       }

       // If no path is found, return 0
       return res;
   }
}
