import java.util.Stack;

public class PrefixToPostfixConversion {

    static String convertPrefixToPostfix(String s) {

        Stack<String> stack = new Stack<>();

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                stack.push(String.valueOf(ch));
            }else{
                String left = stack.pop();
                String right = stack.pop();

                String expression = left + right + ch;

                stack.push(expression);
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        String s = "/-AB*+DEF";

        System.out.println(convertPrefixToPostfix(s));

    }
}
