public class binaryHeap {

    public int[] array;
    private int size = 0;

    public binaryHeap(int size) {
        array = new int[size];
    }

    public void bulidMaxHeap(int[] nums) {
        int x = nums.length;
        int i;
        for (i = (x / 2); i >= 0; i--) {
            heapify(nums, i, x);
        }
    }

    public void insert(int o) {
        try {
            array[size] = o;
            heapify(size, o);
            size++;
        } catch (Exception e) {
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

    private void heapify(int s, int k) {
        while ((s > 0) && (k > array[s / 2])) {
            int temp = array[s];
            array[s] = array[s / 2];
            array[s / 2] = temp;
            s /= 2;
        }
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
