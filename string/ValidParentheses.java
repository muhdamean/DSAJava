package string;

import java.util.Stack;

public class ValidParentheses {
    private boolean isValid(String s){
        Stack<Character> stack=new Stack<>();
        for(char c : s.toCharArray()){
            if(c=='(' || c== '{' || c=='['){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }else{
                    char top=stack.peek();
                    if((c==')' && top=='(') || (c=='}' && top=='{') || (c==']' && top=='[')) {
                        stack.pop();
                    }else{
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses=new ValidParentheses();

        String test1="[()}";
        String test2="[()]";
        String test3="{(})";
        //test case 1
        System.out.println("Test case 1 : "+test1);
        System.out.println("Is Valid: "+validParentheses.isValid(test1));
        //test case 2
        System.out.println("Test case 2 : "+test2);
        System.out.println("Is Valid: "+validParentheses.isValid(test2));
        //test case 3
        System.out.println("Test case 3 : "+test3);
        System.out.println("Is Valid: "+validParentheses.isValid(test3));
    }
}
