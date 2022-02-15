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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        
        while(stack.size() != 0)
        {
            TreeNode curr = stack.pop();
            
            if(curr.left == null && curr.right == null && curr.val == targetSum)
                return true;
            
            if(curr.left != null)
            {
                curr.left.val = curr.val + curr.left.val;
                stack.add(curr.left);
            }
            if(curr.right != null)
            {
                curr.right.val = curr.val + curr.right.val;
                stack.add(curr.right);
            }
        } return false;
    }
}
