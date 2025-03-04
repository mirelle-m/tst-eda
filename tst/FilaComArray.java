import java.util.Scanner;

class FilaComArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int capacidade = Integer.parseInt(sc.nextLine());
		
		Fila fila = new Fila(capacidade);
		
		while (true) {
			String[] comando = sc.nextLine().split(" ");
			
			if (comando[0].equals("end")) break;
			if (comando[0].equals("add")) {
				if (fila.isFull()) System.out.println("full");
				else fila.add(Integer.parseInt(comando[1]));
			} else if (comando[0].equals("remove")) {
				if (fila.isEmpty()) System.out.println("empty");
				else fila.remove();
			} else if (comando[0].equals("print")) {
				if (fila.isEmpty()) System.out.println("empty");
				else System.out.println(fila.toString());
			} else if (comando[0].equals("element")) {
				if (fila.isEmpty()) System.out.println("empty");
				else System.out.println(fila.getFirst());
			}
		}

		sc.close();
	}
	
	public static class Fila {
		int[] fila;
		int head;
		int tail;
		int size;
		
		public Fila(int capacidade) {
			fila = new int[capacidade];
			head = -1;
			tail = -1;
			size = 0;
		}
		
		public boolean isEmpty() {
			return head == -1 && tail == -1;
		}
		
		public boolean isFull() {
			return (tail + 1) % fila.length == head;
		}
		
		public void add(int elemento) {
			if (isEmpty()) {
				head = 0;
				tail = 0;
			} else {
				tail = (tail + 1) % fila.length;
			}
			
			fila[tail] = elemento;
			size++;
		}
		
		public void remove() {
			if (head == tail) {
				head = -1;
				tail = -1;
			} else {
				head = (head + 1) % fila.length;
			}
			
			size--;
		}
		
		public int getFirst() {
			return fila[head];
		}
		
		public String toString() {			
			StringBuilder saida = new StringBuilder();
	        for (int i = head; i != tail; i = (i + 1) % fila.length) {
	            saida.append(fila[i]);
	            saida.append(" ");
	        }
	        saida.append(fila[tail]);

	        return saida.toString();
		}
	}
}
