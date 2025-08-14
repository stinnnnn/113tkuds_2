// 檔案：AVLDeleteExercise.java
public class AVLDeleteExercise {

    class Node {
        int key, height;
        Node left, right;

        Node(int key) {
            this.key = key;
            this.height = 1;
        }
    }

    Node root;

    int height(Node n) {
        return (n == null) ? 0 : n.height;
    }

    Node delete(Node root, int key) {
        // 1. 普通 BST 刪除邏輯
        if (root == null) return null;

        if (key < root.key)
            root.left = delete(root.left, key);
        else if (key > root.key)
            root.right = delete(root.right, key);
        else {
            // 只有一個或沒有子節點
            if (root.left == null || root.right == null) {
                root = (root.left != null) ? root.left : root.right;
            } else {
                // 有兩個子節點 -> 找後繼
                Node successor = minValueNode(root.right);
                root.key = successor.key;
                root.right = delete(root.right, successor.key);
            }
        }

        if (root == null) return null;

        // 2. 更新高度
        root.height = 1 + Math.max(height(root.left), height(root.right));

        // 3. 平衡檢查並旋轉
        // TODO: 加入平衡邏輯
        return root;
    }

    Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) current = current.left;
        return current;
    }
}
