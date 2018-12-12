package matocham.trees;

public class BinaryTree {
    BinaryNode root;

    public BinaryTree(BinaryNode root) {
        this.root = root;
    }

    public BinaryNode isInTheTree(String value) {
        return isInTheSubtree(value, root);
    }

    private BinaryNode isInTheSubtree(String value, BinaryNode node) {
        if (node == null) {
            return null;
        }
        if (node.getValue().equals(value)) {
            return node;
        }
        BinaryNode isInSubtree = isInTheSubtree(value, node.getLeft());
        if (isInSubtree != null) {
            return isInSubtree;
        }
        isInSubtree = isInTheSubtree(value, node.getRight());
        if (isInSubtree != null) {
            return isInSubtree;
        }
        return null;
    }

    @Override
    public String toString() {
        return root.toString();
    }

    public void preOrderVisit(){
        root.preOrder();
        System.out.println();
    }

    public void inOrderVisit(){
        root.inOrder();
        System.out.println();
    }

    public void postOrderVisit(){
        root.postOrder();
        System.out.println();
    }
}
