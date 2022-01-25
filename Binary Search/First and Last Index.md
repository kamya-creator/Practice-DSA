/*
Runtime: 1 ms, faster than 24.78% of Java online submissions for Find First and Last Position of Element in Sorted Array.
Memory Usage: 44.3 MB, less than 9.12% of Java online submissions for Find First and Last Position of Element in Sorted Array.
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstOccurence = FirtstPosition(nums,target);
        int lastOccurence = LastPosition(nums,target);
        int[]  res = new int[2];
        res[0] = firstOccurence;
        res[1] = lastOccurence;
        
        return res;
    }
    
    public int FirtstPosition(int[] nums,int target)
    {
        int start =0;
        int firstOccurence = -1;
        int end = nums.length -1;
        
        while(start <= end)
        {
            int mid = start + (end - start)/2;
            
            if(nums[mid] == target)
            {
                firstOccurence=mid;
                end = mid-1;
            }
            else if(nums[mid] > target)
            {
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return firstOccurence;
    }
    
    public int LastPosition(int[] nums,int target)
    {
        int start =0;
        int lastOccurence = -1;
        int end = nums.length -1;
        
        while(start <= end)
        {
            int mid = start + (end - start)/2;
            
            if(nums[mid] == target)
            {
                lastOccurence=mid;
                start = mid+1;
            }
            else if(nums[mid] > target)
            {
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return lastOccurence;
    }
}



### Runtime: 0 ms, faster than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
### Memory Usage: 44 MB, less than 39.44% of Java online submissions for Find First and Last Position of Element in Sorted Array.
  
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        
        int firstIndx = BinarySearch(nums, target, true);
        int lastIndx = BinarySearch(nums, target, false);
        
        ans[0] = firstIndx;
        ans[1] = lastIndx;
        
        return ans;
    }
    public int BinarySearch(int[] nums, int target, boolean search4FirstOccurance)
    {
        int start = 0;
        int end = nums.length -1;
        int ans =-1; // Desired index will be stored in it
        
        while(start <= end)
        {
            int mid = start + (end-start)/2;
            
            if(nums[mid] == target )
            {   
                ans = mid;
                if(search4FirstOccurance)
                    end = mid -1;
                else
                    start = mid+1;
                    
            }
            else if(nums[mid] > target)
            {
                end = mid-1;
            }
            else{
                start = mid +1;
            }
        }
        return ans;
    }
}



# Solution With Explanation

class Solution {
public int[][] matrixReshape(int[][] mat, int r, int c) {

    // Dimensions of original matrix
    int row = mat.length;
    int col = mat[0].length; 
    /*
    Reshape is only posible when number of elements befor and after           resahpe is same .
    Number of elements = Row of matrix * Column of matrix
    
    In problen Description it's mentioned that 
    If the reshape operation with given parameters is possible and           legal, output the new reshaped matrix; Otherwise, output the              original matrix.
    */
    if(row*col != r*c) return mat;
    int[][] new_mat = new int[r][c];
    
    /* Acc. to question 
    The reshaped matrix should be filled with 
    all the elements of the original matrix in the same row-                traversing order as they were.
    
    So we have to follow normal traversal of original matrix 
    and fill the new matrix with some condition
    */
    int new_mat_row =0; // using these variables to fill new matrix
    int new_mat_col =0;
    /*
    Condition 1 . While filling the rows increment the column index because while travesing row ,row index remain same and column index gets change
    
    Condition 2. When new_mat_col hit the reshape matrix column size it means that row has be filled completly now move to further row ,and set new_mat_col to zero again
    */
    
        for(int i =0;i<row;i++)
        {
            for(int j =0;j<col;j++)
            {
                new_mat[new_mat_row][new_mat_col] = mat[i][j];
                new_mat_col++; // Condition 1

                if(new_mat_col == c)
                {  new_mat_row++;
                   new_mat_col =0; // Condition 2
                }

            }
        }
       
    return new_mat;
    
    
}
