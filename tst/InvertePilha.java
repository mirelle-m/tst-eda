import java.util.Scanner;

class InvertePilha {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tamanho = Integer.parseInt(sc.nextLine());
		String[] entrada = sc.nextLine().split(" ");
		sc.close();
		
		Pilha pilha = new Pilha(tamanho);
		Fila fila = new Fila(tamanho);
		
		for (String elemento : entrada)
			pilha.push(Integer.parseInt(elemento));
		
		while (!pilha.isEmpty())
			fila.addLast(pilha.pop());
		
		while (!fila.isEmpty())
			pilha.push(fila.removeFirst());
		
		while (!pilha.isEmpty())
			System.out.println(pilha.pop());
	}

	public static class Pilha {
		int[] pilha;
		int topo;
		
		public Pilha(int tamanhoPilha) {
			pilha = new int[tamanhoPilha];
			topo = -1;
		}
		
		public boolean isEmpty() {
			return this.topo == -1;
		}
		
		public void push(int elemento) {
			this.pilha[++topo] = elemento;
		}
		
		public int pop() {
			return this.pilha[topo--];
		}
	}
	
	public static class Fila {
		private int[] fila;
	    private int head;
	    private int tail;
	    
	    public Fila(int capacidadeFila) {
	    	fila = new int[capacidadeFila];
	    	head = -1;
	    	tail = -1;
	    }
	    
	    public boolean isEmpty() {
	        return head == -1 && tail == -1;
	    }
	    
	    public void addLast(int elemento) {
	    	if (isEmpty()) {
	    		head = 0;
	    		tail = 0;
	    	} else {
	            tail = (tail + 1) % fila.length;
	        }
	    	
	    	fila[tail] = elemento;
	    }
	    
	    public int removeFirst() {
	    	int valor = fila[head];
	    	
	    	if (head == tail) {
	    		head = -1;
	    		tail = -1;
	    	} else {
	    		head = (head + 1) % fila.length;
	    	}
	    	
	    	return valor;
	    }
	}
}
