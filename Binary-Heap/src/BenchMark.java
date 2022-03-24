public class BenchMark {
    public int[] generateArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int random_int = (int) Math.floor(Math.random() * (10000 - 500 + 1) + 500);
            arr[i] = random_int;
        }
        return arr;

    }

    public void bench() {
        binaryHeap heapSortingAlgorithm = new binaryHeap(100);
        bubbleSort bubbleSortingAlgorithm = new bubbleSort();
        mergeSort mergeSortingAlgorithm = new mergeSort();
        int[] arr = generateArray((int) Math.pow(10, 2));
        int[] arrHeap = arr.clone();
        long[] timeHeap = new long[14];
        int[] arrMerge = arr.clone();
        long[] timeMerge = new long[14];
        int[] arrBubble = arr.clone();
        long[] timeBubble = new long[14];

        for (int i = 0; i < 14; i++) {
            arr = generateArray((int) Math.pow(10, 2));
            arrHeap = arr.clone();
            arrMerge = arr.clone();
            arrBubble = arr.clone();

            long startTime = System.nanoTime();
            heapSortingAlgorithm.sort(arrHeap);
            long endtime = System.nanoTime();
            timeHeap[i] = endtime - startTime;

            startTime = System.nanoTime();
            bubbleSortingAlgorithm.sort(arrBubble);
            endtime = System.nanoTime();
            timeBubble[i] = endtime - startTime;

            startTime = System.nanoTime();
            mergeSortingAlgorithm.sort(arrMerge, 0, arrMerge.length - 1);
            endtime = System.nanoTime();
            timeMerge[i] = endtime - startTime;

        }

        System.out.println();
        System.out.println("time for Heap sort n = " + arr.length);
        for (int j = 4; j < 14; j++) {
            System.out.print(timeHeap[j] + " ");
        }

        System.out.println();

        System.out.println("time for Bubble sort n = " + arr.length);
        for (int j = 4; j < 14; j++) {
            System.out.print(timeBubble[j] + " ");
        }

        System.out.println();

        System.out.println("time for Merge sort n = " + arr.length);
        for (int j = 4; j < 14; j++) {
            System.out.print(timeMerge[j] + " ");
        }

    }
}
