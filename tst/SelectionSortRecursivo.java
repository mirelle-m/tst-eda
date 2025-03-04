import java.util.Arrays;
import java.util.Scanner;

class SelectionSortRecursivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        sc.close();

        int[] sequencia = new int[entrada.length];
        for (int i = 0; i < entrada.length; i++)
            sequencia[i] = Integer.parseInt(entrada[i]);

        selectionSortRecursivo(sequencia, 0);
    }

    public static void selectionSortRecursivo(int[] array, int index) {
        if (index >= array.length - 1) return;

        int i_menor = index;
        for (int j = index + 1; j < array.length; j++) {
            if (array[j] < array[i_menor])
                i_menor = j;
        }
        if (i_menor != index) {
            int aux = array[index];
            array[index] = array[i_menor];
            array[i_menor] = aux;

        }

        System.out.println(Arrays.toString(array));
        selectionSortRecursivo(array, index + 1);
    }
}
