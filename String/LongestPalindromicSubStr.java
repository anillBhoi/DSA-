public class LongestPalindromicSubStr {
    
    public String longestPalindrome(String s) {
        String result = "";


               // if odd pallindrome 
        for(int axis = 0; axis < s.length(); axis++ ){

            int orbit = 1; 
            int len = 1; 

            while(axis-orbit >=0 && axis + orbit < s.length()){

                if(s.charAt(axis - orbit) == s.charAt(axis + orbit )){
                    orbit++; 
                    len += 2; 
                } else{
                    break;
                }
            } 

            if(len > result.length()){
                int si = axis - len/2;

                result = s.substring(si, si+len);

            }


        }  
           
          // if even palindrom 

          for(int axis = 0; axis < s.length(); axis++ ){

            int orbit = 1; 
            int len = 0; 

            while(axis-orbit +1>=0 && axis + orbit < s.length()){

                if(s.charAt(axis - orbit+1) == s.charAt(axis + orbit )){
                    orbit++; 
                    len += 2; 
                } else{
                    break;
                }
            } 

            if(len > result.length()){
                int si = axis - len/2 +1;

                result = s.substring(si, si+len);

            }

        }

          return result;
    }
}