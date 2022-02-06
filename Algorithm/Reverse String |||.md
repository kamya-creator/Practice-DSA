https://leetcode.com/problems/reverse-words-in-a-string-iii/discuss/1749513/5ms-or-81-faster-or-Java-Solution

```
class Solution {
    public String reverseWords(String s) {
        
        char[] arr = s.toCharArray();
        int n = arr.length;
        int j =0;
        int i =0;
        
        
        while(i<n )
        { 
            
            // Finding the first space (ASCII CODE FOR SPACE IS 32)
            while(j<n && (int) arr[j] != 32)
                j++;
            
            //Reversing the word before space 
            swap(arr, i, j-1);
            
            // Reinitialising i to next letter where j left +1
            i=j+1;
            // Positioning j to find further words in string 
            j= i;
        }
        return String.valueOf(arr);
    }
    
    public void swap(char[] arr, int i , int j)
    {
        
        
            //System.out.print(j);
        while(i<j && j<arr.length)
        {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
