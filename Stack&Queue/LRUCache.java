import java.util.*;

class Node{
    int key, val;
    Node prev;
    Node next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

public class LRUCache {

    Map<Integer, Node> map = new HashMap<>();
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity_) {
        this.capacity = capacity_;
        
        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node temp = map.get(key);

        deleteNode(temp);
        insertAfterHead(temp);

        return temp.val;
    }
    
    void put(int key, int value) {

        if (map.containsKey(key)) {
            Node newNode = map.get(key);
            newNode.val = value;

            deleteNode(newNode);
            insertAfterHead(newNode);

        } else {
            Node newNode = new Node(key, value);

            map.put(key, newNode);
            insertAfterHead(newNode);

            if (map.size() > capacity) {

                Node lru = tail.prev;
                deleteNode(lru);
                map.remove(lru.key);
            }
        }
    }

    void insertAfterHead(Node node) {

        Node first = head.next;

        node.next = first;
        node.prev = head;

        head.next = node;
        first.prev = node;
    }

    // Remove node from its current position
    void deleteNode(Node node) {

        Node previous = node.prev;
        Node next = node.next;

        previous.next = next;
        next.prev = previous;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 10);
        cache.put(2, 20);

        System.out.println(cache.get(1)); // 10

        cache.put(3, 30);

        System.out.println(cache.get(2)); // -1
        System.out.println(cache.get(3)); // 30
        System.out.println(cache.get(1)); // 10
    }
}

