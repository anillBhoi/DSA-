package String;

import java.util.HashSet;
import java.util.Set;
// using sliding window 

public class LongestSubstr3 {
    public int lengthOfLongestSubstring(String s) {  // time complexity is O(n)
       
       Set<Character>charSet = new HashSet<>();
       int maxLength = 0; 
       int left = 0; 

       for(int right = 0; right <s.length(); right++){

        while(charSet.contains(s.charAt(right))){
            charSet.remove(s.charAt(left));
            left++;
        }
        
        charSet.add(s.charAt(right));
        maxLength = Math.max(maxLength,right-left+1);
       }

       return maxLength;
       
    }
}
