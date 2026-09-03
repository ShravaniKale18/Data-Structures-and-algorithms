public class OnlineStockProblem {

    int[] prices;
    int index;

    public OnlineStockProblem() {
        
        prices = new int[10000];
        index = 0;
    }
    
    public int next(int price) {

        prices[index++] = price;
        int count = 1;

        for(int i = index - 2; i >= 0; i--) {
            if(prices[i] <= price) {
                count++;
            } else {
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        
        OnlineStockProblem stockSpanner = new OnlineStockProblem();

        System.out.println(stockSpanner.next(100)); // Output: 1
        System.out.println(stockSpanner.next(80));  // Output: 1
        System.out.println(stockSpanner.next(60));  // Output: 1
        System.out.println(stockSpanner.next(70));  // Output: 2
        System.out.println(stockSpanner.next(60));  // Output: 1
        System.out.println(stockSpanner.next(75));  // Output: 4
        System.out.println(stockSpanner.next(85));  // Output: 6
        
    }
}
