https://leetcode.com/problems/rotting-oranges/discuss/1763535/JAVA-Solution

```
class Solution {
    public int orangesRotting(int[][] grid) {
        
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int total_oranges =0;
        for(int i =0;i<row;i++)
        {
            for(int j =0;j<col;j++)
            {
                if(grid[i][j] == 2)
                    queue.add(new int[]{i,j});
                if(grid[i][j] !=0)
                    total_oranges++;
            }
        }
        if(total_oranges == 0) return 0;
        //System.out.print(queue.peek()[0] + " "+ fresh_oranges);
        int count =0;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int rottening_orange =0;
        while(queue.size() != 0)
        {   int size = queue.size();
            rottening_orange+=size;
            while(size-- > 0 )
            {
            int[] rotten_orange = queue.remove();
            //System.out.println(rotten_orange[0] + " "+ rotten_orange[1]  );
            for(int i =0;i<4;i++)
            {
                int new_x = dx[i] + rotten_orange[0];
                int new_y = dy[i] + rotten_orange[1];
                
                if(isValid(new_x, new_y ,row, col, grid))
                {   //System.out.println(new_x +"New X and Y "+ new_y); 
                    grid[new_x][new_y] =2;
                     queue.add(new int[]{new_x, new_y});
                } 
               }
            }
            if(queue.size() > 0)
                count++;
            //System.out.println(count + " I M COUNT");
        }
        
        //System.out.println(rottening_orange + " I M Rootening orange");
        if(rottening_orange == total_oranges)
            return count;
        else
            return -1;
        
    }
    
    public boolean isValid(int i , int j,int row, int col, int[][] grid)
    {
        if(i >= 0 && i< row && j>=0 && j< col && grid[i][j] != 0 && grid[i][j] == 1)     
        {//System.out.println(grid[i][j] + "***************");
            return true;}
        
        return false;
    }
}
