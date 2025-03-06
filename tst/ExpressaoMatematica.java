import java.util.Scanner;

class ExpressaoMatematica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] expressao = sc.nextLine().split("");
        sc.close();

        Pilha numeros = new Pilha(expressao.length);
        Pilha operadores = new Pilha(expressao.length);

        for (String elemento : expressao) {
            if (elemento.matches("\\d")) { // se for um número
                numeros.push(elemento);
            } else if (elemento.equals("(")) {
                operadores.push(elemento);
            } else if (elemento.equals(")")) {
                while (!operadores.isEmpty() && !operadores.peek().equals("(")) {
                    int a = Integer.parseInt(numeros.pop());
                    int b = Integer.parseInt(numeros.pop());
                    numeros.push(String.valueOf(calcularPilha(b, a, operadores.pop())));
                }
                operadores.pop(); // remove o '(' da pilha
            } else if (elemento.equals("+") || elemento.equals("-") || elemento.equals("*") || elemento.equals("/")) {
                while (!operadores.isEmpty() && precedencia(operadores.peek()) >= precedencia(elemento)) {
                    int a = Integer.parseInt(numeros.pop());
                    int b = Integer.parseInt(numeros.pop());
                    numeros.push(String.valueOf(calcularPilha(b, a, operadores.pop())));
                }
                operadores.push(elemento);
            }
        }

        while (!operadores.isEmpty()) {
            int a = Integer.parseInt(numeros.pop());
            int b = Integer.parseInt(numeros.pop());
            numeros.push(String.valueOf(calcularPilha(b, a, operadores.pop())));
        }

        System.out.println(numeros.pop());
    }

    private static int calcularPilha(int num1, int num2, String operador) {
        if (operador.equals("+")) return num1 + num2;
        else if (operador.equals("-")) return num1 - num2;
        else if (operador.equals("*")) return num1 * num2;
        else return num1 / num2;
    }

    private static int precedencia(String operador) {
        if (operador.equals("+") || operador.equals("-")) return 1;
        if (operador.equals("*") || operador.equals("/")) return 2;
        return 0;
    }

    public static class Pilha {
        String[] pilha;
        int topo;

        public Pilha(int tamanho) {
            pilha = new String[tamanho];
            topo = -1;
        }

        public boolean isEmpty() {
            return topo == -1;
        }

        public void push(String elemento) {
            pilha[++topo] = elemento;
        }

        public String pop() {
            return pilha[topo--];
        }

        public String peek() {
            return pilha[topo];
        }
    }
}
