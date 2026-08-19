import java.util.Stack;

public class PostfixToInfixConversion{

    static String convertPostfix(String s) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                stack.push(String.valueOf(ch));
            }else{
                String right = stack.pop();
                String left = stack.pop();

                String expression = "(" + left + ch + right + ")";

                stack.push(expression);
            }
        }

        return stack.peek();
    }
    public static void main(String[] args) {
        String postfix = "ab+c*";

        System.out.println(convertPostfix(postfix));
    }
}