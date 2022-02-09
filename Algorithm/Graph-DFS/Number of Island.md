https://leetcode.com/problems/number-of-islands/discuss/1757883/Java-Solution-with-comments

```
/*
Applying DFS  
*/

class Solution {
    public int numIslands(char[][] grid) {
        
        int n = grid.length;  // no. of rows
        int m = grid[0].length; // no. of columns
        
        int ans =0;   // count of number of island
        
        // traversing grid to find island
        for(int i =0;i<n;i++)
        {
            for(int j =0;j<m;j++)
            {   
                
                // when 1 is found then increase count of number of island and merge it's all possible neighbour in it with the help of DFS 
                if(grid[i][j] == '1')
                {   ans++;
                    DFSRecursive(i,j, n, m , grid);
                }
            }
        }
        return ans;
    }
    
    public void DFSRecursive(int i, int j , int n , int m , char[][] grid)
    {   
        // marking element as water so it cannot be added in ans again
        grid[i][j] = '0';
        
        
        if(isValid(i+1, j , n, m, grid)) // Down
            DFSRecursive(i+1, j , n, m , grid);
        
        if(isValid(i-1 , j , n, m , grid)) // Top
            DFSRecursive(i-1, j , n, m , grid);
            
        if(isValid(i, j-1 , n, m , grid)) // Left
            DFSRecursive(i, j-1, n, m , grid);
            
         if(isValid(i, j+1, n, m , grid))  // Right
             DFSRecursive(i, j+1, n, m , grid);
    }
    
    public boolean isValid(int i, int j , int n , int m , char[][] grid)
        
    {
        
        if(i >= 0 && i< n && j >= 0 && j<m && grid[i][j] == '1')
            return true;
        
        return false;
    }
}
