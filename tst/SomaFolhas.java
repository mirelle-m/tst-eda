import java.util.Scanner;

class SomaFolhas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");

        BFS bfs = new BFS();
        for (String s : entrada) {
            bfs.add(Integer.parseInt(s));
        }

        System.out.println(bfs.somaFolhas());
    }

    public static class BFS {
        Node root;

        public BFS() {
            root = null;
        }

        public boolean isEmpty() {
            return root == null;
        }

        public void add(int element) {
            if (isEmpty()) {
                root = new Node(element);
            } else {
                Node current = root;
                while (current != null) {
                    if (current.value < element) {
                        if (current.left == null) {
                            Node newNode = new Node(element);
                            current.left = newNode;
                            newNode.parent = current;
                            return;
                        }
                        current = current.left;
                    } else {
                        if (current.right == null) {
                            Node newNode = new Node(element);
                            current.right = newNode;
                            newNode.parent = current;
                            return;
                        }
                        current = current.right;
                    }
                }
            }
        }

        public int somaFolhas() {
            if (isEmpty()) return 0;
            else return somaFolhas(root);
        }

        public int somaFolhas(Node node) {
            if (node == null) return 0;
            if (node.isLeaf()) return node.value;
            return somaFolhas(node.left) + somaFolhas(node.right);
        }
    }

    public static class Node {
        int value;
        Node left;
        Node right;
        Node parent;

        public Node(int v) {
            value = v;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }
    }
}
