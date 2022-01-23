class Solution {
    public boolean checkIfPangram(String sentence) {
        
        char[] arr = sentence.toCharArray();
        int[] freq = new int[26];
        
        
        for(int i =0;i<arr.length;i++)
        {
            freq[arr[i]  - 'a']++;
        }
        for(int ele : freq)
        {
            if(ele == 0)
                return false;
        }
        return true;
    }
}
