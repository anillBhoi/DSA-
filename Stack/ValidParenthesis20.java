package Stack;

// Grind 75


// Day 2                      LeetCode #20

        
       // Approach ->
           // Use stack to store character 

import java.util.Stack;
public class ValidParenthesis20 {
    public boolean isValid(String s) {

        Stack<Character>stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '(') stack.push(')');
            else if(ch == '{') stack.push('}');
            else if(ch == '[') stack.push(']');
            else if(stack.isEmpty() || stack.pop() != ch) return false;

        }
        return stack.isEmpty();

    }
}
