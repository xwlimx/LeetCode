
public class FindClosestNumberToZero {

	public static void main(String[] args) {
		int[] testCaseArray1 = new int[] { -3, 3 };
		System.out.println("Result for test case 1: " + findClosestNumber(testCaseArray1) + "\n");

		int[] testCaseArray2 = new int[] { 3, -3 };
		System.out.println("Result for test case 2: " + findClosestNumber(testCaseArray2) + "\n");

		int[] testCaseArray3 = new int[] { -4, -2, 1, 4, 8, -1 };
		System.out.println("Result for test case 3: " + findClosestNumber(testCaseArray3) + "\n");
	}

	public static int findClosestNumber(int[] nums) {
		int closestNumber = Integer.MAX_VALUE;
		for (int currentNumber : nums) {
			// abs value of the cur no is smaller than the abs value of the closest no
			if (Math.abs(currentNumber) < Math.abs(closestNumber)) {
				closestNumber = currentNumber;
				System.out.println("[Condition 1] Update closest number : " + closestNumber);
			}
			// if both values are equal, select the positive number
			else if (currentNumber == Math.abs(closestNumber)) {
				closestNumber = currentNumber;
				System.out.println("[Condition 2] Update closest number due to tie : " + closestNumber);
			} else {
				System.out.println("[Condition 3] No update : Current number " + currentNumber);
			}
		}
		return closestNumber;
	}

}
