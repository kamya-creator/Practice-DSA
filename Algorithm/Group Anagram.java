class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, ArrayList<String>>  fmap = new HashMap<>();
        
        for(String s : strs)
        {
            HashMap<Character, Integer> bmap = new HashMap<>();
            
            for(int i =0;i<s.length();i++)
            {   char ch = s.charAt(i);
                bmap.put(ch , bmap.getOrDefault(ch,0) +1);
            }
            
            if(fmap.containsKey(bmap))
            {
                ArrayList<String> list = fmap.get(bmap);
                list.add(s);
                fmap.put(bmap, list);
            }
            else
            {
                ArrayList<String> list = new ArrayList<>();
                list.add(s);
                fmap.put(bmap, list);
            }
        }
        //System.out.print(fmap);
        List<List<String>> res = new ArrayList<>();
        
        for(ArrayList<String> str : fmap.values())
        {
            
        //System.out.print(str);
            res.add(str);
        }
        return res;
    }
}
