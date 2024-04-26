import java.util.HashMap;
import java.util.Map;

public class Exp8 {

    public static String createLongestPalindrome(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : input.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        StringBuilder leftHalf = new StringBuilder();
        StringBuilder rightHalf = new StringBuilder();
        StringBuilder middle = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();

            while (count >= 2) {
                leftHalf.append(c);
                rightHalf.insert(0, c);
                count -= 2;
            }

            if (count == 1 && middle.length() == 0) {
                middle.append(c);
            }
        }

        return leftHalf.toString() + middle.toString() + rightHalf.toString();
    }

    public static void main(String[] args) {
        String input = "abaccddcce";
        String longestPalindrome = createLongestPalindrome(input);
        System.out.println("Input: " + input);
        System.out.println("Longest Palindrome: " + longestPalindrome);
    }
}

