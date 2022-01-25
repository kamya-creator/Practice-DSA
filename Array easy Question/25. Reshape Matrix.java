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
}
