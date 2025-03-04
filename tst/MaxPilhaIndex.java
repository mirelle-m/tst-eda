import java.util.Scanner;

class MaxPilhaIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        int indice = Integer.parseInt(sc.nextLine());
        sc.close();

        Pilha pilha = new Pilha(entrada.length);
        for (String elemento : entrada)
            pilha.push(Integer.parseInt(elemento));

        Pilha pilhaAux = new Pilha(indice + 1);
        for (int i = 0; i <= indice; i++)
            pilhaAux.push(pilha.pop());

        int maior = pilhaAux.topo;
        for (int i = 0; i <= indice; i++) {
            int elemento = pilhaAux.pop();
            if (maior < elemento) maior = elemento;
        }

        System.out.println(maior);
    }

    public static class Pilha {
        int[] pilha;
        int topo;

        public Pilha(int tamanho) {
            pilha = new int[tamanho];
            topo = -1;
        }

        public void push(int valor) {
            pilha[++topo] = valor;
        }

        public int pop() {
            return pilha[topo--];
        }
    }
}
