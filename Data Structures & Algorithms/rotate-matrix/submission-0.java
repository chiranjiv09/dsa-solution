/*
 * Rotate Matrix 90° Clockwise
 *
 * Step 1: Transpose
 *
 *   1 2 3        1 4 7
 *   4 5 6   ->   2 5 8
 *   7 8 9        3 6 9
 *
 * Step 2: Reverse every row
 *
 *   1 4 7        7 4 1
 *   2 5 8   ->   8 5 2
 *   3 6 9        9 6 3
 *
 * Result: 90° Clockwise Rotation
 */


class Solution {
    public void swap(int[][] arr, int i, int j) {
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
    }

    public void reverse(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        while(left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //Transpose
        for(int i=0; i< n-1; i++) {
            for(int j=i+1; j< n; j++) {
                swap(matrix, i, j);
            }
        }

        //reverse each row
        for(int i=0; i<n; i++) {
            reverse(matrix[i]);
        }
    }
}