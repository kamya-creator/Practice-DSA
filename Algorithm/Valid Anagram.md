https://leetcode.com/problems/valid-anagram/discuss/1754658/Java-Solution-Using-HashMap

```
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) 
            return false;
        
        if(s.length() == t.length())
        {
            HashMap<Character, Integer> map1 = new HashMap<>();
            for(int i =0;i<s.length();i++)
            {
                char ch = s.charAt(i);
                map1.put(ch, map1.getOrDefault(ch,0) +1);
            }
            HashMap<Character, Integer> map2 = new HashMap<>();
            for(int i =0;i<t.length();i++)
            {
                char ch = t.charAt(i);
                map2.put(ch, map2.getOrDefault(ch,0) +1);
            }
            
            
            for(Map.Entry m : map1.entrySet())
            {
                int fre = (int)m.getValue();
                char ch = (char)m.getKey();
                
                
                if(!map2.containsKey(ch))
                    return false;
                if(map2.containsKey(ch))
                {
                    if(map2.get(ch) != fre)
                    {
                        return false;
                    }
                }
            }
            
        }   return true; 
        
    }
}
