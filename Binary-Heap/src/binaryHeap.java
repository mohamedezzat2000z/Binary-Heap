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
        int x = nums.length;// get the length of the array
        int i;// sitting a varabile 
        for (i = (x / 2); i >= 0; i--) {// loop over the upper part have of the array from the lowest element
            heapify(nums, i, x);// allocate downward
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

    
    /**
     * delete an element from the heap
     * 
     */
    public void delete() {
        if(size>0){// check if the array has element
        array[0] = array[size - 1];// replace the max elemtn with the smallest
        size--;// decemint the cunter
        heapify(array, 0, size);//alocate the eleemtn dowenward
        }else{
            System.out.println("array is empty");
        }
    }

    /**
     * sort the given array using heap sort
     * @param array array to be sorted
     */
    public void sort(int[] array) {
        bulidMaxHeap(array);// bulid max heap
        int x = array.length;// get the the length of the array
        int i;// set the varablies
        for (i = 1; i < x; i++) {// loop over the etnterd array
            int s = array[0];//get the max element
            array[0] = array[x - i];//replace the first elemetn to the first element
            array[x - i] = s;//but the max element in the last of the array
            heapify(array, 0, x - i);//allocate the elemt down 

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


    /**
     * heapify with preallocate up
     * @param nums the array where the heapify will happens
     * @param s current size of the heap
     * @param k element after insertion
     */
    public void heapify(int[] nums, int k, int len) {

        int hole = k;// get the current place of the element to allocate downfrom this place
        while (hole * 2 + 1 < len) {// check if the node didnt6 reach the root
            int left = hole * 2 + 1;//get the left element
            int right = left + 1;//get the right element
            int target;//set the varabklie for the next target for the element ot go to
            if (right < len && (nums[right] > nums[left])) {// check if the right exist and is larget tha the left next element
                target = right;// the next target right
            } else {
                target = left;// the next targetleft
            }

            if (nums[hole] < nums[target]) {// if the target elemt is biggeer than the 
                //swaping steps
                int s = nums[hole];
                nums[hole] = nums[target];
                nums[target] = s;
                hole = target;//update the postion of the hole

            } else {
                break;// break if the element is larger then its childs
            }
        }
    }
}
