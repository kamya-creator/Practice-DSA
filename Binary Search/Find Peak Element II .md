
https://leetcode.com/problems/find-a-peak-element-ii/discuss/1744470/Runtime%3A-0-ms-faster-than-100.00-of-Java-online-submissions

```
class Solution {
    public int[] findPeakGrid(int[][] mat) {
        
        // two pointers for binary Search
        int startRow = 0;
        int endRow = mat.length -1;
        
        while(startRow <= endRow)
        {
            int midRow = startRow  + (endRow - startRow)/2;
            
            // Finding the coloumn number which has max element in midRow
            int maxElementInmidRow = findMaxElementPosition(mat[midRow] , mat[midRow].length);
            
            // Note when we will find the max element in row then we don't have to comapre it with left and right neighbour , we need to comapre it with ust two neighbour i.e top and bottom
            
            
            
            // if midRow is 0 then it means , this row will not have top neighbors, so just compare it with bottom element 
            if(midRow == 0)
            {
                if(mat[midRow][maxElementInmidRow] > mat[midRow +1][maxElementInmidRow])
                {
                    return new int[]{midRow,maxElementInmidRow};
                }
            }
            
            // if midRow is last row then it means , this row will not have bottom neighbors, so just compare it with top element 
            
            if(midRow == mat.length-1)
            {
                if(mat[midRow][maxElementInmidRow] > mat[midRow -1][maxElementInmidRow])
                {
                    return new int[]{midRow,maxElementInmidRow};
                }
            }
            // if midRow lie in between then , it will have both top and botton neighbour , so compare it with both neighbour 
            else if(midRow >0  && midRow < mat.length )
            {
                if(mat[midRow][maxElementInmidRow] > mat[midRow +1][maxElementInmidRow] && mat[midRow][maxElementInmidRow] > mat[midRow -1][maxElementInmidRow] )
                    return new int[]{midRow,maxElementInmidRow};
                
            }
            
            // if bottom neighbour element is greater than current midRow element then move startRow pointer to midRow +1 , because we can find peak element in that space as  peak element must be greater than it's neighbour 
            if(mat[midRow][maxElementInmidRow] < mat[midRow+1][maxElementInmidRow])
            {
                startRow = midRow+1;
            }
            else
                
                
            // if top neighbour element is greater than current midRow element then move endRow pointer to midRow -1 , because we can find peak element in that space as  peak element must be greater than it's neighbour 
                endRow = midRow -1;
        }
        return new int[]{-1,-1};
    }
    
    // Finding the maximum element position in 1-D array
    public int findMaxElementPosition(int[] arr, int n)
        
    {
        int max = Integer.MIN_VALUE;
        int indx =0;
        for(int i = 0;i<n;i++)
        {
            if(arr[i] > max)
            {
                max = arr[i];
                indx =i;
            }
        }
        return indx;
    }
}
