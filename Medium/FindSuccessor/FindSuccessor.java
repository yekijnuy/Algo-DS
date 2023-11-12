import java.util.*;

class Program {
    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    // Time - O(n)
    // Space - O(n)
    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        ArrayList<BinaryTree> inOrderTraversalOrder = new ArrayList<BinaryTree>();
        ;
        getInOrderTraversalOrder(tree, inOrderTraversalOrder);

        for (int i = 0; i < inOrderTraversalOrder.size(); i++) {
            BinaryTree currentNode = inOrderTraversalOrder.get(i);

            if (currentNode != node) {
                continue;
            }

            if (i == inOrderTraversalOrder.size() - 1) {
                return null;
            }

            return inOrderTraversalOrder.get(i + 1);
        }
        return null;
    }

    void getInOrderTraversalOrder(BinaryTree node, ArrayList<BinaryTree> order) {
        if (node == null) {
            return;
        }

        getInOrderTraversalOrder(node.left, order);
        order.add(node);
        getInOrderTraversalOrder(node.right, order);
    }
}
