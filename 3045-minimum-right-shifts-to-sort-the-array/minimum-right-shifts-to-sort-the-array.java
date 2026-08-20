class Solution {
    boolean isSorted(List<Integer>list){

        for(int i = 1;i<list.size();i++){
            if(list.get(i)<list.get(i-1))return false;
        }
        return true;
    }
    public int minimumRightShifts(List<Integer> list) {
      
    int max = Integer.MIN_VALUE;
    
    int count = 0;
    while(!isSorted(list)){
        if(count>=list.size())return -1;
        int a = list.get(list.size()-1);
        list.remove(list.size()-1);
        list.addFirst(a);
       
        count++;
    }
    
   return count;


    }
}