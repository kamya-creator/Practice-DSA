https://leetcode.com/problems/valid-parentheses/discuss/1762521/2ms-stack-java-solution-with-little-variation
```
class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();
        
        for(int i =0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            
            if(ch == '(' || ch == '{' || ch == '[')
                stack.push(ch);
            else 
            {   char top = 'c';  // Random variable just to make sure if stack is empty then top = stack.pop() won't get execute , so top conatin random variable and return false
                if(stack.size() > 0)
                {
                 top = stack.pop();
                }
                if( ch == ')' && top != '(')
                    return false;
                
                
                if( ch == '}' && top != '{')
                    return false;
                
                
                if( ch == ']' && top != '[')
                    return false;
                
            }
        }
        
        if(stack.size() == 0)
            return true;
        
        return false;
    }
}
