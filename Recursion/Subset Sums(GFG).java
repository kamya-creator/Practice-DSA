// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}
// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    ArrayList<Integer> res = new ArrayList<>();
    
    public void SubsetSum(int indx, int sum, ArrayList<Integer> arr)
    {
        if(indx == arr.size())
        {
            res.add(sum);
            return;
        }
        SubsetSum(indx+1, sum + arr.get(indx), arr);
        SubsetSum(indx+1, sum, arr);
    }
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        SubsetSum(0, 0, arr);
        Collections.sort(res);
        return res;
    }
}
