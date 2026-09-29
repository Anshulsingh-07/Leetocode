class Solution {
    public int numberOfBeams(String[] bank) {
        int totalBeams = 0;
        int prevDeviceCount = 0;
        
        for (String row : bank) {
            int currentDeviceCount = 0;
            
            // Count the number of devices ('1's) in the current row
            for (char c : row.toCharArray()) {
                if (c == '1') {
                    currentDeviceCount++;
                }
            }
            
            // If the current row has devices, calculate beams and update tracking
            if (currentDeviceCount > 0) {
                totalBeams += (prevDeviceCount * currentDeviceCount);
                prevDeviceCount = currentDeviceCount; 
            }
        }
        
        return totalBeams;
    }
}
