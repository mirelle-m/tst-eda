import java.util.Scanner;

public class Rotacoes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");


    }

    public static class AVL {
        private Node root;
        private int size;

        public AVL() {
            this.size = -1;
        }

        public boolean isEmpty() {
            return this.root == null;
        }

        public void add(int element) {
            this.size += 1;
            if (isEmpty()) this.root = new Node(element);
            else {
                Node aux = this.root;
                while (aux != null) {
                    if (element < aux.value) {
                        if (aux.left == null) {
                            Node newNode = new Node(element);
                            aux.left = newNode;
                            newNode.parent = aux;

                            Node desbalanceado = checkBalance(newNode);
                            if (desbalanceado != null) callBestRotation(desbalanceado);
                            return;
                        }
                        aux = aux.left;
                    } else {
                        if (aux.right == null) {
                            Node newNode = new Node(element);
                            aux.right = newNode;
                            newNode.parent = aux;

                            Node desbalanceado = checkBalance(newNode);
                            if (desbalanceado != null) callBestRotation(desbalanceado);
                            return;
                        }
                        aux = aux.right;
                    }
                }
            }
        }

        public Node checkBalance(Node node) {
            Node aux = node;
            while (aux != null) {
                if (!aux.isBalanced()) {
                    return aux;
                } else if (aux.parent != null) {
                    aux = aux.parent;
                } else {
                    break;
                }
            }
            return null;
        }
    }

    public static class Node {
        private int value;
        Node left;
        Node right;
        Node parent;

        public Node(int v) {
            this.value = v;
        }
    }
}
