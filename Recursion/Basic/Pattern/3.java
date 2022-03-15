// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class HelloWorld {
    public static void main(String[] args) {
        pattern(5);
    }
    public static void pattern(int n)
    {
        for(int i =1;i<=n;i++)
        {
            for(int j = 1;j<=i;j++)
            {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}

java -cp /tmp/AEjyUmDNZE HelloWorld
1 
1 2 
1 2 3 
1 2 3 4 
1 2 3 4 5 
