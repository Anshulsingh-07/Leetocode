class Solution {
    public boolean sumGame(String num) {
        int len = num.length();
        int leftSum = 0, rightSum = 0;
        int leftQ = 0, rightQ = 0;

        // Count sums and question marks for both halves
        for (int i = 0; i < len; i++) {
            char ch = num.charAt(i);
            if (i < len / 2) {
                if (ch == '?') leftQ++;
                else leftSum += ch - '0';
            } else {
                if (ch == '?') rightQ++;
                else rightSum += ch - '0';
            }
        }

        // Alice wins if the total number of turns is odd
        if ((leftQ + rightQ) % 2 != 0) {
            return true;
        }

        // Bob wins (returns false) if the mathematical balance holds true
        return (leftSum - rightSum) != (rightQ - leftQ) * 9 / 2;
    }
}
