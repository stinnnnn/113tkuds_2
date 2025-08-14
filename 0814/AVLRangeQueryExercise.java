// 檔案：AVLRangeQueryExercise.java
import java.util.*;

public class AVLRangeQueryExercise {

    class Node {
        int key;
        Node left, right;
        Node(int key) { this.key = key; }
    }

    Node root;

    public List<Integer> rangeQuery(int min, int max) {
        List<Integer> result = new ArrayList<>();
        inOrderRange(root, min, max, result);
        return result;
    }

    void inOrderRange(Node node, int min, int max, List<Integer> res) {
        if (node == null) return;
        if (node.key > min) inOrderRange(node.left, min, max, res);
        if (node.key >= min && node.key <= max) res.add(node.key);
        if (node.key < max) inOrderRange(node.right, min, max, res);
    }
}
