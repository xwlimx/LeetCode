
public class ClimbingStairs {

	public static void main(String[] args) {
		// Test Case 1: n = 1
		int n1 = 1;
		System.out.println("Ways to climb " + n1 + " steps: " + climbStairs(n1)); // Expected: 1

		// Test Case 2: n = 2
		int n2 = 2;
		System.out.println("Ways to climb " + n2 + " steps: " + climbStairs(n2)); // Expected: 2

		// Test Case 3: n = 5
		int n3 = 5;
		System.out.println("Ways to climb " + n3 + " steps: " + climbStairs(n3)); // Expected: 8

	}

	public static int climbStairs(int n) {
		if (n == 0 || n == 1 || n == 2) {
			return n;
		}

		// To reach the nth step, you can either:
		// - Come from the (n-1)th step by taking a 1-step.
		// - Come from the (n-2)th step by taking a 2-step.
		// Hence, the number of ways to reach the nth step is the sum of ways to reach (n-1) and (n-2).
		
		int first = 1;
		int second = 2;
		for (int i = 3; i <= n; i++) {
			int third = first + second;
			first = second; // Move the second value to first (representing the (i-1)th step).
			second = third; // Update second to the result (representing the ith step).
		}
		return second;
	}

}
