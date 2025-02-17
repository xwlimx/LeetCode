import java.util.Arrays;

public class RunningSumOf1dArray {

	public static void main(String[] args) {
		int[] testArray1 = new int[] { 1, 2, 3, 4 };
		System.out.println("Result for test case 1: " + Arrays.toString(runningSum(testArray1)) + "\n");

		int[] testArray2 = new int[] { 1, 1, 1, 1, 1 };
		System.out.println("Result for test case 2: " + Arrays.toString(runningSum(testArray2)) + "\n");

		int[] testArray3 = new int[] { 3, 1, 2, 10, 1 };
		System.out.println("Result for test case 3: " + Arrays.toString(runningSum(testArray3)) + "\n");
	}

	public static int[] runningSum(int[] nums) {
		for (int i = 1; i < nums.length; i++)
			nums[i] += nums[i - 1];
		return nums;
	}

}
