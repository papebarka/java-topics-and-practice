public class Application {
    public static void main(String[] args) {
        int[] arr = {1, 4, 7, 8, 10, -7, 85, 100, 102};
        int target = 85;

        int answer = linearSearch(arr, target);
        System.out.println(answer);
    }

    public static int linearSearch(int[] arr, int target){
        if (arr.length == 0){
            return -1;
        }

        for(int index = 0; index < arr.length; index++){

            int element = arr[index];

            if (element == target){
                return index;
            }
        }

        return -1;
    }
}