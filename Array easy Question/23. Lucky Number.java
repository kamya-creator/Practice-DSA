class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        
        /*
        Accoording to Lucky Number definition , 
        the number should be minimum in row and maximum in column
        so the proble is divided into two parts 
        i.e first find minimum in row and 
        check weather that number is maximum in column or not ,
        so let's start with finding minumum in row 
        */
        List<Integer> res = new ArrayList<>();
        
        for(int i =0;i<matrix.length;i++)
        {
            int minValue = Integer.MAX_VALUE;
            int minIdx =0;
            
            
        // Code to find minimum in row 
            for(int j =0;j<matrix[i].length;j++)
            {
                if(matrix[i][j] < minValue)
                {
                    
            /*
            Store the column index of minimum number in row
            */
                    minValue = matrix[i][j];
                    minIdx = j;  
                }
            }
            /* The minIdx represents the column number of 
            minimum number of row ,so now treverse the columns 
            to check wheather it's maximum in column or not 
            */
            boolean ismaxInCol = true;
            
            for(int j =0 ;j< matrix.length;j++)
            {   
                if(matrix[i][minIdx] < matrix[j][minIdx])
                {   
                    /* If the number isn't maximim in column 
                    so it can't be lucky number so come out of 
                    loop and check in further rows */
                    ismaxInCol = false;
                    break;
                }
            }
            if(ismaxInCol) res.add(matrix[i][minIdx]);
            
            
        }
        return res;
    }
}
