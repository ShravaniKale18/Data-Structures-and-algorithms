package Array;

public class MaxMin {
    public static void main(String[] args) {
        int[][] arr = {
            {1,2,3,4},
            {15,8,9,2},
            {47,96,1}
        };

        int max = arr[0][0];
        int min = arr[0][0];

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] > max) {
                    max = arr[i][j];
                }

                if(arr[i][j] < min) {
                    min = arr[i][j];
                }
            }
        }
        System.out.println("Maximun Element = "+max);
        System.out.println("Minimum Element = "+min);
    }
}
