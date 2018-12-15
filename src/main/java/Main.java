import matocham.lists.SdaLinkedList;
import matocham.lists.SdaList;
import matocham.sort.BubbleSort;
import matocham.sort.InsertionSort;
import matocham.sort.SortingAlghortim;
import matocham.trees.BinaryNode;
import matocham.trees.BinaryTree;
import matocham.trees.Node;
import matocham.trees.Tree;
import matocham.trees.TreeTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //testLists();
        //testTree();
        //binaryTreeTest();
        //testHeap();
        int[] array = generateArray(10);
        System.out.println(Arrays.toString(array));
        SortingAlghortim alghortim = new InsertionSort();
        alghortim.sort(array);
        System.out.println(Arrays.toString(array));

    }

    public static int[] generateArray(int size){
        int[] array = new int[size];
        Random random = new Random(System.currentTimeMillis());
        Arrays.setAll(array, operand -> random.nextInt(1000));
        return array;
    }

    private static void testHeap() {
        TreeTable table = new TreeTable();
        table.add("a");
        table.add("b");
        table.add("d");
        table.add("f");
        table.add("a");
        System.out.println(table);
        table.sort();
        System.out.println(table);
    }

    private static void binaryTreeTest() {
        BinaryNode nodeA = new BinaryNode("A");
        BinaryNode nodeB = new BinaryNode("B");
        BinaryNode nodeC = new BinaryNode("C");
        BinaryNode nodeD = new BinaryNode("D");
        BinaryNode nodeE = new BinaryNode("E");
        BinaryNode nodeF = new BinaryNode("F");
        BinaryNode nodeG = new BinaryNode("G");
        BinaryNode nodeH = new BinaryNode("H");
        BinaryNode nodeI = new BinaryNode("I");
        nodeF.setLeft(nodeB);
        nodeF.setRight(nodeG);
        nodeB.setLeft(nodeA);
        nodeB.setRight(nodeD);
        nodeD.setLeft(nodeC);
        nodeD.setRight(nodeE);
        nodeG.setRight(nodeI);
        nodeI.setLeft(nodeH);
        BinaryTree tree = new BinaryTree(nodeF);
        System.out.println(tree);
        System.out.println(tree.isInTheTree("G"));
        tree.postOrderVisit();
    }

    private static void testTree() {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");
        Node nodeH = new Node("H");
        List<Node> aChildren = new ArrayList<Node>();
        aChildren.add(nodeB);
        aChildren.add(nodeC);
        aChildren.add(nodeD);
        nodeA.setChildren(aChildren);

        List<Node> bChildren = new ArrayList<Node>();
        bChildren.add(nodeE);
        bChildren.add(nodeF);
        bChildren.add(nodeG);
        nodeB.setChildren(bChildren);

        List<Node> dChildren = new ArrayList<Node>();
        dChildren.add(nodeH);
        nodeD.setChildren(dChildren);
        Tree tree = new Tree(nodeA);
        System.out.println(tree);

//        System.out.println(tree.isInTheTree("A"));
//        System.out.println(tree.isInTheTree("B"));
//        System.out.println(tree.isInTheTree("H"));
//        System.out.println(tree.isInTheTree("X"));
        Node hNode2 = tree.isInTheTree("H");
        hNode2.getChildren().add(new Node("X"));
        System.out.println(tree.isInTheTree("H"));
    }

    private static void testLists() {
        SdaList list1 = new SdaLinkedList();
        for (int i = 0; i < 10; i++) {
            list1.add("e"+i);
            System.out.println(list1);
        }
        list1.add("x1", 0);
        System.out.println(list1);
        list1.add("x2", list1.size());
        System.out.println(list1);
        list1.remove(0);
        System.out.println(list1);
        list1.remove(list1.size()-1);
        System.out.println(list1);
        System.out.println(list1.get(0));
        System.out.println(list1.get(2));
        System.out.println(list1.get(9));
    }
}
