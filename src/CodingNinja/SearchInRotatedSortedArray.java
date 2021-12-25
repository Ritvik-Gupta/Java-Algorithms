package src.CodingNinja;

public class SearchInRotatedSortedArray {
}

class Solution {
    public static int search(int arr[], int key) {
        int lower = 0, upper = arr.length - 1;

        while (lower <= upper) {
            int middle = lower + (upper - lower) / 2;

            if (arr[middle] == key)
                return middle;

            if (arr[middle] <= arr[upper])
                if (key > arr[middle] && key <= arr[upper])
                    lower = middle + 1;
                else
                    upper = middle - 1;
            else if (key >= arr[lower] && key < arr[middle])
                upper = middle - 1;
            else
                lower = middle + 1;
        }

        return -1;
    }
}
