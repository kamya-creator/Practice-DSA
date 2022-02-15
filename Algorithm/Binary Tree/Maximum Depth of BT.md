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
    int maxDepth = Integer.MIN_VALUE;
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int left_height = 0;
        int right_height = 0;
        if(root.left != null)
            left_height =  maxDepthRecur(root.left);
        
        if(root.right != null)
             right_height = maxDepthRecur(root.right);
        
        return Math.max(left_height , right_height) +1;
    }
    
    public int maxDepthRecur(TreeNode root)
    {
        if(root == null)
            return 0;
        int r =  maxDepthRecur(root.right);
        int l =  maxDepthRecur(root.left);
        
        return Math.max(l,r) +1;
        
    }
}
