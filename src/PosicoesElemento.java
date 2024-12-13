import java.util.Scanner;

class PosicoesElemento {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());

        String entrada = sc.nextLine();
        String[] partes = entrada.split(" ");
        int[] sequencia = new int[partes.length];

        for (int i = 0; i < partes.length; i++) {
            sequencia[i] = Integer.parseInt(partes[i]);
        }

        String saida = "";
        for (int i = 0; i < sequencia.length; i++) {
            if (sequencia[i] == N) {
                if (i == sequencia.length - 1) {
                    saida += i;
                } else {
                    saida += i + " ";
                }
            }
        }

        if (saida.isEmpty()) {
            saida = "-1";
        }

        System.out.println(saida);
    }
}
