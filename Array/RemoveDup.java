package Array;



public class RemoveDup {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 3, 3};
        // Set<Integer> set = new HashSet<>();
        int index = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i-1]) {
                // set.add(arr[i]);
                arr[index++] = arr[i];
            }
        }

        for (int i = 0; i < index-1; i++) {
            System.out.print(arr[i]+" ");
        }

        System.out.println(index);

        // System.out.println(set);
    }
}
