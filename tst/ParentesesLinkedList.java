import java.util.Scanner;

// maneira alternativa de resolver a questão Parênteses usando LinkedList
class ParentesesLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] parenteses = sc.nextLine().split("");
        sc.close();

        Pilha pilha = new Pilha();
        for (String parentese: parenteses) {
            if (parentese.equals("(")) pilha.push(parentese);
            else {
                if (pilha.isEmpty()) {
                    System.out.println("N");
                    return;
                } else pilha.pop();
            }
        }

        if (pilha.isEmpty()) System.out.println("S");
        else System.out.println("N");
    }

    public static class Pilha {
        Node topo;

        public Pilha() {
            topo = null;
        }

        public boolean isEmpty() {
            return topo == null;
        }

        public void push(String parentese) {
            if (isEmpty()) topo = new Node(parentese);
            else {
                Node newNode = new Node(parentese);
                newNode.next = topo;
                topo.prev = newNode;
                topo = newNode;
            }
        }

        public void pop() {
            topo = topo.next;
            if (topo != null) topo.prev = null;
        }
    }

    public static class Node {
        String value;
        Node next;
        Node prev;

        public Node(String v) {
            value = v;
        }
    }
}
