import java.util.Stack;

public class PrefixToInfix {

    static String convertPrefix(String s) {
        Stack<String> stack = new Stack<>();

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                stack.push(String.valueOf(ch));
            }else{
                String left = stack.pop();
                String right = stack.pop();

                String expression = "(" + left + ch + right + ")";

                stack.push(expression);
            }
        }
        return stack.peek();
    }
    public static void main(String[] args) {
        String prefix = "*+abc";

        System.out.println(convertPrefix(prefix));
    }
}
