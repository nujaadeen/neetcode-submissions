class LRUCache {
    Map<Integer, Node> lruCache;
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        lruCache = HashMap.newHashMap(capacity);
    }
    
    public int get(int key) {
        Node node = lruCache.getOrDefault(key, null);

        System.out.println("===============>");
        for (Map.Entry<Integer, Node> entry : lruCache.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue().val);
        }

        if (node == null) return -1;
        moveToTail(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        Node foundNode = lruCache.getOrDefault(key, null);

        if (foundNode == null) {
            Node newNode = new Node(key, value, tail, null);
            lruCache.put(key, newNode);

            if (lruCache.size() == 1) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            } 
        } else {
            moveToTail(foundNode);
            foundNode.val = value;
        }
        
        if (lruCache.size() > capacity) {
            lruCache.remove(head.key);

            if (head.next != null) head.next.prev = null;

            head = head.next;
        }
        
    }

    private void moveToTail(Node node) {
        if (node == tail) return;

        if (node == head) {
            head = node.next;
            head.prev = null;
        } else {
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }

        tail.next = node;
        node.prev = tail;
        node.next = null;
        tail = node;
    }
}

class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val, Node prev, Node next) {
        this.key = key;
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}
