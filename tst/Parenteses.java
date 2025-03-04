import java.util.Scanner;

class Parenteses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] parenteses = sc.nextLine().split("");
        sc.close();

        Pilha pilha = new Pilha(parenteses.length);
        for (String parentese : parenteses) {
            if (parentese.equals("(")) pilha.push(parentese);
            else {
                if (pilha.isEmpty()) {
                    System.out.println("N");
                    return;
                } else pilha.pop();
            }
        }

        if (pilha.isEmpty()) System.out.println("S");
        else System.out.println("N");
    }

    public static class Pilha {
        String[] pilha;
        int topo;

        public Pilha(int capacidade) {
            pilha = new String[capacidade];
            topo = -1;
        }

        public boolean isEmpty() {
            return topo == -1;
        }

        public void push(String parentese) {
            pilha[++topo] = parentese;
        }

        public String pop() {
            return pilha[topo--];
        }
    }
}
