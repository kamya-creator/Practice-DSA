
https://leetcode.com/problems/first-unique-character-in-a-string/discuss/1754460/Java-Solution
#### Using HashMap to store the frequency of each character and indexOf function of String class to get the index of character

```



class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character , Integer> map = new HashMap<>();
        if(s.length() == 1)
            return 0;
        for(int i =0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
                        
        }
        // for(Map.Entry m : map.entrySet())
        // {
        //     System.out.println(m.getKey() + " "+ m.getValue());
        // }
        int minIndex = s.length();
        for(Map.Entry m : map.entrySet())
        {
            //System.out.println(m.getKey() + " "+ m.getValue());
            int index = (int)m.getValue();
            char c = (char)m.getKey() ;
            int indx = s.indexOf(c);
            //System.out.println(c+ " "+indx + " "+ minIndex + " "+ index);
            if(index == 1  && indx <= minIndex )
                minIndex = indx;
                
        }
        return minIndex== s.length() ? -1 :minIndex ;
        
    }
}
