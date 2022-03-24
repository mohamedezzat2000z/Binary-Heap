public class App {
    public static void main(String[] args) throws Exception {
        /*
         * 
         * int k[] = { 10, 20, 5, 6, 90, 3, 2, 14, 35 };
         * /*
         * for (int i = 0; i < 9; i++) {
         * System.out.println(k[i] + " ");
         * }
         */
        binaryHeap s = new binaryHeap(9);

        for (int i = 0; i < 9; i++) {
            int random_int = (int) Math.floor(Math.random() * (10000 - 0 + 1) + 0);
            System.out.println("after insert");
            s.insert(random_int);
            for (int j = 0; j < 9; j++) {
                System.out.print(s.array[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < 9; i++) {
            s.delete();
            System.out.println("after delete");
            for (int j = 0; j < 9; j++) {
                System.out.print(s.array[j] + " ");
            }
            System.out.println();
        }
    }
    // BenchMark bMark = new BenchMark();
    // bMark.bench();
}
