class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;

        // best[i] = minimum length of a valid subarray
        // ending at or before index i
        int[] best = new int[n];

        int INF = n + 1;
        for (int i = 0; i < n; i++) {
            best[i] = INF;
        }

        int left = 0;
        long sum = 0;
        int answer = INF;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            // Shrink window if sum becomes too large
            while (sum > target && left <= right) {
                sum -= arr[left];
                left++;
            }

            // Current window has sum == target
            if (sum == target) {
                int len = right - left + 1;

                // Need a previous non-overlapping subarray
                if (left > 0 && best[left - 1] != INF) {
                    answer = Math.min(answer, len + best[left - 1]);
                }

                // Store the shortest valid subarray seen so far
                if (right == 0) {
                    best[right] = len;
                } else {
                    best[right] = Math.min(best[right - 1], len);
                }
            } else {
                // No valid subarray ending at right,
                // carry forward the previous best
                if (right > 0) {
                    best[right] = best[right - 1];
                }
            }
        }

        return answer == INF ? -1 : answer;
    }
}