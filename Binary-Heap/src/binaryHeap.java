/** Heap Class */
public class binaryHeap {

    /** Variables stored in heap */
    public int[] array; // array's heap
    private int size = 0; // number of elements in the heap

    /**
     * Constructor
     * 
     * @param size max size of the heap
     */
    public binaryHeap(int size) {
        array = new int[size];
    }

    /**
     * Build max heap method
     * 
     * @param nums array to build from
     */
    public void bulidMaxHeap(int[] nums) {
        int x = nums.length;
        int i;
        for (i = (x / 2); i >= 0; i--) {
            heapify(nums, i, x);
        }
    }

    /**
     * inserts an element inside the heap
     * 
     * @param o element to be inserted
     */
    public void insert(int o) {
        try {
            array[size] = o;// insert in the leaf
            heapify(size, o);// preallocate up
            size++;// increment the size
        } catch (Exception e) {// if there is an exception (array out of bounds)
            e.printStackTrace();
        }
    }

    public void delete() {
        int x = array.length;
        int s = array[0];
        array[0] = array[x - 1];
        array[x - 1] = s;
        size--;
        heapify(array, 0, x - 1);
    }

    public void sort(int[] array) {
        bulidMaxHeap(array);
        int x = array.length;
        int i;
        for (i = 1; i < x; i++) {
            int s = array[0];
            array[0] = array[x - i];
            array[x - i] = s;

            heapify(array, 0, x - i);

        }

    }

    /**
     * heapify with preallocate up
     * 
     * @param s current size of the heap
     * @param k element after insertion
     */
    private void heapify(int s, int k) {
        while ((s > 0) && (k > array[s / 2])) {// compare the element with its parent
            // if bigger switch with its parent
            int temp = array[s];
            array[s] = array[s / 2];
            array[s / 2] = temp;
            // update the array pointer to check for the next parent comparison
            s /= 2;
        }
        // if not do nothing
    }

    public void heapify(int[] nums, int k, int len) {

        int hole = k;
        while (hole * 2 + 1 < len) {
            int left = hole * 2 + 1;
            int right = left + 1;
            int target;
            if (right < len && (nums[right] > nums[left])) {
                target = right;
            } else {
                target = left;
            }

            if (nums[hole] < nums[target]) {
                int s = nums[hole];
                nums[hole] = nums[target];
                nums[target] = s;
                hole = target;

            } else {
                break;
            }
        }
    }
}
