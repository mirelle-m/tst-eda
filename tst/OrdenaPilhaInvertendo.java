import java.util.Scanner;

class OrdenaPilhaInvertendo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tamanho = Integer.parseInt(sc.nextLine());
        String[] entrada = sc.nextLine().split(" ");
        sc.close();

        Pilha pilha = new Pilha(tamanho); // cria a pilha com os elementos da entrada
        for (String elemento : entrada) {
            pilha.push(Integer.parseInt(elemento));
        }

        Pilha pilhaOrdenada = new Pilha(tamanho);
        // procura o maior elemento, adiciona numa pilha auxiliar e remove da original até que ela esteja vazia e a auxiliar esteja completa de forma já ordenada
        while (!pilha.isEmpty()) {
            int maxElement = pilha.getMax(pilha.size() - 1); // encontra o maior elemento
            pilhaOrdenada.push(maxElement); // adiciona o maior elemento na pilha ordenada

            Pilha temp = new Pilha(tamanho);
            while (!pilha.isEmpty() && pilha.peek() != maxElement) // armazena temporariamente os elementos da pilha original até que o maior elemento seja encontrado
                temp.push(pilha.pop());
            pilha.pop(); // remove o maior elemento da pilha original
            while (!temp.isEmpty()) // devolve os outros elementos para a pilha original
                pilha.push(temp.pop());
        }

        System.out.println("-");
        while (!pilhaOrdenada.isEmpty())
            System.out.println(pilhaOrdenada.pop());
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

        public int peek() {
            return pilha[topo];
        }

        public void push(int elemento) {
            pilha[++topo] = elemento;
        }

        public int pop() {
            return pilha[topo--];
        }

        public int size() {
            return this.topo + 1;
        }

        public int getMax(int index) {
            Pilha aux = new Pilha(index + 1);
            int max = Integer.MIN_VALUE;

            for (int i = 0; i <= index; i++) {
                int numero = this.pop();
                if (numero > max) {
                    max = numero;
                }
                aux.push(numero);
            }

            while (!aux.isEmpty())
                push(aux.pop());
            
            return max;
        }
    }
}
