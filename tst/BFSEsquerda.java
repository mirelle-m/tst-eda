import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class BFSEsquerda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");

        BFS bfs = new BFS();
        for (String s : entrada) {
            bfs.add(Integer.parseInt(s));
        }

        System.out.println(bfs.printBFS());
    }

    public static class BFS {
        Node root;

        public boolean isEmpty() {
            return root == null;
        }

        public void add(int element) {
            if (isEmpty()) root = new Node(element);
            else {
                Node current = root;
                while (current != null) {
                    if (element < current.value) {
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

        public String printBFS() {
            Deque<Node> fila = new LinkedList<>();
            StringBuilder saida = new StringBuilder();

            if (!isEmpty()) {
                fila.addLast(root);
                while (!fila.isEmpty()) {
                    Node current = fila.removeFirst();
                    saida.append(current.value).append(" ");

                    if (current.left != null) fila.addLast(current.left);
                    if (current.right != null) fila.addLast(current.right);
                }
            }

            return saida.toString().trim();
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
    }
}
