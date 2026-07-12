class LRUCache {
    Map<Integer, Node> lruCache;
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        lruCache = HashMap.newHashMap(capacity);

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        head.prev = null;

        tail.prev = head;
        tail.next = null;
    }
    
    public int get(int key) {
        Node node = lruCache.get(key);
        if (node == null) return -1;

        remove(node);
        insert(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = lruCache.get(key);
        if (node != null) remove(node);

        Node newNode = new Node(key, value);

        lruCache.put(key, newNode);
        insert(newNode); 

        if (lruCache.size() > this.capacity) {
            lruCache.remove(head.next.key);
            remove(head.next);
        }
    }

    private void insert(Node node) {
        node.prev = tail.prev;
        node.next = tail;

        tail.prev.next = node;
        tail.prev = node;
    }

    private void remove(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
}

class Node {
    public int key;
    public int val;
    public Node prev;
    public Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
