// 檔案：AVLRotationExercise.java
public class AVLRotationExercise {

    class Node {
        int key, height;
        Node left, right;

        Node(int key) {
            this.key = key;
            this.height = 1;
        }
    }

    // 取得高度
    int height(Node n) {
        return (n == null) ? 0 : n.height;
    }

    // 更新節點高度
    void updateHeight(Node n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    // 左旋
    Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        updateHeight(x);
        updateHeight(y);

        return y;
    }

    // 右旋
    Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    // 左右旋
    Node rotateLeftRight(Node node) {
        node.left = rotateLeft(node.left);
        return rotateRight(node);
    }

    // 右左旋
    Node rotateRightLeft(Node node) {
        node.right = rotateRight(node.right);
        return rotateLeft(node);
    }
}
