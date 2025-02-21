import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {

		String testInput1 = "abcabcbb";
		System.out.println("Length: " + lengthOfLongestSubstring(testInput1)); // Output: 3

		String testInput2 = "bbbbb";
		System.out.println("\nLength: " + lengthOfLongestSubstring(testInput2)); // Output: 1

		String testInput3 = "pwwkew";
		System.out.println("\nLength: " + lengthOfLongestSubstring(testInput3)); // Output: 3
	}

	public static int lengthOfLongestSubstring(String s) {
		if (s.length() == 0) {
			return 0;
		}

		int leftPointer = 0, rightPointer = 0, maxLength = 0;
		Set<Character> currentWindowChars = new HashSet<>();
		while (rightPointer < s.length()) {
			// If the char at rightPointer is not in the set
			if (!currentWindowChars.contains(s.charAt(rightPointer))) {
				// Add it to the set and move rightPointer forward
				currentWindowChars.add(s.charAt(rightPointer++)); 
				// Update maxLength if the current window size is larger
				maxLength = Math.max(maxLength, currentWindowChars.size());
			} else {
				// Remove the char at leftPointer from the set and move leftPointer forward
				currentWindowChars.remove(s.charAt(leftPointer++));
			}
		}
		return maxLength;
	}

}
