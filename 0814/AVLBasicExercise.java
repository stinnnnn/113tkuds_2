public class AVLBasicExercise {

    class Node {
        int key, height;
        Node left, right;

        Node(int key) {
            this.key = key;
            this.height = 1;
        }
    }

    Node root;

    // 取得節點高度
    int height(Node node) {
        return (node == null) ? 0 : node.height;
    }

    // 計算平衡因子
    int getBalance(Node node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    // 插入節點 (先當作普通 BST 插入)
    Node insert(Node node, int key) {
        if (node == null) return new Node(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node; // 不允許重複

        // 更新高度
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // 這裡先不做旋轉，後續可加入平衡
        return node;
    }

    // 搜尋節點
    boolean search(Node node, int key) {
        if (node == null) return false;
        if (key == node.key) return true;
        return key < node.key ? search(node.left, key) : search(node.right, key);
    }

    // 計算樹高度
    int treeHeight() {
        return height(root);
    }

    // 檢查是否為有效的 AVL 樹
    boolean isValidAVL(Node node) {
        if (node == null) return true;
        int balance = getBalance(node);
        if (balance < -1 || balance > 1) return false;
        return isValidAVL(node.left) && isValidAVL(node.right);
    }

    // 測試用
    public static void main(String[] args) {
        AVLBasicExercise tree = new AVLBasicExercise();
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        System.out.println("樹高度: " + tree.treeHeight());
        System.out.println("是否為 AVL: " + tree.isValidAVL(tree.root));
    }
}
