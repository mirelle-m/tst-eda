import java.util.Scanner;

class EncontraPrimeiroNegativoRecursivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        sc.close();

        System.out.println(iniciaPrimeiroNegativoRecursivo(entrada));
    }

    public static String primeiroNegativoRecursivo(String[] seq, int i) {
        if (i < seq.length) {
            if (Integer.parseInt(seq[i]) < 0)
                return seq[i];
            else
                return primeiroNegativoRecursivo(seq, i + 1);
        }
        return "-";
    }

    public static String iniciaPrimeiroNegativoRecursivo(String[] seq) {
        return primeiroNegativoRecursivo(seq, 0);
    }
}
