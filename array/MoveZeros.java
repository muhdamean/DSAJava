package array;

public class MoveZeros {
    public static void printArray(int[] arr){
        int n=arr.length;
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    //move zeroes to end of array
    public static int[] moveZeros(int[] arr, int n){
        int j=0;
        for(int i=0; i<n; i++){
            if(arr[i]!=0 && arr[j]==0){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
            if(arr[j]!=0){
                j++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr={3,2,0,7,0,6,5};

        printArray(arr);
        moveZeros(arr, arr.length);
        printArray(arr);
    }
}
