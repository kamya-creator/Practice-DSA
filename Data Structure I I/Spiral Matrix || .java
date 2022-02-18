class Solution {
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int top = 0;
        int bottom = n-1;
        int left = 0;
        int right = n-1;
        int cnt = 1;
        while(left <= right && top <= bottom )
        {
            for(int i =left;i<= right;i++)
            {
                arr[top][i] = cnt++;
            } 
            top++;
          
            for(int i = top ; i<= bottom ;i++)
            {
                arr[i][right] = cnt++;
            }
            right--;
            
            for(int i = right ; i>=left ;i--)
            {
                arr[bottom][i] = cnt++;
            }
            bottom--;
            
            for(int i = bottom ;i>= top ;i--)
            {
                arr[i][left] = cnt++;
            }
            left++;
            
        } return arr;
    }
}
