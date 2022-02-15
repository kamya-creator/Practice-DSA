```
/*
Property of BST
a. In left subtree of BST all node will have have less than root node.
b. In right subtree of BST all node will have have greater than root node.

We can use these properties to find rangeSum.

1. if current root val is equal to given val then store the current root in ans and return

2. if current root val is greater than given val, then it means that , it's right subtree would contain nodes which value is greater than  given val, Hence search in left subtree 

3. if current root val is smaller than given val, then it means that , it's left subtree would contain nodes which value is smaller than  given val, Hence search in right subtree 
*/

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
    TreeNode ans ; // Global Ans 
    public TreeNode searchBST(TreeNode root, int val) {
        ans = null;  // Initialize global variable 
        searchBSTRecur(root, val);
        return ans;
    }
    
    public TreeNode searchBSTRecur(TreeNode root, int val)
    {
        if(root != null)
        {   // following condition 1
            if(root.val == val)
                ans = root;
            
            // following condition 2
            if(root.val > val)
                searchBSTRecur(root.left,val);

            // following condition 3
            if(root.val < val)
                searchBSTRecur(root.right,val);
            
        } 
        return null;
        
    }
}
