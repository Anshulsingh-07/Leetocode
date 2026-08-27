import java.util.HashMap;

class Solution {
    String result = "";

    boolean solve(StringBuilder curr, HashMap<Character, Integer> map, String target, int i, boolean greater) {
        if (i == target.length()) {
            if (greater) {
                result = curr.toString();
                return true;
            }
            return false;
        }

        for (char ch = 'a'; ch <= 'z'; ch++) {
            // Fix 1: Passed 'ch' into containsKey()
            if (!map.containsKey(ch) || map.get(ch) == 0) continue;
            
            // Fix 2: Skip smaller characters only if we are not already greater
            if (!greater && ch < target.charAt(i)) continue;

            // Fix 3: Use StringBuilder for efficiency
            curr.append(ch);
            map.put(ch, map.get(ch) - 1);

            // Fix 4: Renamed local variable to avoid shadowing the parameter
            boolean nextGreater = greater || (ch > target.charAt(i));

            if (solve(curr, map, target, i + 1, nextGreater)) return true;

            // Backtrack
            curr.setLength(curr.length() - 1);
            map.put(ch, map.get(ch) + 1);
        }
        return false;
    }

    public String lexGreaterPermutation(String s, String target) {
        // Edge case: if lengths mismatch, permutation is impossible
        if (s.length() != target.length()) return ""; 
        
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        StringBuilder curr = new StringBuilder();
        // Fix 5: Passed 0 instead of the undefined variable 'i'
        solve(curr, map, target, 0, false); 
        return result;
    }
}
