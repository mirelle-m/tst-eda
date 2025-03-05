import java.util.Scanner;

class TrocaVizinhosLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        int indice = Integer.parseInt(sc.nextLine());
        sc.close();

        LinkedList linkedList = new LinkedList();
        for (String valor : entrada)
            linkedList.addLast(Integer.parseInt(valor));

        linkedList.swap(indice);
        System.out.println(linkedList);
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        public LinkedList() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        public boolean isEmpty() {
            return this.head == null;
        }

        public void addLast(int valor) {
            Node newNode = new Node(valor);
            if (isEmpty()) {
                this.head = newNode;
                this.tail = newNode;
            } else {
                this.tail.next = newNode;
                newNode.prev = this.tail;
                this.tail = newNode;
            }
            this.size++;
        }

        private Node getNode(int index) {
            Node aux = this.head;
            for (int i = 0; i < index; i++)
                aux = aux.next;

            return aux;
        }

        public void swap(int index) {
            Node node1 = this.getNode(index);
            Node node2 = this.getNode(index + 1);

            if (node1.prev != null) node1.prev.next = node2;
            if (node2.next != null) node2.next.prev = node1;
            node1.next = node2.next;
            node2.prev = node1.prev;
            node2.next = node1;
            node1.prev = node2;

            if (node2.prev == null) head = node2;
            if (node1.next == null) tail = node1;
        }

        public String toString() {
            if (isEmpty()) return "";

            StringBuilder saida = new StringBuilder();
            Node aux = this.head;
            while (aux != null) {
                saida.append(aux.value);
                saida.append(" ");
                aux = aux.next;
            }

            return saida.toString().trim();
        }
    }

    public static class Node {
        int value;
        Node next;
        Node prev;

        public Node(int v) {
            value = v;
        }
    }
}
