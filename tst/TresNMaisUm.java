import java.util.Scanner;

class TresNMaisUm {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = Integer.parseInt(sc.nextLine());
        int j = Integer.parseInt(sc.nextLine());
        sc.close();

        int tamanhoSeqMaior = 1;
        for (int num = i; num <= j; num++) {
            int N = num;
            int tamanhoSeq = 1;

            while (N != 1) {
                if (N % 2 == 0) N = N / 2;
                else N = (N * 3) + 1;

                tamanhoSeq++;
            }

            if (tamanhoSeq > tamanhoSeqMaior)
                tamanhoSeqMaior = tamanhoSeq;
        }

        System.out.println(tamanhoSeqMaior);
    }
}
