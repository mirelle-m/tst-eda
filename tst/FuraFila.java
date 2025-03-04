import java.util.Arrays;
import java.util.Scanner;

class FuraFila {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] entrada = sc.nextLine().split(" ");
		int indice = Integer.parseInt(sc.nextLine());		
		sc.close();
		
		for (int i = indice; i < entrada.length; i++) {
			for (int j = i; j > i - indice; j--)
				swap(entrada, j, j - 1);
			
			System.out.println(Arrays.toString(entrada));
		}
	
	}
	
	public static void swap(String[] sequencia, int pos1, int pos2) {
		String aux = sequencia[pos1];
		sequencia[pos1] = sequencia[pos2];
		sequencia[pos2] = aux;		
	}
	
}
