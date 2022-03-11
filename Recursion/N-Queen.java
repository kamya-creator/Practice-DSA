class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i =0;i<n;i++)
        {
            for(int j =0;j<n;j++)
            {
                board[i][j] = '.';
            }
        }
        dfs(0, board, res);
        return res;
    }
    
    public void dfs(int col, char[][] board, List<List<String>> res)
    {
        if(col == board.length)
        {
            res.add(construct(board));
            return;
        }
        
        for(int i =0;i<board[0].length;i++)
        {   
            if(isValid(i, col, board))
            {
                board[i][col] = 'Q';
                dfs(col+1, board, res);
                board[i][col] = '.';
            }
        }
    }
    
    boolean isValid(int row, int col, char[][] board)
    {
        int duprow = row;
        int dupcol = col;
        
        while(row>=0 && col>=0)
        {
            if(board[row][col] == 'Q') return false;
            
            row--;
            col--;
        }
        
        row = duprow;
        col = dupcol;
        
        while(col>=0)
        {
            if(board[row][col] == 'Q') return false;
            col--;
        }
        
        row = duprow;
        col = dupcol;
        
        while(row < board.length && col>=0)
        {
            if(board[row][col] == 'Q') return false;
            
            row++;
            col--;
        }
        
        return true;
    }
    List<String> construct(char[][] board)
    {
        List<String> res = new ArrayList<>();
        for(int i =0;i<board.length;i++)
        {
            String s = new String(board[i]);
            //System.out.println(s);
            res.add(s);
        }
        
        return res;
    }
    
    
}
