import java.util.Scanner;

class PosicoesElemento {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String[] entrada = sc.nextLine().split(" ");
        sc.close();

        int[] sequencia = new int[entrada.length];
        for (int i = 0; i < sequencia.length; i++)
            sequencia[i] = Integer.parseInt(entrada[i]);

        String saida = "";
        for (int i = 0; i < sequencia.length; i++) {
            if (sequencia[i] == N)
                saida += i + " ";
        }

        if (saida.equals(""))
            saida = "-1";

        System.out.println(saida.trim());
    }
}