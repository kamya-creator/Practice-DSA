class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
     
        LinkedList<Integer> res = new LinkedList<>();
        
        // Like in basic addition we start from end , 
        //so same as traditional way of addition , 
        //start from end and add k to it.
        
        // add unit digit of current sum at linkedList head
        // now reduce k to k/10 and move for second iteration i.e second         // last digit of array
        
        for(int i=num.length-1;i>=0;i--)
        {
            k = k + num[i];
            
            // addFirst add element at the head of linkedlist
            res.addFirst(k%10);
            k = k/10;
        }
        
        // at last there might be some carry left 
        // in k so add it also in res
        while(k >0)
        {
            res.addFirst(k%10);
            k = k/10;
        }   
        //System.out.print(res);
        return res;
    }
}
