// Fibonacci by recursion 
public class Fibonacci {
    
    public static int fib(int n ){  // recursion take exponential time complexity O(2^n) 
        // base case 
        if(n == 0 || n == 1){
            return n;
        }

        int sum = fib(n-1)+fib(n-2);
        return sum;
    }

    public static void main(String args[]){
        int n = 6; 
        System.out.println("the fib of "+n+" is : "+fib(n));
    }
}
