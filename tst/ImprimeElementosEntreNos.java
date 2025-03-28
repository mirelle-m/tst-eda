import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// não está no tst
// imprime os elementos que estão entre dois nós
public class ImprimeElementosEntreNos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        int n = Integer.parseInt(sc.nextLine());
        int m = Integer.parseInt(sc.nextLine());

        BST bst = new BST();
        for (String s : entrada) {
            bst.add(Integer.parseInt(s));
        }

        Node a = bst.search(n);
        Node b = bst.search(m);
        System.out.println(bst.printEntreNos(a, b));
    }

    public static class BST {
        Node root;

        public BST() {
            root = null;
        }

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

        public Node search(int element) {
            Node aux = root;
            while (aux != null) {
                if (element == aux.value) return aux;
                if (element < aux.value) aux = aux.left;
                if (element > aux.value) aux = aux.right;
            }
            return null;
        }

        public List<Integer> printEntreNos(Node a, Node b) {
           List<Integer> caminho = new ArrayList<>();
           printEntreNos(root, a, b, caminho);
           return caminho;
        }

        public void printEntreNos(Node root, Node a, Node b, List<Integer> caminho) {
            // se incluir os dois nós
            if (root == null) return;
            if (root.value >= a.value)
                printEntreNos(root.left, a, b, caminho);
            if (root.value >= a.value && root.value <= b.value)
                caminho.add(root.value);
            if (root.value <= b.value)
                printEntreNos(root.right, a, b, caminho);

            // se não incluir
            /* if (root == null) return;
            if (root.value > a.value)
                printEntreNos(root.left, a, b, caminho);
            if (root.value > a.value && root.value < b.value)
                caminho.add(root.value);
            if (root.value < b.value)
                printEntreNos(root.right, a, b, caminho);
            */
        }
    }

    public static class Node {
        int value;
        Node left;
        Node right;
        Node parent;

        public Node(int v) {
            this.value = v;
        }
    }
}
