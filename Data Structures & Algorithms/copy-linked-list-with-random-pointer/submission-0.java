/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> nodeMap = new HashMap<>();

        Node itr = head;
        
        while (itr != null) {
            Node newNode = new Node(itr.val);
            nodeMap.put(itr, newNode);
            itr = itr.next;
        }

        Node itr2 = head;

        while (itr2 != null) {
            Node newNode = nodeMap.get(itr2);
            newNode.next = nodeMap.get(itr2.next);
            newNode.random = nodeMap.get(itr2.random);

            itr2 = itr2.next;
        }

        return nodeMap.get(head);
    }
}
