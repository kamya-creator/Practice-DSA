https://leetcode.com/problems/ransom-note/discuss/1754552/Java-Solution-with-HashMap
```
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        // Frequency map for ransomNote
        
        HashMap<Character, Integer> map1 = new HashMap<>();
        for(int i =0;i<ransomNote.length();i++)
        {   char ch = ransomNote.charAt(i); 
            map1.put(ch, map1.getOrDefault(ch,0) +1);
        }
        
        // Frequency map for magazine
        
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(int i =0;i<magazine.length();i++)
        {   char ch = magazine.charAt(i); 
            map2.put(ch, map2.getOrDefault(ch,0) +1);
        } 
        
        // Traversing ransomNote to find it's character frequencies in Frequency map of magazine
        for(int i =0;i<ransomNote.length();i++)
        {
            char ch = ransomNote.charAt(i);
            int freq_map1 = map1.get(ch);
            int freq_map2 =0;
            if(map2.containsKey(ch))
                 freq_map2 = map2.get(ch);
            
            
            //System.out.println(ch + " "+freq_map1 +" "+ freq_map2 );
            // Inoder to ransomNote be substring of magazine ,the frequecy count of each character of 
            //ransomNote  in magazine should be either greater than or equal to the frequecy count of each character of ransomNote otherwise   
            //ransomNote is not substring of magazine
            
            if(freq_map1 > freq_map2)
                return false;            
        }
        return true;
    }
}
