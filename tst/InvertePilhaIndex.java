import java.util.Scanner;

class InvertePilhaIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tamanho = Integer.parseInt(sc.nextLine());
        String[] entrada = sc.nextLine().split(" ");
        int index = Integer.parseInt(sc.nextLine());
        sc.close();

        Pilha pilha = new Pilha(tamanho);
        for (String elemento : entrada)
            pilha.push(Integer.parseInt(elemento));

        Pilha aux = new Pilha(index + 1);
        for (int i = 0; i <= index; i++)
            aux.push(pilha.pop());

        Pilha auxInvertida = new Pilha(index + 1);
        while (!aux.isEmpty())
            auxInvertida.push(aux.pop());

        while (!auxInvertida.isEmpty())
            pilha.push(auxInvertida.pop());

        System.out.println("-");
        while (!pilha.isEmpty())
            System.out.println(pilha.pop());
    }

    public static class Pilha {
        int[] pilha;
        int topo;

        public Pilha(int tamanho) {
            pilha = new int[tamanho];
            topo = -1;
        }

        public boolean isEmpty() {
            return topo == -1;
        }

        public void push(int elemento) {
            pilha[++topo] = elemento;
        }

        public int pop() {
            return pilha[topo--];
        }
    }
}