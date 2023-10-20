import java.util.*;

// Time: O(n) 
// Space: O(1)
class Program {
    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList middleNode(LinkedList linkedList) {
        LinkedList currNode = linkedList;
        int nodeCount = 0;

        while (currNode != null) {
            ++nodeCount;
            currNode = currNode.next;
        }

        LinkedList middleNode = linkedList;
        for (int i = 0; i < nodeCount / 2; i++) {
            middleNode = middleNode.next;
        }
        return middleNode;
    }
}

// Time: O(n)
// Space: O(1)
// Note: The intuition here is that the middle node will be 1/2 of the length,
// so one pointer is 2x faster
// we use fastNode != null && fastNode.next!= null for even and odd checks,
// respectively
class Program {
    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList middleNode(LinkedList linkedList) {
        LinkedList slowNode = linkedList;
        LinkedList fastNode = linkedList;

        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return slowNode;
    }
}