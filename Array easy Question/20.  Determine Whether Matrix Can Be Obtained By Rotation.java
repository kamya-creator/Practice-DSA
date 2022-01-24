class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        
        
        // Any object after four 90° Clockwise rotation comes 
        //to it's original position ... so we need to 
        //check for only 4 times matrix rotation 
        for(int i =0;i<4;i++)
        {
            if(checkmatrix(mat, target))
                return true;
            
            rotateMatrix(mat); 
        }
        return false;
    }
    public boolean checkmatrix(int[][] mat, int[][] target)
    {
        for(int i =0;i<mat.length;i++)
        {
            for(int j =0;j<mat[0].length; j++)
            {
                if(mat[i][j]  != target[i][j])
                        return false;
            }
        }
        return true;
    }
    
    public void rotateMatrix(int[][] mat)
        
    {
        // Rotation of matrix = Transpose matrix + Flip or Reverse matrix
        
        // Transpose
        for(int i =0;i<mat.length;i++)
        {
            for(int j =i; j<mat[0].length;j++)
            {   
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] =temp;
            }
        }
        
        // Reverse Matrix or Flip matrix
        
        int s, e;
        
        for(int i =0;i<mat.length;i++)
        {
            s=0;
            e=mat.length-1;
            
            while(s<e)
            {
                int temp = mat[i][s];
                mat[i][s]= mat[i][e];
                mat[i][e] = temp;
                
                s++;
                e--;
            }
        }
    }
    }
