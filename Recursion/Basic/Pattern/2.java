// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class HelloWorld {
    public static void main(String[] args) {
        pattern(5);
    }
    public static void pattern(int n)
    {
        for(int i =0;i<n;i++)
        {
            for(int j = n-i;j>0;j--)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

* * * * * 
* * * * 
* * * 
* * 
* 
