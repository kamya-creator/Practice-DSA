https://leetcode.com/problems/search-a-2d-matrix/discuss/1728990/Java-or-Code-with-Explanation


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ans = BinarySearch(matrix, target);
        //System.out.print(ans);
        if(ans != -1)
            return true;
        return false;    
    }
    public int BinarySearch(int[][] num , int key)
    {
        int row =0;
        int col = num[0].length-1;
        
        while(row < num.length && col >=0)
        {
            if(num[row][col] == key)
                return 1;
            else if(num[row][col] < key)
            {
                row++;
            }else{
                col--;
            }
        }
        return -1;
    }
}
