class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public void CombinationSum(int indx, int[] arr, int target, ArrayList<Integer> ds )
    {
        if(indx == arr.length)
        {
            if(target == 0)
            {
                res.add(new ArrayList<>(ds));
                return;
            }
            return;
        }
        
        if(arr[indx] <= target)
        {
            ds.add(arr[indx]);
            CombinationSum(indx,arr, target - arr[indx], ds);
            ds.remove(new Integer(arr[indx]));
        }
        CombinationSum(indx+1,arr, target, ds);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<Integer> ds = new ArrayList<>();
        CombinationSum(0, candidates, target, ds );
        return res;
    }
}
