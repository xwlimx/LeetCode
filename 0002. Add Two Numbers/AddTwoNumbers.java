
public class AddTwoNumbers {

	public static void main(String[] args) {

		System.out.println("Test Case 1");
		// Create first linked list: 2 -> 4 -> 3
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		// Create second linked list: 5 -> 6 -> 4 
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		ListNode result = addTwoNumbers(l1, l2);
		System.out.print("Result: ");
		printList(result); // Expected Output: 7 -> 0 -> 8

		System.out.println("\nTest Case 2");
		// Create first linked list: 9 -> 9 -> 9 -> 9 -> 9 -> 9 -> 9
		l1 = new ListNode(9);
		l1.next = new ListNode(9);
		l1.next.next = new ListNode(9);
		l1.next.next.next = new ListNode(9);
		l1.next.next.next.next = new ListNode(9);
		l1.next.next.next.next.next = new ListNode(9);
		l1.next.next.next.next.next.next = new ListNode(9);

		// Create second linked list: 9 -> 9 -> 9 -> 9
		l2 = new ListNode(9);
		l2.next = new ListNode(9);
		l2.next.next = new ListNode(9);
		l2.next.next.next = new ListNode(9);

		result = addTwoNumbers(l1, l2);
		System.out.print("Result: ");
		// Expected Output: 8 -> 9 -> 9 -> 9 -> 0 -> 0 -> 0 -> 1
		printList(result);

	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode currentNode = dummyHead;
		int carry = 0; // This will store the carry value between iterations.

		while (l1 != null || l2 != null) {
			// Reset carry value to 0 for the new digit sum.
			carry /= 10;

			// Log the current sum (carry) and the new node value.
			System.out.println("Current carry: " + carry);
			System.out.println("l1 val: " + (l1 != null ? l1.val : "null"));
			System.out.println("l2 val: " + (l2 != null ? l2.val : "null"));

			// If l1 has more nodes, add its value to carry.
			if (l1 != null) {
				carry += l1.val;
				l1 = l1.next; // Move to the next node in l1.
			}

			// If l2 has more nodes, add its value to carry.
			if (l2 != null) {
				carry += l2.val;
				l2 = l2.next; // Move to the next node in l2.
			}

			// Calculate the new digit (carry % 10) and create the new node.
			currentNode.next = new ListNode(carry % 10);
			currentNode = currentNode.next; // Move to the next node in the result l.

			// Log the current sum (carry) and the new node value.
			System.out.println("Current sum: " + carry + " -> New digit: " + (carry % 10));
		}

		// If there's any remaining carry after the loop, add it as the last node.
		if (carry / 10 == 1) {
			currentNode.next = new ListNode(1);
			System.out.println("Adding final carry: 1");
		}

		return dummyHead.next;
	}

	// Helper method to print a linked list
	public static void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
	}

}
