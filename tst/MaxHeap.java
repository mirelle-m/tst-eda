import java.util.Scanner;

class MaxHeap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");

        Heap heap = new Heap(entrada.length);
        for (String s : entrada) {
            heap.add(Integer.parseInt(s));
        }

        System.out.println(heap.isMaxHeap());
    }

    public static class Heap {
        int[] heap;
        int tail;

        public Heap(int capacidade) {
            heap = new int[capacidade];
            tail = -1;
        }

        public int left(int i) {
            return 2 * i + 1;
        }

        public int right(int i) {
            return 2 * (i + 1);
        }

        public void add(int valor) {
            tail++;
            heap[tail] = valor;
        }

        public boolean isMaxHeap() {
            for (int i = 0; i <= (tail - 1) / 2; i++) {
                if (left(i) <= tail && heap[i] < heap[left(i)])
                    return false;
                if (right(i) <= tail && heap[i] < heap[right(i)])
                    return false;
            }

            return true;
        }
    }
}
