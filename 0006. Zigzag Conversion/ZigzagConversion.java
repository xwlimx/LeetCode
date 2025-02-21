
public class ZigzagConversion {

	public static void main(String[] args) {
		String input1 = "PAYPALISHIRING";
		int numRows1 = 3;
		System.out.println("Input: " + input1);
		System.out.println("Zigzag Converted Output: " + convert(input1, numRows1) + "\n"); // Output: "PAHNAPLSIIGYIR"

		String input2 = "PAYPALISHIRING";
		int numRows2 = 4;
		System.out.println("Input: " + input2);
		System.out.println("Zigzag Converted Output: " + convert(input2, numRows2) + "\n"); // Output: "PINALSIGYAHRPI"

		String input3 = "A";
		int numRows3 = 1;
		System.out.println("Input: " + input3);
		System.out.println("Zigzag Converted Output: " + convert(input3, numRows3) + "\n"); // Output: "A"
	}

	public static String convert(String s, int numRows) {
		if (numRows == 1 || s.length() <= numRows) {
			return s;
		}

		StringBuffer[] sb = new StringBuffer[numRows];
		for (int i = 0; i < numRows; i++) {
			sb[i] = new StringBuffer();
		}

		int currentRow = 0;
		boolean goingDown = false;

		for (char c : s.toCharArray()) {
			// Add the current character to the appropriate row
			sb[currentRow].append(c);
			System.out.println("Appended '" + c + "' to row " + currentRow + ". Current row: " + sb[currentRow]);

			// If we are at the top or bottom, we reverse the direction
			if (currentRow == 0 || currentRow == numRows - 1) {
				goingDown = !goingDown;
				System.out.println("Direction changed. Going down: " + goingDown);
			}

			// Move to the next row depending on the direction
			currentRow += goingDown ? 1 : -1;
		}

		StringBuffer result = new StringBuffer();
		for (StringBuffer row : sb) {
			result.append(row);
		}

		return result.toString();
	}

}
