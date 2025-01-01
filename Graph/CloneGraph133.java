
/*
// Definition for a Node.
class Node {
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
*/

class CloneGraph133 {
    private Node cloneUtil(Node node,HashMap<Node,Node>map){
        // create the newNode 
        Node newNode = new Node(node.val);
        map.put(node,newNode);

        // go for all node and thier neighbors 
        for(Node neighbor : node.neighbors){
            if(!map.containsKey(neighbor)){ // not cloned so we have to create a node 
            
                newNode.neighbors.add(cloneUtil(neighbor,map));
              
            }else{
                // then add cloned version of that node 
                newNode.neighbors.add(map.get(neighbor));
            }
        }
        return newNode;
    }
    public Node cloneGraph(Node node) {
        // base case 
        if(node == null){
            return null;
        }
      // using map for tracking if the node is cloned allready or not 
      HashMap<Node,Node>map  = new HashMap<>();
      return cloneUtil(node,map);
    }
}