import java.util.Scanner;

class MoveTres {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] entrada = sc.nextLine().split(" ");

        System.out.println(moveTres(entrada));
    }

    public static String moveTres(String[] entrada) {
        int umI = -1;
        for (int i = 0; i < entrada.length - 1; i++) {
            if(Integer.parseInt(entrada[i]) > Integer.parseInt(entrada[i + 1])) {
                um = i + 1;
                break;
            }
        }

        int um = Integer.parseInt(entrada[umI]);
        for (int j = umI; j > 0 && Integer.parseInt(entrada[j - 1]) > um; j--) {
            entrada[j] = entrada[j - 1];
            um = j - 1;
        }

        Integer.parseInt(entrada[umI]) = um;
    }
}
