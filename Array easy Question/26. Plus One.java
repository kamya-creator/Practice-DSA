/*
Runtime: 2 ms, faster than 6.06% of Java online submissions for Plus One.
Memory Usage: 39.4 MB, less than 13.52% of Java online submissions for Plus One.
Next challenges:
*/

class Solution {
    public int[] plusOne(int[] digits) {
        
        /*
        Not the efficient Solution but tried to relate ths problem with already solved proble i.e Add to Array-Form of Integer ::)))))😀😀
        So It's Improvement 😌
        */
        int k =1;
        int n = digits.length;
        
        LinkedList<Integer> temp = new LinkedList<>();
        for(int i = n-1;i>=0;i--)
        {
            k = k+ digits[i];
            
            temp.addFirst(k%10);
            k = k/10;
        }
        
        while(k>0)
        {
            temp.addFirst(k%10);
            k = k/10;
        }
        
        int[] res = new int[temp.size()];
        int idx =0;
        for(Integer i : temp)
        {
         res[idx++] =i;   
        }
        return res;
    }
}
