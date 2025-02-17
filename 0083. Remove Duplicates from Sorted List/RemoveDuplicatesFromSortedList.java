
public class RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {
		RemoveDuplicatesFromSortedList solution = new RemoveDuplicatesFromSortedList();

		ListNode testCase1 = createList(new int[] { 1, 2, 3 });
		solution.deleteDuplicates(testCase1);

		ListNode testCase2 = createList(new int[] { 1, 1, 2 });
		solution.deleteDuplicates(testCase2);

		ListNode testCase3 = createList(new int[] { 1, 1, 2, 3, 3 });
		solution.deleteDuplicates(testCase3);
	}

	public static class ListNode {
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

	public ListNode deleteDuplicates(ListNode head) {
		ListNode current = head;

		System.out.print("Initial list: ");
		printList(head);
		System.out.println();

		while (current != null && current.next != null) {
			System.out.println("Current value: " + current.val + ", Next value: " + current.next.val);
			if (current.next.val == current.val) {
				current.next = current.next.next;
				System.out.print("List after removing duplicate: ");
				printList(head);
				System.out.println();
			} else {
				System.out.println("No action is performed.");
				current = current.next;
			}
		}

		System.out.print("Final list after duplicates removed: ");
		printList(head);
		System.out.println("\n");

		return head;
	}

	// Helper method to print the linked list (for testing purposes)
	public void printList(ListNode head) {
		ListNode temp = head;
		StringBuilder sb = new StringBuilder();
		while (temp != null) {
			sb.append(temp.val).append(" -> ");
			temp = temp.next;
		}
		sb.append("null");
		System.out.print(sb.toString());
	}

	// Helper method to create a linked list from an array (for testing purposes)
	public static ListNode createList(int[] values) {
		if (values == null || values.length == 0)
			return null;

		ListNode head = new ListNode(values[0]);
		ListNode current = head;

		for (int i = 1; i < values.length; i++) {
			current.next = new ListNode(values[i]);
			current = current.next;
		}

		return head;
	}

}
