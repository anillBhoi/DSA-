/*
 * Q. count ways to reach nth stair.The person can climb either 1 stair or 2 stair at a time.
 * n = 5
 */

 // approach -> it is same logic as fibonacci series the only difference is base case 

import java.util.Arrays;

public class ClimbingStairs {

    // using recursion 
    public static int countWays(int n){  // tc is exponential O(2^n)

        // base case 
        if(n == 0){
            return 1;
        }
        if(n < 0){  // if value of n goes in negative
            return 0;
        }

        return countWays(n-1)+countWays(n-2);
    }

    // using Memoization 
    public static int countWaysMemo(int n, int dp[]){   // time complexity is O(N)
          // base case 
        if(n == 0){
            return 1;
        }
        if(n < 0){  // if value of n goes in negative
            return 0;
        }

        if(dp[n] != -1){
            return dp[n];
        }
        dp[n] = countWaysMemo(n-1, dp)+countWaysMemo(n-2, dp);
        return dp[n];
    }
     

    // using Tabulation 
    public static int countWaysTab(int n){  // tc O(N)
        int dpTab[] = new int[n+1];
        // initialize 
        dpTab[0] = 1;
        
        // tabulation loop
        for(int i=1; i<=n; i++){
            if(i == 1){
                dpTab[i] = dpTab[i-1];
            }
           else{
            dpTab[i] = dpTab[i-1] + dpTab[i-2];
           }
        }
     return dpTab[n];
    }

    public static void main(String[] args) {
         int n = 5; 
         System.out.println("the total ways using recursion are : "+countWays(n));
         int dp[] = new int[n+1];
         Arrays.fill(dp,-1); // initialize the array to -1 
         System.out.println("total ways using memo is :"+countWaysMemo(n, dp));
         System.out.println("The total ways using tabulation : "+countWaysTab(n));

    }
}
