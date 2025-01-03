import java.util.*;

// Definition for a Node.
class Node {     // tc O(V+E)
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class CloneGraph133 {
    private Node cloneUtil(Node node, HashMap<Node, Node> map) {
        // Create the newNode
        Node newNode = new Node(node.val);
        map.put(node, newNode);

        // Go through all nodes and their neighbors
        for (Node neighbor : node.neighbors) {
            if (!map.containsKey(neighbor)) { // not cloned so we have to create a node
                newNode.neighbors.add(cloneUtil(neighbor, map));
            } else {
                // then add cloned version of that node
                newNode.neighbors.add(map.get(neighbor));
            }
        }
        return newNode;
    }

    public Node cloneGraph(Node node) {
        // Base case
        if (node == null) {
            return null;
        }
        // Using map for tracking if the node is cloned already or not
        HashMap<Node, Node> map = new HashMap<>();
        return cloneUtil(node, map);
    }

    public static void main(String[] args) {
        // Create a test graph
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        // Clone the graph
        CloneGraph133 cg = new CloneGraph133();
        Node clonedGraph = cg.cloneGraph(node1);

        // Print the input and output graph
        System.out.println("Input: adjList = " + formatGraph(node1));
        System.out.println("Output: " + formatGraph(clonedGraph));
    }

    public static List<List<Integer>> formatGraph(Node node) {
        Map<Node, Integer> nodeToIndex = new HashMap<>();
        List<List<Integer>> adjList = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        queue.add(node);
        visited.add(node);

        int index = 0;
        nodeToIndex.put(node, index++);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            List<Integer> neighbors = new ArrayList<>();
            for (Node neighbor : current.neighbors) {
                if (!nodeToIndex.containsKey(neighbor)) {
                    nodeToIndex.put(neighbor, index++);
                }
                neighbors.add(nodeToIndex.get(neighbor));
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
            adjList.add(neighbors);
        }

        return adjList;
    }
}
