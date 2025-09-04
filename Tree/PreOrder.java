import java.util.*;
public class PreOrder {
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer>list = new ArrayList<>();

        preOrder1(root, list);
        return list; 
    }

    public void preOrder1(TreeNode root, List<Integer>list ){
        if(root == null){
            return; 
        }

        list.add(root.val);
        preOrder1(root.left,list);
        preOrder1(root.right, list);
    }
}