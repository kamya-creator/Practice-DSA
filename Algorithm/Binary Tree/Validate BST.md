https://leetcode.com/problems/validate-binary-search-tree/discuss/1774995/Used-Fact-that-Inorder-traversal-of-BST-is-Always-Increasing-Order
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
/*
Inorder traversal of BST is always increasing order
Used this property of inorder traversal of BST and solved the problem
*/

class Solution {
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        inorder(root, res);
        //System.out.print(res);
        for(int i =0;i<res.size()-1;i++)
        {   
            for(int j = i+1;j<res.size();j++)
            {  if(res.get(i) >= res.get(j))
                 return false;
             }
        }
        return true;
    }
    public void inorder(TreeNode root, ArrayList<Integer> res)
    {
        if(root == null) return;
        
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
