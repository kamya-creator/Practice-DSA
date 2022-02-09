https://leetcode.com/problems/max-area-of-island/discuss/1757969/Java-Solution-or-3ms

```
/*
Used same approach of question Number of Island with slight modification

Whenever a new island is found i.e grid[i][j] == 1 , then add it in the current area ans and then apply dfs for it's neighbour in 4 direction
Notice one thing , if neighbour is contributing in making island i.e grid[i][j] neighbours is 1 then increase the current area ans 
*/

class Solution {
    public  int maxAreaOfIsland(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        int maxArea = 0;
        for(int i =0;i<n;i++)
        {
            for(int j =0;j<m;j++)
            {   
                if(grid[i][j] == 1)
                {   
                    /*
                    As array get passed as refrence hence using ans array to calculate the current area ans
                    */
                    int[] ans = new int[1];
                    ans[0] =1;
                    DFSRecursive(i,j, n,m , grid, ans);
                    maxArea = Math.max(maxArea, ans[0]);
                }
            }
        } return maxArea;
    }
    
    public  void DFSRecursive(int i,int j, int n,int m ,int[][] grid, int[] ans)
    {
        
        grid[i][j] = 0;
        if(isValid(i-1, j, n , m,grid ))
        { // Top neighbour is contributing in making island , hence increase the current area ans
            ans[0]++;
            DFSRecursive(i-1, j, n, m, grid,ans);
        }
        
        if(isValid(i, j-1, n, m ,grid))
        {// Left neighbour is contributing in making island , hence increase the current area ans
            ans[0]++;
            DFSRecursive(i, j-1, n, m, grid,ans);
        }
        
        if(isValid(i+1, j, n, m ,grid))
        {
            // Bottom neighbour is contributing in making island , hence increase the current area ans
            ans[0]++;
            DFSRecursive(i+1, j, n, m, grid,ans);
        }        
        
        if(isValid(i, j+1, n, m ,grid))
        {
            // Right neighbour is contributing in making island , hence increase the current area ans
            ans[0]++;
            DFSRecursive(i, j+1, n, m, grid,ans);}
       
    }
    
    public boolean isValid(int i, int j , int n , int m , int[][] grid)  
    {
        
        if(i >= 0 && i< n && j >= 0 && j<m && grid[i][j] == 1)
            return true;
        
        return false;
    }
}
