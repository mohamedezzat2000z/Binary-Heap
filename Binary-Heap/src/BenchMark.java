/** BenchMarking Class */
public class BenchMark {

    /**
     * method to generate an array of size n that contains random numbers in range
     * of 500-10000
     * 
     * @param n size of the array to be generated
     * @return array after generation
     */
    public int[] generateArray(int n) {
        int[] arr = new int[n];// declare a new array with size n
        for (int i = 0; i < n; i++) {// for each element in the array
            int random_int = (int) Math.floor(Math.random() * (10000 - 500 + 1) + 500);// generate a random number
            arr[i] = random_int;// save the number in the array
        }
        return arr;// return the array

    }

    /**
     * method that does the comparison between each of the 3 sorting algorithms
     * 
     * @param n size of the array to be benched
     */
    public void bench(int n) {
        binaryHeap heapSortingAlgorithm = new binaryHeap(100);// create a heap object
        bubbleSort bubbleSortingAlgorithm = new bubbleSort();// create a bubble sort object
        mergeSort mergeSortingAlgorithm = new mergeSort();// create a merge sort object
        int[] arr = generateArray(n); // generate the array to be benched
        /** clone the array for each sorting algorithm to sort it */
        int[] arrHeap = arr.clone();
        int[] arrMerge = arr.clone();
        int[] arrBubble = arr.clone();
        /** make arrays to store the results of each iteration */
        long[] timeHeap = new long[14];
        long[] timeMerge = new long[14];
        long[] timeBubble = new long[14];

        for (int i = 0; i < 14; i++) {// for each iteration
            arr = generateArray(n); // generate the array
            /** clone the array for each sorting algorithm to sort it */
            arrHeap = arr.clone();
            arrMerge = arr.clone();
            arrBubble = arr.clone();

            /** calculate the time for Heap sort */
            long startTime = System.nanoTime(); // start time
            heapSortingAlgorithm.sort(arrHeap); // sort
            long endtime = System.nanoTime(); // end time
            timeHeap[i] = endtime - startTime; // get the difference and store it in the time array

            /** calculate the time for Bubble sort */
            startTime = System.nanoTime(); // start time
            bubbleSortingAlgorithm.sort(arrBubble);// sort
            endtime = System.nanoTime();// end time
            timeBubble[i] = endtime - startTime;// get the difference and store it in the time array

            /** calculate the time for Merge sort */
            startTime = System.nanoTime(); // start time
            mergeSortingAlgorithm.sort(arrMerge);// sort
            endtime = System.nanoTime();// end time
            timeMerge[i] = endtime - startTime;// get the difference and store it in the time array

        }
        /** output results after the 10 iterations */
        /** Heap sort time */
        int sum = 0;// declare a sum variable
        System.out.println();
        System.out.println("time for Heap sort n = " + arr.length);
        for (int j = 4; j < 14; j++) {
            sum += timeHeap[j];// calculate the sum of results
            System.out.print(timeHeap[j] + " ");
        }
        System.out.println("average =" + sum / 10);// output the average
        System.out.println();
        System.out.println();

        /** Bubble sort time */
        sum = 0; // reset the sum variable
        System.out.println("time for Bubble sort n = " + arr.length);
        for (int j = 4; j < 14; j++) {
            sum += timeBubble[j];// calculate the sum of results
            System.out.print(timeBubble[j] + " ");
        }
        System.out.println("average =" + sum / 10);// output the average
        System.out.println();
        System.out.println();

        /** Merge sort time */
        sum = 0;// reset the sum variable
        System.out.println("time for Merge sort n = " + arr.length);
        for (int j = 4; j < 14; j++) {
            sum += timeMerge[j];// calculate the sum of results
            System.out.print(timeMerge[j] + " ");
        }
        System.out.println("average =" + sum / 10);// output the average
        System.out.println();

    }
}
