import java.util.Scanner;

class FiltraLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        int valor = Integer.parseInt(sc.nextLine());
        sc.close();

        LinkedList linkedList = new LinkedList();
        for (String elemento : entrada) {
            linkedList.addLast(Integer.parseInt(elemento));
        }

        linkedList.remove(valor);
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
            return this.head == null;
        }

        public void addLast(int valor) {
            Node newNode = new Node(valor);
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

        public void remove(int valor) {
            Node aux = head;
            int i = 0;
            while (i < size) {
                if (aux.value == valor) {
                    if (i == 0) removeFirst();
                    else if (i == size - 1) removeLast();
                    else {
                        aux.next.prev = aux.prev;
                        aux.prev.next = aux.next;

                        size--;
                    }
                } else i++;
                aux = aux.next;
            }
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
