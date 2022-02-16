Inoder Traversal of BST always give sorrted array in increasing order
1. Perform inoder traversal and store the result in arrayList
2. Create array and fill it with the values of arrayList
3. Perform Two Sum of array solution approach

https://leetcode.com/problems/two-sum-iv-input-is-a-bst/discuss/1775034/Used-Inorder-Traversal-Property-of-BST
```

This problem also can be solved with the use of ArrayList  

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
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        inorder(root,res);
        int[] arr = new int[res.size()];
        
        for(int i =0;i< arr.length;i++)
        {
            arr[i] = res.get(i) == null ? 0 : res.get(i)  ;
        }
        
        int i =0, j = arr.length -1;
        while(i<j)
        {
            if((arr[i] + arr[j] ) == k)
                return true;
            if((arr[i] + arr[j] ) > k) 
                j--;
            if((arr[i] + arr[j]) < k)
                i++;
                
        }
        return false;
    }
    public void inorder(TreeNode root,ArrayList<Integer> res){
        if(root == null)
            return ;
        
        inorder(root.left , res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
