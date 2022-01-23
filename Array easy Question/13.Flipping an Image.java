class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        
        for(int[] arr : image)
        {   int n = arr.length;
            flipHorizontal(arr,n);
            Invert(arr,n);
        }
        return image;
    }
    public void flipHorizontal(int[] arr, int n)
    {
        int s =0;
        int e = n-1;
        
        while(s<e)
        {
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            
            s++;
            e--;
        }
    }
    
    public void Invert(int[] arr, int n)
    {
        for(int i =0;i<n;i++)
        {
            if(arr[i] == 0)
                arr[i] =1;
            else
                arr[i] =0;
        }
    }
}
