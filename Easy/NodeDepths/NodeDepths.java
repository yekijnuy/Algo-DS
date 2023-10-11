import java.util.*;

class Program {
    public static int nodeDepths(BinaryTree root) {
        // Write your code here.
        Integer depthSum = 0;
        return nodeDepths(root, depthSum);
    }

    public static int nodeDepths(BinaryTree root, Integer depthSum) {
        if (root == null) {
            return 0;
        }

        return depthSum + nodeDepths(root.left, depthSum + 1) + nodeDepths(root.right, depthSum + 1);
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
