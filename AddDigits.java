public class AddDigits {

    public static int addDigits(int num) {
        

        // while(num > 9) {
        //     int sum = 0;

        //     while(num > 0) {
        //         int rem = num % 10;
        //         sum += rem;
        //         num = num / 10;
        //     }
            
        //     num =  sum;
        // }

        // return num;

        if(num == 0) {
            return 0;
        }

        return num % 9;
    }

    public static void main(String[] args) {
        int num = 38;
        int result = addDigits(num);
        System.out.println("The result of adding digits of " + num + " is: " + result);
    }
}
