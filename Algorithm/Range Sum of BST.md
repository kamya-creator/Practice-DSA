https://leetcode.com/problems/range-sum-of-bst/discuss/1759946/explained-approach-java-solution-recursive
```
Property of BST
a. In left subtree of BST all node will have have less than root node.
b. In right subtree of BST all node will have have greater than root node.

We can use these properties to find rangeSum.

1. if current root val lie between given range then add it's value to ans

2. if current root val is greater than given low, then it means that , it's left subtree would contain nodes which val is greater than or equal to given low

3. if current root val is smaller than given high , then it means that, it's right subtree would contain nodes which val is smaller than or equal to given hight

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
    int sum = 0;  // global variable
    public int rangeSumBST(TreeNode root, int low, int high) {
        
        rangeSumBSTRecursive(root, low, high);
        return sum;
    }
    
    public void rangeSumBSTRecursive(TreeNode root, int l , int h)
    {
        if(root != null)
        {   // following point 1 as mentioned above
            if(root.val >= l && root.val <= h)
                sum = sum + root.val;
            
            // following point 2 as mentioned above
            if(root.val > l)
                rangeSumBSTRecursive(root.left, l, h);
            
            // following point 3 as mentioned above
            if(root.val < h)
                rangeSumBSTRecursive(root.right, l , h);
        }
    }
}
