package src.CodingNinja;

public class OccurrenceOfXInASortedArray {
}

class Solution {
    public static int countOccurences(int arr[], int elmToSearch) {
        int startingOccurence, endingOccurence;

        int lower = 0, upper = arr.length - 1, mid = 0;
        while (lower <= upper) {
            mid = lower + (upper - lower) / 2;
            if (elmToSearch > arr[mid])
                lower = mid + 1;
            else if (elmToSearch < arr[mid] || (mid - 1 >= 0 && arr[mid] == arr[mid - 1]))
                upper = mid - 1;
            else
                break;
        }
        if (lower > upper)
            return 0;
        startingOccurence = mid;

        lower = mid;
        upper = arr.length - 1;
        while (lower <= upper) {
            mid = lower + (upper - lower) / 2;
            if (elmToSearch < arr[mid])
                upper = mid - 1;
            else if (elmToSearch > arr[mid] || (mid + 1 < arr.length && arr[mid] == arr[mid + 1]))
                lower = mid + 1;
            else
                break;
        }
        if (lower > upper)
            return 0;
        endingOccurence = mid;

        return endingOccurence - startingOccurence + 1;
    }
}
