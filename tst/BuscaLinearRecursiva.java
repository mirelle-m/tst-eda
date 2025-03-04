import java.util.Scanner;

class BuscaLinearRecursiva {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        int n = Integer.parseInt(sc.nextLine());
        sc.close();

        System.out.println(buscaLinearRecursiva(entrada, n, 0));
    }

    public static int buscaLinearRecursiva(String[] entrada, int n, int index) {
        if (index >= entrada.length) return -1;
        if (Integer.parseInt(entrada[index]) == n) return index;

        return buscaLinearRecursiva(entrada, n, index + 1);
    }
}