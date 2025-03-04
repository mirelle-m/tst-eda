import java.util.Scanner;

class EncontraQuebraRecursivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        sc.close();

        System.out.println(encontraQuebra(entrada));
    }

    public static int encontraQuebraRecursivo(String[] entrada, int indice) {
        if (indice < entrada.length) {
            if (Integer.parseInt(entrada[indice]) < Integer.parseInt(entrada[indice - 1]))
                return indice;
            else
                return encontraQuebraRecursivo(entrada, indice + 1);

        }
        return -1;
    }

    public static int encontraQuebra(String[] entrada) {
        return encontraQuebraRecursivo(entrada, 1);
    }
}
