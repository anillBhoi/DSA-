
public class Fibonacci {
    
    // Fibonacci by recursion 
    public static int fib(int n ){  // recursion take exponential time complexity O(2^n) 
        // base case 
        if(n == 0 || n == 1){
            return n;
        }

        int sum = fib(n-1)+fib(n-2);
        return sum;
    }

    // fibonacci by dp using memoization 
    public static int fibMemo(int n, int dp[] ){  // now the time complexity is O(n) only
        // base case 
        if(n == 0 || n == 1){
            return n;
        }
       // initialize the dp 
        // dp[0] = 0; 
        // dp[1] = 1; 
        
        // check if curr n is find or not 
        if(dp[n] != 0){  // allready finds the fib of n so use it 
           return dp[n];
        }

        // if not find then find it for n 
        dp[n] = fibMemo(n-1, dp)+fibMemo(n-2, dp);

        return dp[n];

    }

    public static void main(String args[]){
        int n = 6; 
        System.out.println("the fib of "+n+" is : "+fib(n));

        System.out.println("fib using memo : ");
        int dp[] = new int[n+1];
        System.out.println("fib of "+n+" using memo is : "+fibMemo(n, dp));
    }
}
