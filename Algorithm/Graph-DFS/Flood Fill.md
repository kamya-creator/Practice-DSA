https://leetcode.com/problems/flood-fill/discuss/1758175/1ms-Java-Solution-DFS
```
/*
Using DFS without visisted array
*/

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int n = image.length;
        int m = image[0].length;
        int src_element = image[sr][sc];
        
        
        // If newColor is equal to previous color of element at [sr,sc] then there is no need of applying DFS as matrix will remain same  
        if(src_element == newColor)
            return image;
        
        DFSRecursive(image, sr, sc, n, m , src_element, newColor );
        return image;
        
        
    }
    public void DFSRecursive(int[][] image,int i, int j , int n, int m , int src_element , int newColor)
    {   // Replacing old color with newColor
        image[i][j] = newColor;
        if(isValid(image,i+1, j, n, m , src_element, newColor))
            DFSRecursive(image,i+1, j, n, m , src_element, newColor);
     
        if(isValid(image,i-1, j, n, m , src_element, newColor))
            DFSRecursive(image,i-1, j, n, m , src_element, newColor);
     
        if(isValid(image,i, j+1, n, m , src_element, newColor))
            DFSRecursive(image,i, j+1, n, m , src_element, newColor);
     
        if(isValid(image,i, j-1, n, m , src_element, newColor))
            DFSRecursive(image,i, j-1, n, m , src_element, newColor);
    }
    
    public boolean isValid(int[][] image,int i , int j , int n, int m, int src_element , int newColor)
    {
        if( i>=0 && i<n && j>= 0 && j<m   &&  image[i][j] == src_element)
            return true;
        
        return false;
    }
}
