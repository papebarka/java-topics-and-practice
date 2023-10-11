package DsAndAlgorithm.binarysearch;

public class BinarySearch {
    
    public static void main(String[] args){

        int[] arr = {-30, -20, -17, -8, -3, 0, 1, 2, 4, 7, 9, 12, 40, 75, 95, 99, 101, 210, 300};
        int target = -17;

        int answer = binarySearch(arr, target);

        System.out.println(answer);
    }

    //Return the index if target found
    // Return -1 if not found
    public static int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            // Find the middle element
            //int mid = (start + end) /2
            // It might be possible that (start + end) exceeds the range of int in java.
            //In that case; it's better to have mid = start + (end - start)/2

            int mid = start + (end-start)/2;

            if(target < arr[mid]){
                end = mid - 1;
            } else if (target > arr[mid]){
                start = mid + 1;
            } else {
                return mid;
            }

        }

        return -1;
    }

    public static int recursiveBinarySearch(int[] nums, int target){
        return 0;
    }
}
