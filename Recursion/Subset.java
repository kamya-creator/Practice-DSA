class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public void subset(int indx , int[] nums, ArrayList<Integer> ds)
    {
        if(indx==nums.length)
        {
            res.add(new ArrayList<>(ds));
            return;
        }
        
        ds.add(nums[indx]);
        subset(indx+1, nums, ds);
        
        ds.remove(ds.size() -1);
        subset(indx+1, nums, ds);
    }
    public List<List<Integer>> subsets(int[] nums) {
        subset(0, nums, new ArrayList<>());
        return res;
    }
}
