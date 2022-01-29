https://leetcode.com/problems/split-array-largest-sum/discuss/1728216/Binary-Search-Intuition-or-Java

![1](https://user-images.githubusercontent.com/71540845/151655440-0c3ac488-212e-4579-a3c3-b498e838f077.jpg)
![2](https://user-images.githubusercontent.com/71540845/151655446-c2f018d8-3020-4f05-8089-4358c666e8ac.jpg)
![3](https://user-images.githubusercontent.com/71540845/151655448-79dd13c4-68b8-4d7c-a6e0-b4f64db9c2fd.jpg)
![4](https://user-images.githubusercontent.com/71540845/151655454-c0f9ce15-173e-4ed4-942e-e17b8b3bfa6d.jpg)
![5](https://user-images.githubusercontent.com/71540845/151655457-e90830f0-cfd1-4128-b40b-5e95ed3c2a3e.jpg)
![6](https://user-images.githubusercontent.com/71540845/151655461-c0a7677a-36fd-4890-92de-b1ed62008920.jpg)
![7](https://user-images.githubusercontent.com/71540845/151655463-ab9bbab3-0a68-4386-997c-bcdc15ff8533.jpg)

```
class Solution {
    public int splitArray(int[] nums, int m) {
        
        int start = 0;
        int end =0;
        for(int i =0;i<nums.length;i++)
        {
            start = Math.max(start, nums[i]);
            end = end + nums[i];
        }
        
        int ans = BinarySearch(start, end, nums,m);
        return ans;
        
    }
    public int BinarySearch(int start, int end , int[] num,int m)
    {
        while(start < end)
        {
            int mid = start + (end - start)/2;
            
            int pieces =1;
            
            int sum =0;
            for(int i : num)
            {
                if(sum + i > mid)
                {
                    sum =i;
                    pieces++;
                }
                else{
                    sum = sum +i;
                }
            }
            if(pieces <= m)
            {
                end = mid;
            }
            else start = mid+1;
        }
        return start;
    }
}
