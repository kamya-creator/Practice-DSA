class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int n = nums.length;
        int[] res = new int[n];  
        
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i =0;i<n;i++)
        {
            temp.add(index[i], nums[i]);
        }
        int idx =0;
        for(Integer ele : temp)
        {
            res[idx++] =ele;
        }
        return res;
    }
}
