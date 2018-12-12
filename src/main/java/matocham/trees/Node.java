package matocham.trees;

import java.util.ArrayList;
import java.util.List;

public class Node {
    String value;
    List<Node> children = new ArrayList<Node>();

    public Node(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Node: ").append(value)
                .append(", Children: {");
        for (Node child : children) {
            result.append(child.value).append(", ");
        }
        result.append("}\n");
        for (Node child : children) {
            result.append(child.toString());
        }
        return result.toString();
    }
}
