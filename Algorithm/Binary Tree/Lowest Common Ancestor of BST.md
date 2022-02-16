Refer Prince Bhaiya tutorial
```
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    ArrayList<TreeNode> path1 = new ArrayList<>();
    ArrayList<TreeNode> path2 = new ArrayList<>();
    
    public boolean findPath(TreeNode root, TreeNode n, ArrayList<TreeNode> path)
    {
        if(root == null) return false;
        
        path.add(root);
        if(root == n) return true;
        if(findPath(root.left , n, path) || findPath(root.right, n, path))
            return true;
        
        path.remove(path.size()-1);
        return false;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null)
            return null;
        
        if( !findPath(root, p, path1 ) || !findPath(root, q, path2))
            return null;
        
        TreeNode ans = null;
        for(int i =0;i<path1.size() && i<path2.size() ;i++)
        {
            if(path1.get(i) == path2.get(i))
                ans = path1.get(i);
        }
        return ans;
    }
}
