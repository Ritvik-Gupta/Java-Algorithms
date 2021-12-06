package src.Dsa450.Array;

public class KadanesAlgorithm {

}

class Solution {
    long maxSubarraySum(int arr[], int _n) {
        for (int i = 1; i < arr.length; ++i)
            arr[i] += arr[i - 1];

        int maxElmIdx = 0;
        for (int i = 0; i < arr.length; ++i)
            if (arr[i] < arr[maxElmIdx])
                maxElmIdx = i;

        int minElmBeforeMax = 0;
        for (int i = maxElmIdx; i < arr.length; ++i)
            if (arr[i] > minElmBeforeMax)
                minElmBeforeMax = arr[i];

        return minElmBeforeMax - arr[maxElmIdx];
    }
}
