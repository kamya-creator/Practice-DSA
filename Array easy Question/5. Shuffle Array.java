class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2*n];
        
        int l =0;
        int r = n;
        int idx=0;
        while(l<n && r<2*n)
        {
            res[idx++] = nums[l];
            res[idx++] = nums[r];
            
            l++;
            r++;
        }
        return res;
    }
}
