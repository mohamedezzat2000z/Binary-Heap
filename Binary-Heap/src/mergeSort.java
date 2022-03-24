public class mergeSort {
    /*
     * public void sort(int arr[]) {
     * sort(arr, 0, arr.length - 1);
     * }
     */

    public void sort(int arr[], int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            sort(arr, start, mid);
            sort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    void merge(int arr[], int low, int mid, int high) {
        int i, l, r, k;
        int[] temp = new int[arr.length];
        l = low;
        r = mid + 1;
        i = low;

        while ((l <= mid) && (r <= high)) {
            if (arr[l] <= arr[r]) {
                temp[i] = arr[l];
                l++;
            } else {
                temp[i] = arr[r];
                r++;
            }
            i++;
        }

        if (l > mid) {
            for (k = r; k <= high; k++) {
                temp[i] = arr[k];
                i++;
            }
        } else {
            for (k = l; k <= mid; k++) {
                temp[i] = arr[k];
                i++;
            }
        }
        for (k = low; k <= high; k++) {
            arr[k] = temp[k];
        }
    }

}
