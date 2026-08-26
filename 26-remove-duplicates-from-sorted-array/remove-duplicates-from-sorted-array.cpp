class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int n =nums.size();
        int i=0;
        int j=0;
        int count=1;
        while(i<n&& j<n){
            if(nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j];
                count++;
            }
            else{
                j++;
            }
        }
        return count;
    }
};