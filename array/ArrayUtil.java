package array;

public class ArrayUtil {
    
    public static void printArray(int[] arr){
        int n=arr.length;
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    //remove even integers from array
    public static int[] removeEven(int[] arr){
        int oddCount=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]%2 !=0){
                oddCount++;
            }
        }
        int[] result =new int[oddCount];
        int idx=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]%2!=0){
                result[idx]=arr[i];
                idx++;
            }
        }
        return result;
    }

    //reverse array
    public static void reverse(int[] arr, int start, int end){
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }

    }
    
    //reverse array
    public static int[] reverseArray(int[] arr){
        int start=0;
        int end=arr.length-1;
        while(start<end){
            
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
       return arr;
    }

    //find min value
    public static int findMinimun(int[] arr){
        int min=arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i]<min){
                min=arr[i];
            }
        }
        return min;
    }

    //find second max value
    public static int findSecondMax(int[] arr){
        int max=Integer.MIN_VALUE;
        int secondMax=Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>max){
                secondMax=max;
                max=arr[i];
            }
            else if(arr[i]>secondMax && arr[i]!=max){
                secondMax=arr[i];
            }
        }
        return secondMax;
    }

    //move zeroes to end of array
    public static void moveZeros(int[] arr, int n){
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
    }

    public static void main(String[] args) {
        int[] arr={3,2,4,7,0,6,5};

        printArray(arr);
        //int[] newArr=removeEven(arr);
        //printArray(newArr);

        //reverse(arr,0, arr.length-1);
        //printArray(arr);

        //int[] newArray=reverseArray(arr);
        //printArray(newArray);
        
        int minValue=findMinimun(arr);
        System.out.println(minValue);

        System.out.println(findSecondMax(arr));

        moveZeros(arr, arr.length);
        printArray(arr);
    }
}
