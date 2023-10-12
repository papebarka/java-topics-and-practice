package DsAndAlgorithm.binarysearch;

import java.util.Arrays;

public class SortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println(Arrays.toString(search(matrix, 9)));
    }

    //Search in the row provided with the provided columns
    public static int[] binarySearch(int[][] matrix, int row, int columnStart, int columnEnd, int target){
        while (columnStart <= columnEnd){
            int mid = columnStart + (columnEnd - columnStart)/2;

            if(matrix[row][mid] == target){
                return new int[]{row, mid};
            }

            if(matrix[row][mid] < target){
                columnStart = mid + 1;
            } else {
                columnEnd = mid - 1;
            }
        }

        return new int[]{-1, -1};
    }

    public static int[] search(int[][] matrix, int target){
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (rows == 1){
            return binarySearch(matrix, 0, 0, cols, 10 );
        }

        int rowStart = 0;
        int rowEnd = rows - 1;
        int columnMid = cols / 2;

        // Run the loop till two rows are remaining
        while (rowStart < (rowEnd - 1)){
            int mid = rowStart + (rowEnd - rowStart) / 2;

            if (matrix[mid][columnMid] == target){
                return new int[]{mid, columnMid};
            }
            if (matrix[mid][columnMid] < target){
                rowStart = mid;
            } else {
                rowEnd = mid;
            }
        }

        // While two rows are remaining
        // check whether target arget is in the col of the two rows
        if(matrix[rowStart][columnMid] == target){
            return new int[]{rowStart, columnMid};
        }
        if(matrix[rowStart + 1][columnMid] == target){
            return new int[]{rowStart + 1, columnMid};
        }

        //In case it's not in the two cols selected
        // check first half
        if (target <= matrix[rowStart][columnMid - 1]){
            return binarySearch(matrix, rowStart, 0, columnMid-1, target);
        }
        // check second half
        if (target >= matrix[rowStart][columnMid + 1] && target <= matrix[rowStart][cols -1]){
            return binarySearch(matrix, rowStart, columnMid+1, cols-1, target);
        }
        // check third half
        if (target <= matrix[rowStart + 1][columnMid - 1]){
            return binarySearch(matrix, rowStart+1, 0, columnMid-1, target);
        } else {
            return binarySearch(matrix, rowStart+1, columnMid+1, cols-1, target);
        }
    }
}
