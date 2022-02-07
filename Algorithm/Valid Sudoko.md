
https://leetcode.com/problems/valid-sudoku/discuss/1752203/Java-Readable-Solution-with-comment
/*
This Problem brute force can be same as brute force of question Check if Every Row and Column Contains All Numbers , where we maintain two set one for row-wise traversal and second for column wise traversal but it will require 3 traversals (i.e row wise ,column wise and 3 x 3 sub-boxes of the grid wise). 
We can solve this problem in just one traversal 
Instead of storing Integer in HashSet we can store String in hashset which represents the all three location of an element (i.e it's column number , it's row number and it's sub-box number)

Indexing of sub-boxes will be as follows
 ___________________________
|     |         |           |
| 00  |   01    | 02        |
|_____|_________|___________|
|     |         |           |
| 10  |  11     |  12       |
|_____|_________|___________|                         
|     |         |           |
|  20 |  21     |  22       |                         
|_____|_________|___________|   
*/
```

class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        HashSet<String> seen = new HashSet<>();
        
        for(int i =0;i<9;i++)
        {
            for(int j = 0;j<9;j++)
            {   char ch = board[i][j];
                if(ch != '.')
                {  if(!seen.add(ch + "found in row" + i)||  // storing element with row number
                    !seen.add(ch + "found in column" + j)|| // storing element with column number
                    !seen.add(ch + "found in box" + i/3 +"-"+j/3)
                     ) // storing element with box number
                    
                    return false;
                    
                }
            }
            
        } return true;
    }
}
