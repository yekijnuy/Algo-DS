import java.util.*;

// Time: O(n)
// Space: O(n), not as efficient as just moving pointers around
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

    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        HashMap<Integer, Boolean> mapOfValues = new HashMap<Integer, Boolean>();
        LinkedList currentNode = linkedList;
        LinkedList prevNode = linkedList;

        while (currentNode != null) {
            Integer currentVal = currentNode.value;
            Boolean hashValue = mapOfValues.containsKey(currentVal);

            if (hashValue) {
                // remove node
                prevNode.next = currentNode.next;
                currentNode = currentNode.next;
            } else {
                mapOfValues.put(currentVal, true);
                prevNode = currentNode;
                currentNode = currentNode.next;
            }
        }
        return linkedList;
    }
}

// Time: O(n)
// Space: O(1), just finding pointers that match or not match the condition
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

    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        // Write your code here.
        LinkedList currentNode = linkedList;
        while (currentNode != null) {
            LinkedList nextDistinctNode = currentNode.next;
            while (nextDistinctNode != null
                    && nextDistinctNode.value == currentNode.value) {
                nextDistinctNode = nextDistinctNode.next;
            }
            currentNode.next = nextDistinctNode;
            currentNode = nextDistinctNode;
        }
        return linkedList;
    }
}