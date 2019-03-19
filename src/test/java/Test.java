/**
 * @author panda
 * @date 2019-03-12 10:07
 */
public class Test {
    public static void buddleSort(int[] n) {
        for (int i = 1; i < n.length; i++) {
            for (int j = 0; j < n.length - i; j++) {
                if (n[j] > n[j + 1]) {
                    int temp = n[j + 1];
                    n[j + 1] = n[j];
                    n[j] = temp;
                }
            }
        }
        for (int a : n) {
            System.out.print(a + ",");
        }
    }

    public static void binaryInsertionSort(int n[]){
        for (int i=1;i<n.length;i++){
            int low=0,high=i-1;
            int temp=n[i];
            while (high>=low){
                int mid=(high+low)/2;
                if (n[mid]>temp){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
            for (int j=i;j>low;j--){
                n[j]=n[j-1];
            }
            n[low]=temp;
        }
        for (int a : n) {
            System.out.print(a + ",");
        }
    }

    public static void main(String[] args) {
        int n[] = {5, 8, 4, 1, 2, 3, 6, 9, 15};
        binaryInsertionSort(n);
    }
}
