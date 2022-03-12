// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!"); 
        int[] arr = {1,2,13,4};
        System.out.println(search(arr,0, 33));
    }
    public static boolean search(int[] arr, int ind, int target)
    {
        if(ind == arr.length)
        return false;
        
        if(arr[ind] == target)
        {
            return true;
        }
        return search(arr, ind+1, target);
    }
}
