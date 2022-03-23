package list;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryNumbers {
    
    public String[] generateBinaryNumbers(int n){
        String[] result=new String[n];
        Queue<String> q=new LinkedList<>();
        q.offer("1");
        for(int i=0; i<n; i++){
            result[i]=q.poll();
            String n1=result[i]+"0";
            String n2=result[i]+"1";
            q.offer(n1);
            q.offer(n2);
        }
        return result;
    }
    public void print(String[] binaryNumbers){
        for(int i=0; i<binaryNumbers.length; i++){
            System.out.print(binaryNumbers[i]+ ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        GenerateBinaryNumbers gBinaryNumbers=new GenerateBinaryNumbers();
        gBinaryNumbers.print(gBinaryNumbers.generateBinaryNumbers(8));
    }
}
