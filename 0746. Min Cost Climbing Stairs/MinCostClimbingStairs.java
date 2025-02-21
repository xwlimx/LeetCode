
public class MinCostClimbingStairs {

	public static void main(String[] args) {
		int[] cost1 = { 10, 15, 20 };
		int result1 = minCostClimbingStairs(cost1);
		System.out.println("Minimum cost to reach the top: " + result1 + "\n");

		int[] cost2 = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
		int result2 = minCostClimbingStairs(cost2);
		System.out.println("Minimum cost to reach the top: " + result2);
	}

	public static int minCostClimbingStairs(int[] cost) {
		int n = cost.length, first = cost[0], second = cost[1];
		if (n <= 2) {
			System.out.println("Base case: returning the minimum of first two steps");
			return Math.min(cost[0], cost[1]);
		}
		System.out.println("Initial step costs: step 0 = " + first + ", step 1 = " + second);

		// Iterate from the third step onwards
		for (int i = 2; i < n; i++) {
			int currentCost = cost[i] + Math.min(first, second); // Calculate the cost to reach the current step
			System.out.println("Step " + i + ": " + cost[i] + " + min(" + first + "," + second + ") = " + currentCost);

			first = second; // Update the first step to the previous step
			second = currentCost; // Update the second step to the current step's cost
			System.out.println("Updated first = " + first + " and second = " + second);
		}

		System.out.println("Final result: minimum of the last two steps' costs: " + first + " and " + second);
		return Math.min(first, second);
	}
}
