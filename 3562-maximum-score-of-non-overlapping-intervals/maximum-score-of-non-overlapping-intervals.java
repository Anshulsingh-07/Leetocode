import java.util.*;

class Solution {
    private static class Interval {
        int l, r, w, id;
        Interval(int l, int r, int w, int id) {
            this.l = l; this.r = r; this.w = w; this.id = id;
        }
    }

    private static class State {
        long weight = 0;
        List<Integer> indices = new ArrayList<>();

        boolean isBetterThan(State other) {
            if (this.weight != other.weight) {
                return this.weight > other.weight;
            }
            // Lexicographical comparison for tie-breaking
            int len = Math.min(this.indices.size(), other.indices.size());
            for (int i = 0; i < len; i++) {
                if (!this.indices.get(i).equals(other.indices.get(i))) {
                    return this.indices.get(i) < other.indices.get(i);
                }
            }
            return this.indices.size() < other.indices.size();
        }
    }

    // Renamed to match LeetCode's template signature
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        Interval[] A = new Interval[n];
        for (int i = 0; i < n; i++) {
            List<Integer> curr = intervals.get(i);
            A[i] = new Interval(curr.get(0), curr.get(1), curr.get(2), i);
        }

        // Sort intervals by start time
        Arrays.sort(A, (a, b) -> Integer.compare(a.l, b.l));

        int[] L = new int[n];
        for (int i = 0; i < n; i++) L[i] = A[i].l;

        State[][] dp = new State[n + 1][5];
        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                dp[i][k] = new State();
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            // Binary search to find the next non-overlapping interval
            int nxt = binarySearch(L, A[i].r);

            for (int k = 1; k <= 4; k++) {
                // Option 1: Skip the current interval
                State skip = dp[i + 1][k];

                // Option 2: Take the current interval
                State take = new State();
                take.weight = dp[nxt][k - 1].weight + A[i].w;
                take.indices.addAll(dp[nxt][k - 1].indices);
                take.indices.add(A[i].id);
                Collections.sort(take.indices);

                if (skip.isBetterThan(take)) {
                    dp[i][k] = skip;
                } else {
                    dp[i][k] = take;
                }
            }
        }

        List<Integer> ansList = dp[0][4].indices;
        int[] ans = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) ans[i] = ansList.get(i);
        return ans;
    }

    private int binarySearch(int[] L, int target) {
        int low = 0, high = L.length;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (L[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
