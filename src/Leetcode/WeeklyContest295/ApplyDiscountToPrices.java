package src.Leetcode.WeeklyContest295;

public class ApplyDiscountToPrices {

}

class Solution {
    public String discountPrices(String sentence, int discount) {
        double dis = (double) discount / 100.0;

        StringBuilder result = new StringBuilder(sentence.length());

        for (int i = 0; i < sentence.length(); ++i) {
            char ch = sentence.charAt(i);
            result.append(ch);

            if (ch == '$') {
                ++i;
                StringBuilder numberStr = new StringBuilder();
                while (i < sentence.length() && sentence.charAt(i) != ' ') {
                    numberStr.append(sentence.charAt(i));
                    ++i;
                }
                try {
                    double num = Double.parseDouble(numberStr.toString());
                    num -= num * dis;
                    result.append(String.format("%.2f", num));
                } catch (Exception __) {
                    result.append(numberStr.toString());
                }

                if (i < sentence.length())
                    result.append(' ');
            }
        }

        return result.toString();
    }
}
