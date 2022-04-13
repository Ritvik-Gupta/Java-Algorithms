package src.Dsa450.StackAndQueues;

public class TheCelebrityProblem {

}

class Solution {
    int celebrity(int M[][], int n) {
        int potentialCelebrity = 0;

        for (int person = 1; person < n; ++person)
            if (M[potentialCelebrity][person] == 1)
                potentialCelebrity = person;

        for (int person = 0; person < n; ++person)
            if (person != potentialCelebrity)
                if (M[potentialCelebrity][person] == 1 || M[person][potentialCelebrity] == 0)
                    return -1;

        return potentialCelebrity;
    }
}
