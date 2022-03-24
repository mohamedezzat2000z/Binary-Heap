public class App {
    public static void main(String[] args) throws Exception {
        mergeSort s= new mergeSort();
        int k[]={10,20,5,6,90,3,2,14,35};
        s.sort(k, 0, 9-1);
        for(int i=0;i<9;i++){
            System.out.print(k[i] +" ");
        }
    }
}
