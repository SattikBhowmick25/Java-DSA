import java.util.ArrayList;
import java.util.List;

public class PhoneNumber {
    private static final String[] KEYPAD = {
        "",     "",     "abc",  "def", "ghi", "jkl", 
        "mno",  "pqrs", "tuv",  "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;

        backtrack(0, digits, new StringBuilder(), result);
        return result;
    }

    private void backtrack(int index, String digits, StringBuilder current, List<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = KEYPAD[digits.charAt(index) - '0'];
        for (char ch : letters.toCharArray()) {
            current.append(ch); // Choose
            backtrack(index + 1, digits, current, result); // Explore
            current.deleteCharAt(current.length() - 1); // Un-choose
        }
    }
}
