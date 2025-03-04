import java.util.Arrays;
import java.util.Scanner;

class TrocaVizinhos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        sc.close();

        System.out.println(Arrays.toString(trocaVizinhos(entrada)));
    }

    public static String[] trocaVizinhos(String[] entrada) {
        if (entrada.length % 2 == 0) {
            for (int i = 0; i < entrada.length; i += 2) {
                String trocado = entrada[i + 1];
                entrada[i + 1] = entrada[i];
                entrada[i] = trocado;
            }
        } else {
            for (int i = 0; i < entrada.length - 1; i += 2) {
                String trocado = entrada[i + 1];
                entrada[i + 1] = entrada[i];
                entrada[i] = trocado;
            }
        }

        return entrada;
    }
}