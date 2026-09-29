import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = left; i <= right; i++) {
            if (isSelfDividing(i)) {
                result.add(i);
            }
        }
        
        return result;
    }
    
    private boolean isSelfDividing(int num) {
        int current = num;
        
        while (current > 0) {
            int digit = current % 10;
            // A number cannot contain 0, and must divide the original number evenly
            if (digit == 0 || num % digit != 0) {
                return false;
            }
            current /= 10;
        }
        
        return true;
    }
}
