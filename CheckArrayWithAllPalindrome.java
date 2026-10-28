public class CheckArrayWithAllPalindrome {

    /** 
     * Approach:
     * Iterate through each element of the array.
     * For each element, check if it is a palindrome.
     * If any element is not a palindrome, return false.
     * If all elements are palindromes, return true.
     * 
     * Time Complexity: O(n * k) where n is the number of elements in the array and k is the number of digits in the largest element.
     * Space Complexity: O(1)
     */
    
    public static boolean isPalinArray(int[] arr) {
        
        for(int i = 0; i < arr.length; i++) {
            if(!isPalindromeElement(arr[i])) {
                return false;
            }
        }
        
        return true;
    }
    
    public static boolean isPalindromeElement(int num) {

        int originalEle = num;
        int rev = 0;
        
        while(num > 0) {
            int rem = num % 10;
            rev = rev * 10 + rem;
            num = num / 10;
        }
        
        if(rev == originalEle) {
            return true;
        }
        
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {121, 131, 141, 151};
        boolean result = CheckArrayWithAllPalindrome.isPalinArray(arr);
        
        if(result) {
            System.out.println("All elements are palindromes.");
        } else {
            System.out.println("Not all elements are palindromes.");
        }
    }
}
