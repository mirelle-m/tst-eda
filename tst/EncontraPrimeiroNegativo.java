import java.util.Scanner;

class EncontraPrimeiroNegativo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        sc.close();

        System.out.println(encontraPrimeiroNegativo(entrada));
    }

    public static String encontraPrimeiroNegativo(String[] entrada) {
        for (int i = 0; i < entrada.length; i++) {
            if (Integer.parseInt(entrada[i]) < 0)
                return entrada[i];
        }

        return "-";
    }
}
