class Solution {

    public String lexPalindromicPermutation(String s, String target) {

        int n = s.length();
        int m = n / 2;

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Check if palindrome is possible
        int odd = 0;
        char mid = 0;

        for (int c = 0; c < 26; c++) {
            if (freq[c] % 2 == 1) {
                odd++;
                mid = (char) ('a' + c);
            }
        }

        if (odd > 1) {
            return "";
        }

        // Count available characters for LEFT half
        int[] halfCnt = new int[26];

        for (int c = 0; c < 26; c++) {
            halfCnt[c] = freq[c] / 2;
        }

        /*
         * Find how many characters of target's left half
         * can be matched exactly.
         */
        int matched = 0;
        int[] temp = halfCnt.clone();

        while (matched < m) {

            int c = target.charAt(matched) - 'a';

            if (temp[c] == 0) {
                break;
            }

            temp[c]--;
            matched++;
        }

        /*
         * If we can match the complete left half,
         * construct that palindrome and check it.
         */
        if (matched == m) {

            char[] left = new char[m];

            for (int i = 0; i < m; i++) {
                left[i] = target.charAt(i);
            }

            String ans = build(left, mid, n);

            if (ans.compareTo(target) > 0) {
                return ans;
            }
        }

        /*
         * Try to make the left half larger.
         *
         * Start from RIGHT to LEFT.
         *
         * This gives the smallest possible increase.
         */
        int last = Math.min(matched, m - 1);

        for (int i = last; i >= 0; i--) {

            /*
             * Rebuild remaining characters for prefix [0 ... i-1].
             *
             * This is intentionally simple and safe.
             */
            int[] rem = halfCnt.clone();

            boolean possible = true;

            for (int j = 0; j < i; j++) {

                int c = target.charAt(j) - 'a';

                if (rem[c] == 0) {
                    possible = false;
                    break;
                }

                rem[c]--;
            }

            if (!possible) {
                continue;
            }

            int current = target.charAt(i) - 'a';

            /*
             * Try the smallest character greater than target[i].
             */
            for (int c = current + 1; c < 26; c++) {

                if (rem[c] == 0) {
                    continue;
                }

                char[] left = new char[m];

                // Equal prefix
                for (int j = 0; j < i; j++) {
                    left[j] = target.charAt(j);
                }

                // Make current position larger
                left[i] = (char) ('a' + c);

                rem[c]--;

                /*
                 * Fill remaining positions with the
                 * smallest possible characters.
                 */
                int pos = i + 1;

                for (int x = 0; x < 26; x++) {

                    while (rem[x] > 0) {

                        // Safety: never write outside array
                        if (pos >= m) {
                            return "";
                        }

                        left[pos++] = (char) ('a' + x);
                        rem[x]--;
                    }
                }

                return build(left, mid, n);
            }
        }

        return "";
    }


    private String build(char[] left, char mid, int n) {

        StringBuilder sb = new StringBuilder(n);

        // Left half
        for (char c : left) {
            sb.append(c);
        }

        // Middle character for odd length
        if (n % 2 == 1) {
            sb.append(mid);
        }

        // Right half
        for (int i = left.length - 1; i >= 0; i--) {
            sb.append(left[i]);
        }

        return sb.toString();
    }
}