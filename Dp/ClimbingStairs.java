/*
 * Q. count ways to reach nth stair.The person can climb either 1 stair or 2 stair at a time.
 * n = 5
 */

 // approach -> it is same logic as fibonacci series the only difference is base case 



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
     
    public static void main(String[] args) {
         int n = 5; 
         System.out.println("the total ways are : "+countWays(n));
    }
}
