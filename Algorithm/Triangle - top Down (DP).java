// https://www.youtube.com/watch?v=O2eaAdBpZBQ
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int sum =0;
        int n = triangle.size();
        for(int i = 1;i<n;i++)
        {   sum = 0;
            List<Integer> s = triangle.get(i);
         int len = s.size();
            for(int j = 0; j< len; j++)
            {
                if(j == 0)
                {
                    sum = triangle.get(i).get(j) + triangle.get(i-1).get(j);
                }
                else if(j == triangle.get(i).size() -1)
                {
                    sum = triangle.get(i).get(j)  + triangle.get(i-1).get(triangle.get(i-1).size() -1);
                }
                else
                {
                    int min = Math.min(triangle.get(i-1).get(j) , triangle.get(i-1).get(j-1));
                    
                    sum = triangle.get(i).get(j) + min;
                }
                
                triangle.get(i).set(j , sum);
            }
        }
        
        n  = triangle.size()-1;
        List<Integer> s = triangle.get(n);
        int res = 99;
        int len = s.size();
        for(int j =0;j< len;j++)
        {
            res = Math.min(res, s.get(j));
        }
        return res;
    }
}
