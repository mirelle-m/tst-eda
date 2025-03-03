import java.util.Scanner;

class FilaLinkedList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Fila fila = new Fila();
		
		while (true) {
			String[] comando = sc.nextLine().split(" ");
			
			if (comando[0].equals("end")) break;
			if (comando[0].equals("add")) {
				fila.add(Integer.parseInt(comando[1]));
			} else if (comando[0].equals("remove")) {
				if (fila.isEmpty()) System.out.println("empty");
				else fila.remove();
			} else if (comando[0].equals("print")) {
				if (fila.isEmpty()) System.out.println("empty");
				else System.out.println(fila.print());
			} else if (comando[0].equals("element")) {
				if (fila.isEmpty()) System.out.println("empty");
				else System.out.println(fila.element());
			} else if (comando[0].equals("search")) {
				System.out.println(fila.search(Integer.parseInt(comando[1])));
			}
		}

		sc.close();
	}

	public static class Fila {
		Node head;
		
		public Fila() {
			head = null;
		}
		
		public boolean isEmpty() {
			return head == null;
		}
		
		public void add(int elemento) {
			if (isEmpty()) head = new Node(elemento);
			else addRecursivo(head, elemento);
		}
		
		public void addRecursivo(Node nodeAtual, int elemento) {
			if (nodeAtual.next == null) {
				Node newNode = new Node(elemento);
				nodeAtual.next = newNode;
				newNode.prev = nodeAtual;
			} else addRecursivo(nodeAtual.next, elemento);
		}
		
		public int remove() {
			int elemento = element();
			
			head = head.next;
			if (head != null) head.prev = null;
			
			return elemento;
		}
		
		public String print() {			
			return printRecursivo(head).trim();
		}
		
		public String printRecursivo(Node nodeAtual) {
			if (nodeAtual == null) return "";
			if (nodeAtual.next == null) return String.valueOf(head.value);
			
			return nodeAtual.value + " " + printRecursivo(nodeAtual.next).trim();
		}
		
		public int element() {
			return head.value;
		}
		
		public int search(int elemento) {
			return searchRecursivo(head, elemento, 0);
		}
		
		public int searchRecursivo(Node nodeAtual, int elemento, int index) {
			if (nodeAtual != null) {
				if (nodeAtual.value == elemento) return index;
				return searchRecursivo(nodeAtual.next, elemento, index++);
			}
			
			return -1;
		}
	}	

	public static class Node {	
	    int value;
	    Node prev;
	    Node next;
	
	    Node(int v) {
	        value = v;
	    }
	
	}
}
