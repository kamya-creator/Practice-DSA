/*
rowIndex = 3

row = []
prev = null

Note for finding rowIndex Pascal triangle 
so we will loop from i = 0 to rowIndex

Notice for row i therse will be i+1 elements in row
so to fill row i we will run loop from j =0 to i (0-based indexing)

for corner elements i.e j =0 and j =i put 1 in row

for elements in between use the previous row elemnts , so we are going to use prev to store current row as previous

Let's understand with an example

rowIndex = 3

row = [] , prev = null

FOR   i =0  row = [] 
        j =0  , 0<= 0 row = [1] 
        prev = row , prev = [1]


FOR   i =1  row = [] 
        j =0  , 0<= 1 row = [1] 
        j =1 ,  0<=1  row = [1,1]
        
        prev = [1,1]
        
FOR   i =2  row = [] 
        j =0  , 0<= 2  row = [1]  , prev = [1,1]
        j =1 ,  1<= 2  row = [1, 2]  (Notice using prev to fill row)
        j =2 ,  2<=2   row = [1,2,1]
        
        prev = [1,2,1]

FOR   i =3  row = [] 
        j =0  , 0<= 3  row = [1]  , prev = [1,2,1]
        j =1 ,  1<= 3  row = [1, 3]  (Notice using prev to fill row)
        j =2 ,  2<= 3   row = [1,3,3]
        j = 3,  3<= 3   row = [1,3,3,1]
        
        prev = [1,3,3,1]

        

*/

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        List<Integer> prev = null;
        for(int i =0;i< rowIndex+1 ;i++)
        {    row = new ArrayList<>();
            for(int j =0;j<=i;j++)
            {
                if(j == 0 || j == i)
                    row.add(1);
                else
                    row.add(prev.get(j) + prev.get(j-1));
            }
            prev = row;
        }
    return row;    
    }
    
}
