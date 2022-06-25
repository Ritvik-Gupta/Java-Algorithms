package src.AmazonChallenge;

import java.util.HashSet;
import java.util.Scanner;

public class OddQueries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arrSize = sc.nextInt();
        int numQueries = sc.nextInt();

        int[] arr = new int[arrSize];
        for (int i = 0; i < arrSize; ++i)
            arr[i] = sc.nextInt();

        int[][] queries = new int[numQueries][3];
        for (int i = 0; i < numQueries; ++i)
            queries[i] = new int[] { sc.nextInt(), sc.nextInt(), sc.nextInt() };

        sc.close();

        int[] result = solve(arrSize, numQueries, arr, queries);
        for (int res : result)
            System.out.println(res);
    }

    static XorSet[] buildOddsSeenList(int[] arr) {
        XorSet[] oddsSeenList = new XorSet[arr.length + 1];
        XorSet set = new XorSet();

        oddsSeenList[arr.length] = new XorSet(set);
        for (int i = arr.length - 1; i >= 0; --i) {
            set.xorAdd(arr[i]);
            oddsSeenList[i] = new XorSet(set);
        }

        return oddsSeenList;
    }

    static int[] solve(int __, int ___, int[] arr, int[][] queries) {
        XorSet[] oddsSeenList = buildOddsSeenList(arr);

        int numRangeQueries = 0;
        for (int i = 0; i < queries.length; ++i)
            if (queries[i][0] == 2)
                ++numRangeQueries;

        int[] result = new int[numRangeQueries];
        int resultIdx = 0;

        for (int[] query : queries) {
            if (query[0] == 1) {
                int prevElm = arr[query[1] - 1];
                int newElm = query[2];

                for (int i = 0; i < query[1]; ++i) {
                    oddsSeenList[i].xorAdd(prevElm);
                    oddsSeenList[i].xorAdd(newElm);
                }
            } else {
                int startIdx = query[1] - 1, endIdx = query[2];

                XorSet oddsInRange = XorSet.xorredUnion(oddsSeenList[startIdx], oddsSeenList[endIdx]);
                result[resultIdx++] = oddsInRange.size();
            }
        }

        return result;
    }
}

class XorSet extends HashSet<Integer> {
    XorSet() {
        super();
    }

    XorSet(XorSet prevSet) {
        super(prevSet);
    }

    void xorAdd(int elm) {
        if (super.contains(elm))
            super.remove(elm);
        else
            super.add(elm);
    }

    static XorSet xorredUnion(XorSet set1, XorSet set2) {
        XorSet unionSet = new XorSet();

        for (int elm : set1)
            unionSet.xorAdd(elm);

        for (int elm : set2)
            unionSet.xorAdd(elm);

        return unionSet;
    }
}
