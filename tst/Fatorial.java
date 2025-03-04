import java.util.Scanner;

class Fatorial {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int N = Integer.parseInt(sc.nextLine());
      sc.close();

      System.out.println(fatorial(N));
    }

    public static int fatorial(int n) {
        if(n == 1 || n == 0) return 1;
        else return n * fatorial(n - 1);
    }
}
