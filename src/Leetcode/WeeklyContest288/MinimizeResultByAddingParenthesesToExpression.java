package src.Leetcode.WeeklyContest288;

public class MinimizeResultByAddingParenthesesToExpression {

}

class Solution {
    private int parse(String num) {
        if (num.length() == 0)
            return 1;
        return Integer.parseInt(num);
    }

    public String minimizeResult(String expression) {
        String[] exps = expression.split("\\+");
        String leftNum = exps[0], rightNum = exps[1];

        int minVal = parse(leftNum) + parse(rightNum);
        int leftNumStart = 0, rightNumEnd = rightNum.length();
        for (int i = 0; i < leftNum.length(); ++i) {
            for (int j = rightNum.length(); j > 0; --j) {
                String xMul = leftNum.substring(0, i);
                String x = leftNum.substring(i);
                String y = rightNum.substring(0, j);
                String yMul = rightNum.substring(j);

                int val = parse(xMul) * (parse(x) + parse(y)) * parse(yMul);
                if (val < minVal) {
                    minVal = val;
                    leftNumStart = i;
                    rightNumEnd = j;
                }
            }
        }

        String xMul = leftNum.substring(0, leftNumStart);
        String x = leftNum.substring(leftNumStart);
        String y = rightNum.substring(0, rightNumEnd);
        String yMul = rightNum.substring(rightNumEnd);

        return xMul + "(" + x + "+" + y + ")" + yMul;
    }
}
