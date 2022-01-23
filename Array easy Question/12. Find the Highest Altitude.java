class Solution {
    public int largestAltitude(int[] gain) {
        
        int max = 0;
        int currAlt =0;
        for(int ele: gain)
        {
            currAlt += ele;
            max = Math.max(currAlt, max);
        }
        return max;
    }
}
