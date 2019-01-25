package matocham.bst;

public class BST {
    private Node root;

    public void add(int value) {
        Node temp = root;
        Node parent = null;
        while (temp != null) {
            parent = temp;
            if (value < temp.getValue()) {
                temp = temp.getLeft();
            } else {
                temp = temp.getRight();
            }
        }
        Node newNode = new Node(value);
        if (parent == null) {
            root = newNode;
        } else {
            newNode.setParent(parent);
            if (value < parent.getValue()) {
                parent.setLeft(newNode);
            } else {
                parent.setRight(newNode);
            }
        }
    }

    private Node search(int value, Node node) {
        if (node == null) {
            return null;
        }

        if (node.getValue() == value) {
            return node;
        }
        if (value < node.getValue()) {
            return search(value, node.getLeft());
        } else {
            return search(value, node.getRight());
        }
    }

    public boolean find(int value) {
        Node n = search(value, root);
        return n != null;
    }

    public int max() {
        Node max = maxNode(root);
        return max == null ? -1 : max.getValue();
    }

    private Node maxNode(Node start) {
        Node temp = start;
        if (temp == null) {
            return null;
        }
        while (temp.getRight() != null) {
            temp = temp.getRight();
        }
        return temp;
    }

    public int min() {
        Node min = minNode(root);
        return min == null ? -1 : min.getValue();
    }

    private Node minNode(Node start) {
        Node temp = start;
        if (temp == null) {
            return null;
        }
        while (temp.getLeft() != null) {
            temp = temp.getLeft();
        }
        return temp;
    }

    private Node successor(Node n) {
        if (n.getRight() != null) {
            return minNode(n.getRight());
        } else {
            Node parent = n.getParent();
            while (parent != null && parent.getRight().equals(n)) {
                n = parent;
                parent = parent.getParent();
            }
            return parent;
        }
    }

    public void remove(int value) {
        Node search = search(value, root);
        if (search == null) {
            return; // no elmement
        }
        Node removed;
        if (search.getRight() == null || search.getLeft() == null) {
            removed = search;
        } else {
            removed = successor(search);
        }
        Node child;
        Node parent = removed.getParent();
        if (removed.getLeft() == null) {
            child = removed.getRight();
        } else {
            child = removed.getLeft();
        }
        if (child != null) {
            child.setParent(parent);
        }
        if (parent == null) {
            root = child;
        } else if (parent.getLeft() != null && parent.getLeft().equals(removed)) {
            parent.setLeft(child);
        } else {
            parent.setRight(child);
        }
        if (removed != search) {
            search.setValue(removed.getValue());
        }
    }

    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(Node n) {
        if (n == null) {
            return;
        }

        inorder(n.getLeft());
        System.out.print(n.getValue() + ", ");
        inorder(n.getRight());
    }

    @Override
    public String toString() {
        if (root == null) {
            return "(empty)";
        }
        return toString(root, 0);
    }

    private String toString(Node node, int intend) {
        if (node == null) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < intend; i++) {
            result.append(" |");
        }
        result.append("Node ").append(node.getValue()).append("\n");
        for (int i = 0; i < intend + 1; i++) {
            result.append(" |");
        }
        result.append("Left: {").append(node.getLeft() == null ? "null" : node.getLeft().getValue()).append("}\n");
        result.append(toString(node.getLeft(), intend + 2));
        for (int i = 0; i < intend + 1; i++) {
            result.append(" |");
        }
        result.append("Right: {").append(node.getRight() == null ? "null" : node.getRight().getValue()).append("}\n");
        result.append(toString(node.getRight(), intend + 2));
        return result.toString();
    }
}
