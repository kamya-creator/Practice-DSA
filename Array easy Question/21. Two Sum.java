class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i =0;i<nums.length;i++)
        {
            if(map.conatinsKey(target - nums[i]))
            {   res[0] = i;
                res[1] = map.get(target - nums[i])
            }
            else
                map.put(nums[i], i);
        }
        return res;
    }
}
