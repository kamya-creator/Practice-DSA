class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public void SubsetWithDup(int indx, int[] nums, ArrayList<Integer> ds)
    {
        if(indx == nums.length)
        {
            res.add(new ArrayList<>(ds));
            return;
        }
        ds.add(nums[indx]);
        SubsetWithDup(indx+1, nums, ds);
        
        
        ds.remove(ds.size() -1);
        SubsetWithDup(indx+1, nums, ds);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        SubsetWithDup(0, nums, new ArrayList<>());
        HashSet<List<Integer>> set = new HashSet<>();
        for(List<Integer> ele: res)
        {
            set.add(ele);
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> ele : set )
        {
            ans.add(ele);
        }
        return ans;
    }
}
/*
TC = 2^n + 2^n*log(2^n) + 2^n == Recursion time + adding in set time + adding from set to list time
*/
