import java.util.Scanner;

class VetorCircular {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        int N = Integer.parseInt(sc.nextLine());
        sc.close();

        System.out.println(circular(entrada, N));
    }

    public static String circular(String[] entrada, int N) {
        String vetor = "";
        for (int i = 0; i < N; i++) {
            int iAtual = i % entrada.length;
            if (i == N - 1) vetor += entrada[iAtual];
            else vetor += entrada[iAtual] + " ";
        }

        return vetor;
    }
}