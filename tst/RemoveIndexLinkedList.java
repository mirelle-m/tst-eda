import java.util.Scanner;

class RemoveIndexLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        int index = Integer.parseInt(sc.nextLine());
        sc.close();

        LinkedList linkedList = new LinkedList();
        for (String elemento : entrada) {
            linkedList.addLast(Integer.parseInt(elemento));
        }

        linkedList.remove(index);
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

        public void remove(int index) {
            if (index == 0) removeFirst();
            else if (index == size - 1) removeLast();
            else {
                Node aux = head;
                for (int i = 0; i < index; i++) {
                    aux = aux.next;
                }

                aux.prev.next = aux.next;
                aux.next.prev = aux.prev;
                size--;
            }
        }

        public String toString() {
            if (isEmpty()) return "";

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
