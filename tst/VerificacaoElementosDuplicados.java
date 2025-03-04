import java.util.Scanner;

class VerificacaoElementosDuplicados {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] sequencia = sc.nextLine().split(" ");
        sc.close();

        boolean duplicado = false;
        for (int i = 0; i < sequencia.length; i++) {
            for (int j = i + 1; j < sequencia.length; j++) {
                if (sequencia[i].equals(sequencia[j]))
                    duplicado = true;
            }
        }

        System.out.println(duplicado);
    }
}