package src.Leetcode;

public class ImplementStrStr {
}

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;

        for (int i = 0; i < haystack.length(); ++i) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                boolean found = true;
                for (int j = 1; j < needle.length(); ++j) {
                    if (i + j >= haystack.length() || haystack.charAt(i + j) != needle.charAt(j)) {
                        found = false;
                        break;
                    }
                }
                if (found)
                    return i;
            }
        }
        return -1;
    }
}
