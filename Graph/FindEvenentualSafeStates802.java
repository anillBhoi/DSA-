// tc is O(v+E)
// sc is O(v)

class FindEvenentualSafeStates802 {
    // Helper function to detect cycles in the graph
    public static boolean isCyclic(List<List<Integer>> adj, int curr, boolean[] vis, boolean[] rec) {
        vis[curr] = true;
        rec[curr] = true;

        // DFS traversal
        for (int node : adj.get(curr)) {
            if (!vis[node] && isCyclic(adj, node, vis, rec)) {
                return true;
            } else if (rec[node]) {
                return true;
            }
        }

        rec[curr] = false; // Backtracking step
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;

        // Convert graph from int[][] to adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
            for (int node : graph[i]) {
                adj.get(i).add(node);
            }
        }

        boolean[] visited = new boolean[v];
        boolean[] inRecursion = new boolean[v];

        // Perform DFS for each node
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                isCyclic(adj, i, visited, inRecursion);
            }
        }

        // Collect all nodes that are not in recursion (safe nodes)
        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            if (!inRecursion[i]) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }
}