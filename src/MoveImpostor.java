import java.util.Arrays;
import java.util.Scanner;

class MoveImpostor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String entrada = sc.nextLine();
        String[] partes = entrada.split(" ");
        int[] sequencia = new int[partes.length];

        for (int i = 0; i < partes.length; i++) {
            sequencia[i] = Integer.parseInt(partes[i]);
        }

        System.out.println(Arrays.toString(moveImpostor(sequencia)));
    }

    public static int[] moveImpostor(int[] in) {
        int impostorI = -1;
        for(int i = 1; i < in.length; i++) {
            if(in[i] < in[i - 1]) {
                impostorI = i;
                break;
            }
        }

        int impostor = in[impostorI];
        for(int j = impostorI; j > 0 && in[j - 1] > impostor; j--) {
            in[j] = in[j - 1];
            impostorI = j - 1;
        }

        in[impostorI] = impostor;
        return in;
    }
}