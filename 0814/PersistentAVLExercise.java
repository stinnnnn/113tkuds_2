// 檔案：PersistentAVLExercise.java
public class PersistentAVLExercise {

    static class Node {
        final int key, height;
        final Node left, right;
        Node(int key, Node left, Node right, int height) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.height = height;
        }
    }

    Node[] versions = new Node[100]; // 簡化存版本

    // 插入會回傳新版本根節點
    Node insert(Node root, int key) {
        // TODO: 實作路徑複製插入
        return root;
    }

    Node getVersion(int v) {
        return versions[v];
    }
}
