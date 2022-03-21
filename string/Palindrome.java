package string;

public class Palindrome {
    public boolean isPalindrome(String word){
        char[] charArray=word.toCharArray();
        int start =0;
        int end=word.length()-1;
        while(start<end){
            if(charArray[start]!=charArray[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Palindrome palindrome=new Palindrome();
        String word="madam";
        if(palindrome.isPalindrome(word)){
            System.out.println("The string is a palindrome!");
        }
        else{
            System.out.println("The string is not a palindrome!");
        }
        
    }
}
