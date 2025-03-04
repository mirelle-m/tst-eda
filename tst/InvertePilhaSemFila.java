import java.util.Scanner;

class InvertePilhaSemFila {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tamanhoPilha = Integer.parseInt(sc.nextLine());
        String[] entrada = sc.nextLine().split(" ");
        
        Pilha pilha = new Pilha(tamanhoPilha);
        Pilha pilhaInvertida = new Pilha(tamanhoPilha);

        int i = 0;
        while (pilha.size() < tamanhoPilha)
            pilha.push(Integer.parseInt(entrada[i++]));

        while (!pilha.isEmpty())
            pilhaInvertida.push(pilha.pop());

        while (!pilhaInvertida.isEmpty())
            System.out.println(pilhaInvertida.pop());

        sc.close();
    }

    public static class Pilha {
        int[] pilha;
        int topo;

        public Pilha (int tamanhoPilha) {
            this.pilha = new int[tamanhoPilha];
            this.topo = -1;
        }

        public void push(int valor) {
            this.pilha[++topo] = valor;
        }

        public int pop() {
            return this.pilha[topo--];
        }

        public boolean isEmpty() {
            return this.topo == -1;
        }

        public int size() {
            return this.topo + 1;
        }
    }
}
