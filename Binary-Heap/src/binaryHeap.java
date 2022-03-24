public class binaryHeap {

    private int[] array;

  /*  public binaryHeap(int[] o) {
        this.array = o;
    }*/

    public void bulidMaxHeap(int[] nums){
        int x=nums.length;
        int i;
        for(i=(x/2); i>=0 ;i--){
            heapify(nums,i,x);
        }
    }

    public void insert(Object o) {

    }

    public void delete(Object o) {
        int x=array.length;
            int s=array[0];
            array[0]=array[x-1];
            array[x-1]=s;
            
            heapify(array,0,x-1);
    }

    public void sort(int[] array) {
        bulidMaxHeap(array);
        int x=array.length;
        int i;
        for(i=1;i<x;i++){
            int s=array[0];
            array[0]=array[x-i];
            array[x-i]=s;
            
            heapify(array,0,x-i);
          
      }


    }

    public void heapify(int[] nums, int k,int len) {

        int hole =k;
        while(hole*2+1<len){
            int left =hole*2+1;
            int right =left+1;
            int target;
            if(right<len && (nums[right]>nums[left])){
                target=right;
            }else{
                target=left;
            }
            
            if (nums[hole]<nums[target]){
                int s=nums[hole];
                nums[hole]=nums[target];
                nums[target]=s;
                hole=target;
             
            }else{
                break;
            }
         }
    }
}
