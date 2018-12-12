package matocham.trees;

public class Tree {
    Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node isInTheTree(String value){
        return isInTheSubtree(value, root);
    }

    private Node isInTheSubtree(String value, Node node){
        if(node.getValue().equals(value)){
            return node;
        }
        for (Node child : node.getChildren()) {
            Node isInSubtree = isInTheSubtree(value, child);
            if(isInSubtree != null){
                return isInSubtree;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return root.toString();
    }
}
