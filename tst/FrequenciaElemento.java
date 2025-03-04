import java.util.Scanner;

class FrequenciaElemento {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String dados[] = sc.nextLine().split(" ");
        sc.close();

        int frequencia = 0;
        for (int i = 0; i < dados.length; i++) {
            if (dados[i].equals(Integer.toString(n)))
                frequencia++;
        }

        System.out.println(frequencia);
    }
}