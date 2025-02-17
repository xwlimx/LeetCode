import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);

		System.out.println("Test Case 1: Put element with key 1 in the cache.");
		cache.put(1, 1);
		cache.printCache(); // Cache is {1=1}

		System.out.println("\nTest Case 2: Put element with key 2 in the cache.");
		cache.put(2, 2);
		cache.printCache(); // Cache is {2=2, 1=1}

		System.out.println("\nTest Case 3: Get element with key 1.");
		System.out.println("Result: " + cache.get(1)); // Returns 1
		cache.printCache(); // Cache is {1=1, 2=2}

		System.out.println("\nTest Case 4: Put element with key 3 in the cache (Evicts key 2).");
		cache.put(3, 3); // LRU key 2 is evicted
		cache.printCache(); // Cache is {3=3, 1=1}

		System.out.println("\nTest Case 5: Get element with key 2.");
		System.out.println("Result: " + cache.get(2)); // Returns -1 (not found)
		cache.printCache(); // Cache is {3=3, 1=1}

		System.out.println("\nTest Case 6: Put element with key 4 in the cache (Evicts key 1).");
		cache.put(4, 4);
		cache.printCache(); // Cache is {4=4, 3=3}

		System.out.println("\nTest Case 7: Get element with key 1.");
		System.out.println("Result: " + cache.get(1)); // Returns -1 (not found)
		cache.printCache(); // Cache is {4=4, 3=3}

		System.out.println("\nTest Case 8: Get element with key 3.");
		System.out.println("Result: " + cache.get(3)); // Returns 3
		cache.printCache(); // Cache is {3=3, 4=4}
		
		System.out.println("\nTest Case 9: Get element with key 4.");
		System.out.println("Result: " + cache.get(4)); // Returns 4
		cache.printCache(); // Cache is {4=4, 3=3}
	}

	class Node {
		Node prev;
		Node next;
		int key, value;

		Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	Node head = new Node(0, 0);
	Node tail = new Node(0, 0);
	Map<Integer, Node> map = new HashMap<Integer, Node>();
	int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			remove(node);
			insert(node);
			return node.value;
		} else {
			return -1;
		}
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			remove(map.get(key));
		}
		if (map.size() == capacity) {
			remove(tail.prev);
		}
		insert(new Node(key, value));
	}

	private void remove(Node node) {
		map.remove(node.key);
		node.prev.next = node.next; // Update previous node's next pointer
		node.next.prev = node.prev; // Update next node's previous pointer
	}

	private void insert(Node node) {
		map.put(node.key, node);
		node.next = head.next; // The new node's next is the current first node
		node.next.prev = node; // The current first node's previous is the new node
		head.next = node; // Head's next is the new node
		node.prev = head; // The new node's previous is the head
	}

	// Helper method to print the cache state
	public void printCache() {
		Node current = head.next;
		System.out.print("Cache state: ");
		while (current != tail) {
			System.out.print("[" + current.key + "=" + current.value + "] ");
			current = current.next;
		}
		System.out.println();
	}

}
