// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!"); 
        int[] arr = {1,2,13,4};
        System.out.println(sorted(arr,0));
    }
    public static boolean sorted(int[] arr, int ind)
    {
        if(ind == arr.length-1)
        return true;
        
        if(arr[ind]< arr[ind+1])
        {
            return sorted(arr, ind+1);
        }
        return false;
    }
}
