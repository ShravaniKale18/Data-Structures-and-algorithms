import java.util.Stack;

/**
 * TC => O(N)
 * SC => O(N)
 */

public class PostfixToPrefixConversion {

    static String convertPostfixToPrefix(String s) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                stack.push(String.valueOf(ch));
            }else{
                String right = stack.pop();
                String left = stack.pop();

                String expression = ch + left + right;

                stack.push(expression);
            }

        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String s = "AB-DE+F*/";
        System.out.println(convertPostfixToPrefix(s));
    }
}
