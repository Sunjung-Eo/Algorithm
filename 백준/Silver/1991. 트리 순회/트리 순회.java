import java.io.*;
import java.util.*;

public class Main {

    public static StringBuilder sb = new StringBuilder();

    public static class Node {
        String curr;
        Node left;
        Node right;

        public Node(String curr) {
            this.curr = curr;
        }
    }

    public static void preOrder(Node node) {
        if (node == null) return;
        sb.append(node.curr);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        sb.append(node.curr);
        inOrder(node.right);
    }

    public static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.curr);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Node> nodeMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");

            if (!nodeMap.containsKey(str[0])) {
                nodeMap.put(str[0], new Node(str[0]));
            }

            Node currNode = nodeMap.get(str[0]);

            if (!str[1].equals(".") && !nodeMap.containsKey(str[1])) {
                nodeMap.put(str[1], new Node(str[1]));
                currNode.left = nodeMap.get(str[1]);
            }

            if (!str[2].equals(".") && !nodeMap.containsKey(str[2])) {
                nodeMap.put(str[2], new Node(str[2]));
                currNode.right = nodeMap.get(str[2]);
            }
        }

        Node root = nodeMap.get("A");
        preOrder(root);
        sb.append("\n");
        inOrder(root);
        sb.append("\n");
        postOrder(root);
        sb.append("\n");
        System.out.println(sb.toString());
    }
}
