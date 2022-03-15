package src.Leetcode;

public class ImplementStrStr {
}

class Solution {
    private static int HASH_BASE = 1000000;
    private static int HASH_OFFSET = 31;

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;

        int needleLen = needle.length();

        int power = 1, needleCode = 0;

        for (int i = 0; i < needleLen; i++) {
            power = (power * HASH_OFFSET) % HASH_BASE;
            needleCode = (needleCode * HASH_OFFSET + needle.charAt(i)) % HASH_BASE;
        }

        int hashCode = 0;
        for (int i = 0; i < haystack.length(); i++) {
            hashCode = (hashCode * HASH_OFFSET + haystack.charAt(i)) % HASH_BASE;
            if (i < needleLen - 1)
                continue;

            if (i >= needleLen) {
                hashCode = (hashCode - haystack.charAt(i - needleLen) * power) % HASH_BASE;
                if (hashCode < 0)
                    hashCode += HASH_BASE;
            }

            if (hashCode == needleCode && haystack.substring(i - needleLen + 1, i + 1).equals(needle))
                return i - needleLen + 1;
        }
        return -1;
    }
}
