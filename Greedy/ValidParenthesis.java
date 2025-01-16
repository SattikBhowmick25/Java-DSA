public class ValidParenthesis{
    class Solution {
        public boolean checkValidString(String s) {
            int minOpen = 0; // Minimum open parentheses needed
            int maxOpen = 0; // Maximum open parentheses possible
            
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    minOpen++;
                    maxOpen++;
                } else if (c == ')') {
                    minOpen = Math.max(minOpen - 1, 0); // Ensure minOpen does not go below 0
                    maxOpen--;
                } else if (c == '*') {
                    minOpen = Math.max(minOpen - 1, 0); // Treat '*' as ')'
                    maxOpen++; // Treat '*' as '('
                }
                
                // If maxOpen goes negative, it's invalid
                if (maxOpen < 0) {
                    return false;
                }
            }
            
            // Valid if minOpen is 0
            return minOpen == 0;
        }
    }
    
}