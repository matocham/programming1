package matocham.trees;

public class BinaryNode {
    String value;
    BinaryNode left;
    BinaryNode right;

    public BinaryNode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Binary Node: ").append(value)
                .append(", Children: {");
        if (left != null) {
            result.append(left.value).append(", ");
        }
        if (right != null) {
            result.append(right.value);
        }
        result.append("}\n");
        if (left != null) {
            result.append(left.toString());
        }
        if (right != null) {
            result.append(right.toString());
        }
        return result.toString();
    }

    public void preOrder(){
        System.out.print(value+", ");
        if(left != null){
            left.preOrder();
        }
        if(right != null){
            right.preOrder();
        }
    }

    public void inOrder(){
        if(left != null){
            left.inOrder();
        }
        System.out.print(value+", ");
        if(right != null){
            right.inOrder();
        }
    }

    public void postOrder(){
        if(left != null){
            left.postOrder();
        }
        if(right != null){
            right.postOrder();
        }
        System.out.print(value+", ");
    }
}
