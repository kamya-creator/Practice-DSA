
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int top = 0;
        int bottom = row -1;
        int left =0;
        int right = col -1;
        int total_element = row*col;
        // this count variable is keeping the track of not printing the same wall (element) again
        int count =0;
        List<Integer> res = new ArrayList<>();
        while(top<= bottom && left <= right)
        {
            for(int i = left ;i<= right && count < total_element ;i++)
            {   res.add(matrix[top][i]);
                count++;
            } top++;

            
            for(int i = top ;i<= bottom && count < total_element;i++)
            {
                res.add(matrix[i][right]);
                count++;
                
            }right--;
            
            for(int i = right; i>=left && count < total_element;i--)
            {
                res.add(matrix[bottom][i]);
                count++;
            }
            bottom--;
            
            for(int i = bottom ;i>= top && count < total_element;i-- )
            {
                res.add(matrix[i][left]);
                count++;
            }
            left++;
            
        } return res;
    }
}
