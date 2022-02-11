https://leetcode.com/problems/find-if-path-exists-in-graph/discuss/1763009/BFS-Used-or-Java-Solution-or
```
/*
Using BFS for checking if the source and destination lie in same connected component or not
*/
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination)    {    
        // First Convert the edges matrix into Adjanecy list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges)
        {   int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        // visited array to keep track of visited nodes of graph
        int[] visited = new int[n+1];
        
        for(int i =0;i< n;i++)
        {
            if(visited[i] == 0)
            {   // This BFS call would find the connected components 
                BFS(adj, i, visited);
                // IF after BFS call , the source and destination are not marked visited simulatenously then it means they are not connected to each other, So return false 
                if(visited[source] == 1 && visited[destination] == 0 ||
                  visited[source] == 0 && visited[destination] == 1)
                    return false;
            }
        }
        return true;
        
    }
    public void BFS(List<List<Integer>> adj, int src , int[] visited)
    {
        visited[src] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        while(queue.size()>0)
        {
            int n = queue.remove();
            //System.out.print(n);
            for(Integer i : adj.get(n))
            {
                if(visited[i] == 0)
                {
                    visited[i] =1;
                    queue.add(i);
                }
            }
        }
            
        
    }
    
}
