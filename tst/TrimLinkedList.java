import java.util.Scanner;

class TrimLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        int qtd = Integer.parseInt(sc.nextLine());
        sc.close();

        LinkedList linkedList = new LinkedList();
        for (String elemento : entrada) {
            linkedList.addLast(Integer.parseInt(elemento));
        }

        while (qtd-- > 0 && !linkedList.isEmpty()) {
            linkedList.removeFirst();
            if (!linkedList.isEmpty()) linkedList.removeLast();
        }

        System.out.println(linkedList);
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        public LinkedList() {
            head = null;
            tail = null;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void addLast(int elemento) {
            Node newNode = new Node(elemento);
            if (isEmpty()) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
            size++;
        }

        public void removeFirst() {
            if (head.next == null) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            size--;
        }

        public void removeLast() {
            if (head.next == null) {
                head = null;
                tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
            size--;
        }

        public String toString() {
            if (isEmpty()) return "vazia";

            StringBuilder saida = new StringBuilder();
            Node aux = head;
            while (aux != null) {
                saida.append(aux.value + " ");
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
