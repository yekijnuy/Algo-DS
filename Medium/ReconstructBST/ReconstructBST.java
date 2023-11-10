import java.util.*;

class Program {
    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    // Time: O(n^2)
    // Space: O(n) , n is the length of the input array
    public BST reconstructBst(List<Integer> preOrderTraversalValues) {
        if (preOrderTraversalValues.size() == 0) {
            return null;
        }

        int currentValue = preOrderTraversalValues.get(0);
        int rightSubtreeRootIdx = preOrderTraversalValues.size();

        for (int idx = 1; idx < preOrderTraversalValues.size(); idx++) {
            int value = preOrderTraversalValues.get(idx);
            if (value >= currentValue) {
                rightSubtreeRootIdx = idx;
                break;
            }
        }

        BST leftSubtree = reconstructBst(preOrderTraversalValues.subList(1, rightSubtreeRootIdx));
        BST rightSubtree = reconstructBst(
                preOrderTraversalValues.subList(rightSubtreeRootIdx, preOrderTraversalValues.size()));

        BST bst = new BST(currentValue);
        bst.left = leftSubtree;
        bst.right = rightSubtree;

        return bst;
    }
}

class Program {
    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    static class TreeInfo {
        public int rootIdx;

        public TreeInfo(int rootIdx) {
            this.rootIdx = rootIdx;
        }
    }

    // Time: O(n)
    // Space: O(n) - where n is the length of the input array
    public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
        TreeInfo treeInfo = new TreeInfo(0);
        return reconstructBstFromRange(Integer.MIN_VALUE, Integer.MAX_VALUE, preOrderTraversalValues, treeInfo);
    }

    public BST reconstructBstFromRange(int lowerBound, int upperBound, List<Integer> preOrderTraversalValues,
            TreeInfo currentSubtreeInfo) {
        if (currentSubtreeInfo.rootIdx == preOrderTraversalValues.size()) {
            return null;
        }

        int rootValue = preOrderTraversalValues.get(currentSubtreeInfo.rootIdx);
        if (rootValue < lowerBound || rootValue >= upperBound) {
            return null;
        }

        currentSubtreeInfo.rootIdx += 1;
        ;
        BST leftSubtree = reconstructBstFromRange(lowerBound, rootValue, preOrderTraversalValues, currentSubtreeInfo);
        BST rightSubtree = reconstructBstFromRange(rootValue, upperBound, preOrderTraversalValues, currentSubtreeInfo);

        BST bst = new BST(rootValue);
        bst.left = leftSubtree;
        bst.right = rightSubtree;
        return bst;
    }
}
