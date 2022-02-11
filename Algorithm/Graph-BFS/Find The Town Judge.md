https://leetcode.com/problems/find-the-town-judge/

```
/*

*/
/*
Perfect use of Indegree and outdegree concept
*/

class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n ==1) return 1;
        int[] indegree = new int[n+1];
        int[] outdegree = new int[n+1];
        
        for(int[] edge : trust)
        {
            int src = edge[0];
            int dest = edge[1];
            
            outdegree[src]++;
            indegree[dest]++;
        }
        
        for(int i =0;i<indegree.length ;i++)
        {
            if(outdegree[i] == 0 && indegree[i] == n-1)
                return i;
        }
        return -1;
    }
}
