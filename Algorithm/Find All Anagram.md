
```
/*
Let's call string s as source string and p string as pattern String.
As mentioned in question  return an array of all the start indices of ptterns's anagrams in source , 
so we can notice that if pattern string length is greater than source string then pattern can't be found in source , Hence it will be our base condition 
Now comes to case when pattern length is smaller or equal to source string length.
In order to find wether pattern string anagrams exists in source string or not
we have to traverse every possible substring of length = pattern.length,
So we can use SLIDING WINDOW technique to check every possible substring

First what we do is , create the frequency map of pattern string (it's going to our target map with which we 
are going to comapre other substring frequency map of source string )


example  s = "cbaebabacd", p = "abc"
sw = sliding window
______________________________
|c| b| a |e |b |a |b |a |c |d |
-------------------------------
---sw----
______________________________
|c| b| a |e |b |a |b |a |c |d |
-------------------------------
    ---sw----
______________________________
|c| b| a |e |b |a |b |a |c |d |
-------------------------------
        ---sw----
______________________________
|c| b| a |e |b |a |b |a |c |d |
-------------------------------
          ---sw----
______________________________
|c| b| a |e |b |a |b |a |c |d |
-------------------------------
              ---sw----
______________________________
|c| b| a |e |b |a |b |a |c |d |
-------------------------------
                ---sw----
______________________________
|c| b| a |e |b |a |b |a |c |d |
-------------------------------
                   ---sw----
             
After creating frequency map of pattern , we'll create frequency map of source upto pattern length 
(because with this we are fixing our window size to pattern length )
    
Next keep sliding window till it doesnot exceed  source string length and update it's frequency map respectively    
             

```
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        // Base Condition
         if(p.length() > s.length())
             return new ArrayList<>();
        
        // pattern frequency map
        HashMap<Character, Integer> pmap = new HashMap<>();
        // source frequency map
        HashMap<Character, Integer> smap = new HashMap<>();
        
        // Creating pattern string frequency map
        for(int i =0;i<p.length();i++)
        {   
            char ch = p.charAt(i);
            pmap.put(ch, pmap.getOrDefault(ch,0) +1);
            
        }
        
        // Creating source string frequency map upto pattern length as it'll fix window size
        for(int i =0;i<p.length();i++)
        {   
            char ch = s.charAt(i);
            smap.put(ch, smap.getOrDefault(ch,0) +1);
        }
        
        // start is pointing to very next after window
        int start = p.length();
        
        
        ArrayList<Integer> res = new ArrayList<>();
        
        
        while(start < s.length())
        {   
            
            // comparing frequency map of target pattern and sliding window 
            if(compare(smap, pmap) == true)
            {   // notice if frequency map of pattern and sliding window get match , add the index of very first character of sliding window
                // start -p.length() gives the required index 
                res.add(start-p.length());
            }
            
            
            // adding element pointed by start in frequency map
            char arival_char = s.charAt(start);
            smap.put(arival_char, smap.getOrDefault(arival_char,0)+1);
            
            // when sliding window moves we need to remove left most character from sliding window
            char removal_char = s.charAt(start -p.length());
            
            if(smap.get(removal_char) == 1)
                smap.remove(removal_char);
            else
                smap.put(removal_char, smap.get(removal_char) -1);
            
            
            // Don't froget to increase start as , it is handling to add new charcter in sliding window and moving it 
            start++;    
        }
        
        // at the end last sliding window charcters would be left checked , hence checking them also
        if(compare(smap, pmap) == true)
                res.add(start-p.length());
            
        
        return res;
    }
    
    public boolean compare(HashMap<Character, Integer> smap,HashMap<Character, Integer> pmap)
    {
        

        for(Character c : smap.keySet())
        {   
            if(pmap.containsKey(c))
            {   if((int)pmap.get(c) != (int)smap.get(c))
                   return false;
                
            }
            else
                 return false;
        }
        return true;
    }
}
