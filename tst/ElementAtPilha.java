import java.util.Scanner;

class ElementAtPilha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        int indice = Integer.parseInt(sc.nextLine());
        sc.close();

        if (indice < 0 || indice >= entrada.length) {
            System.out.println("indice invalido");
            return;
        }

        Pilha pilhaAuxiliar = new Pilha(entrada.length);
        Pilha pilha = new Pilha(entrada.length);

        for (String elemento : entrada)
            pilhaAuxiliar.push(Integer.parseInt(elemento));

        while (!pilhaAuxiliar.isEmpty())
            pilha.push(pilhaAuxiliar.pop());

        for (int j = 0; j < indice && !pilha.isEmpty(); j++)
            pilha.pop();

        System.out.println(pilha.peek());
    }

    public static class Pilha {
        int[] pilha;
        int topo;

        public Pilha(int tamanhoPilha) {
            pilha = new int[tamanhoPilha];
            topo = -1;
        }

        public void push(int elemento) {
            if (topo + 1 < pilha.length)
                pilha[++topo] = elemento;
        }

        public int pop() {
            return pilha[topo--];
        }

        public boolean isEmpty() {
            return topo == -1;
        }

        public int peek() {
        	return pilha[topo];
        }
    }
}