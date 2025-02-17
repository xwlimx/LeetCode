
public class MergeStringsAlternately {

	public static void main(String[] args) {
		String testCase1Word1 = "abc", testCase1Word2 = "pqr";
		System.out.println("Result for test case 1: " + mergeAlternately(testCase1Word1, testCase1Word2) + "\n");

		String testCase2Word1 = "ab", testCase2Word2 = "pqrs";
		System.out.println("Result for test case 2: " + mergeAlternately(testCase2Word1, testCase2Word2) + "\n");

		String testCase3Word1 = "abcd", testCase3Word2 = "pq";
		System.out.println("Result for test case 3: " + mergeAlternately(testCase3Word1, testCase3Word2) + "\n");
	}

	public static String mergeAlternately(String word1, String word2) {
		StringBuilder result = new StringBuilder();
		int i = 0;
		while (i < word1.length() || i < word2.length()) {
			if (i < word1.length()) {
				result.append(word1.charAt(i));
			}
			if (i < word2.length()) {
				result.append(word2.charAt(i));
			}
			i++;
		}
		return result.toString();
	}

}
