https://leetcode.com/problems/implement-queue-using-stacks/discuss/1762702/java-solution-with-explained-diagram

```
/*
Using two Stacks 

|         |            
|         |           
|         |           
|         |            
|         |             
|         |           
|_________|  stack 1

|         |            
|         |           
|         |           
|         |            
|         |             
|         |           
|_________|  stack 2


Add elements to stack 1 whenever push operation is performed
push(1), push(2), push(3)


|         |          |         |
|         |          |    3    |
|         |          |   2     |
|         |          |   1     |
|         |          |_________|   
|    1    |           
|_________|           stack 1



For pop operation using stack 1 and stack 2 both, as in queue first element is poped out and notice first element is at the bottom of stack 1 so , first pop out all elements from stack 1 to stack 2 , then first eement will be at top of stack 2 , hence pop out top element od stack 2 and re fill the stack 1 with rest of elements of stack 2



pop(), pop()



|         |            
|         |           
|         |           
|         |            
|         |             
|         |           
|_________|  stack 1   


|         |            
|         |           
|         |           
|         |            
|    1  --------> remove it/ pop it             
|    2     |           
|____3_____|  stack 2



|         |            
|         |           
|         |           
|         |            
|         |              
|    2     |           
|____3_____|  stack 2


Refill the stack 1 with rest of elements of stack 2

|         |            
|         |           
|         |           
|         |            
|                 
|    3     |           
|_____1___|  stack 1

same logic for top operations
*/




class MyQueue {
    Stack<Integer> stack_1 = new Stack<>();
    Stack<Integer> stack_2 = new Stack<>();
    public MyQueue() {
        
        
    }
    
    public void push(int x) {
        
        stack_1.push(x);
    }
    
    public int pop() {
        int res =0;
        if(stack_2.size() == 0)
        {
            while(stack_1.size() !=0)
            {
                stack_2.push(stack_1.pop());
            }
            
            res = stack_2.pop();
        }
        while(stack_2.size()!=0)
        {   int c = stack_2.pop();
            //System.out.print(c);
            stack_1.push(c);
         System.out.print(stack_1.peek());
        }
        return res;
    }
    
    public int peek() {
        int res =0;
        if(stack_2.size() == 0)
        {
            while(stack_1.size()!=0)
            {
                stack_2.push(stack_1.pop());
            }
            
            res = stack_2.peek();
        }
        while(stack_2.size()!=0)
        {
            stack_1.push(stack_2.pop());
        }
        return res;
    }
    
    public boolean empty() {
        
        if(stack_1.size() == 0)
            return true;
        
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
