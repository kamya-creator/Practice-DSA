```
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        TreeNode current_node = root;
         
       // Finding the correct position of val in given BST
        while(true)
        {   
            // If val is greater than current node of BST then it means val correct position will lie in left part of tree
            if(current_node.val < val)
            {   
                if(current_node.right != null)
                current_node = current_node.right;
                else
                {  
                    // Notice we are inserting new node i.e val at the leaf position only, hence when correct position is found then insert val as current node child and break the loop
                    current_node.right = new TreeNode(val);
                    break;
                }
                
            }
            
            // If val is smaller than current node of BST then it means val correct position will lie in right part of tree
            else
            {
                if(current_node.left != null){
                    current_node = current_node.left;
                }
                else
                {
                    //Notice we are inserting new node i.e val at the leaf position only, hence when correct position is found then insert val as current node child and break the loop
                    current_node.left = new TreeNode(val);
                    break;
                }
            }
        } return root;
    }
}
