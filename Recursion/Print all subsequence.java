//https://leetcode.com/problems/subsets/discuss/1821914/java-solution
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    public void printSubSequence(int index, int[] nums,ArrayList<Integer>  ds, int n)
    {
        if(index >= n)
        {   
            /*
            Don't forget to add ds into res 
            */
            res.add(new ArrayList<>(ds));
            return;
        }
        // take it / add current index element in arraylist
        ds.add(nums[index]);
        printSubSequence(index+1 , nums, ds, n);
        
        // remove it/ delete current index element from arraylist
        /*
        Thing I learnt here is ds.remove(nums[index]) will give arrayOutOfBound error, because arrayList.remove method is of two type one tke index and one take the Object, so in order to remove current index element form arrayList 
        we have to convert int to Object of int 
        or we can use ds.remove( ds.size() -1 )
        */
        ds.remove(new Integer(nums[index]));
        printSubSequence(index +1 , nums, ds, n);
        
        
        
    }
    public List<List<Integer>> subsets(int[] nums) {
        
        int n = nums.length;
        ArrayList<Integer> ds = new ArrayList<>();
        printSubSequence(0, nums, ds, n);
        return res;
    }
}
