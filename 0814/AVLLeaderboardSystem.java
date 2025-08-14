// 檔案：AVLLeaderboardSystem.java

public class AVLLeaderboardSystem {

    class Node {
        String player;
        int score, height, size;
        Node left, right;
        Node(String player, int score) {
            this.player = player;
            this.score = score;
            this.height = 1;
            this.size = 1;
        }
    }

    Node root;

    // TODO: 插入/更新分數
    // TODO: 計算排名
    // TODO: 查詢前 K 名
}
