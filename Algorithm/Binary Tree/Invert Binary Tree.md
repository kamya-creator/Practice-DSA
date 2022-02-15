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
    public TreeNode invertTree(TreeNode root) {
        
        if(root == null)
            return root;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(stack.size() != 0)
        {
            TreeNode node = stack.pop();
            
            if(node != null)
            {  
                stack.push(node.left);
                stack.push(node.right);
                // swap left subtree with right
                swap(node.left, node.right, node);
                // Inoder traversal is used for checking intermediate results and debugging
               // inorderTraversal(root);
            }
            
        }
        return root;
    }
    public void swap(TreeNode left, TreeNode right, TreeNode root)
    {
        TreeNode temp = left;
        root.left = right;
        root.right = temp;

    }
    public void inorderTraversal(TreeNode root)
    {
        if(root == null) return;
        inorderTraversal(root.left);
        System.out.print(root.val+ " ");
        inorderTraversal(root.right);
        
    }
}
