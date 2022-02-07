/*
Used Brute Force Approach 
First traversing in matrix row-wise and storing the elements in set because set cannot hold duplicate elements , so it will be useful to use set 
As mentioned in question that elements of matrix will lie between 1 to n (n is size of matrix) so we can check after filling set that if set size is equal to size of row (or size of column as matrix is of n X n) 
If the set size and matrix row size are equal then searching column wise by traversing column wise 
*/

## This approach took long time in execution
This approach was followed in valid sudoko problem
```
class Solution {
    public boolean checkValid(int[][] matrix) {
        HashSet<String> seen = new HashSet<>();
        int n = matrix.length;
        for(int i =0;i<n;i++)
        {
            for(int j = 0 ;j<n;j++)
            {   
               int ch=matrix[i][j]; 
               if(!seen.add(ch + "found in row" + i)||
                 !seen.add(ch + "found in column" + j)) 
                   return false;
            }
        } return true;
  
  ```
  
  ## This approach took less time in execution than above one
  
  ```
        int n = matrix.length;
        // Traversing Row Wise
        for(int i =0;i<n;i++)
        {   HashSet<Integer> set = new HashSet<>();
            for(int j =0;j<n;j++)
            {
                set.add(matrix[i][j]);
            }
         //System.out.println(set.size() + "  "+ matrix[0].length);
         
         // After filling set if set size not equal to matrix row size then returnig false because it means row doesnot contain all n numbers
         if(set.size() != matrix[i].length)
             return false;
        }
        // Traversing Column Wise
        for(int j =0;j<n;j++)
        {
            HashSet<Integer> set = new HashSet<>();
            for(int i =0;i<n;i++)
            {
                set.add(matrix[i][j]);
            }
            
         // After filling set if set size not equal to matrix column size then returnig false because it means column doesnot contain all n numbers
             if(set.size() != matrix[j].length)
             return false;
        }
        
        // If all rows and column conatain n numbers ranging from 1 to n then return true (i.e Matrix is valid)
        return true;
        
    }
}
