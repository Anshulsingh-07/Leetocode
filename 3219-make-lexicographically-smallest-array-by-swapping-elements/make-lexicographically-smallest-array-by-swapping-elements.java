class Solution {
    class Pair implements Comparable<Pair>{
        int ele;
        int ind;
        Pair(int ele, int ind){
            this.ele = ele;
            this.ind = ind;
        }
        public int compareTo(Pair  p){
            if(this.ele == p.ele){
                return this.ind - p.ind;
            }
            return this.ele-p.ele;
        }
    }
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
       PriorityQueue<Pair>pq = new PriorityQueue<>();
       for(int i =0 ;i<nums.length;i++){
        pq.add(new Pair(nums[i],i));
       }
       
       int arr[] = new int[nums.length];
      
       while(pq.size()>0){
          List<Integer>list = new ArrayList<>();
          List<Integer>indices = new ArrayList<>();
          int max = pq.peek().ele;
          while(pq.size()>0 && Math.abs(pq.peek().ele-max)<=limit){
            max = Math.max(pq.peek().ele,max);
            list.add(pq.peek().ele);
            indices.add(pq.peek().ind);
            System.out.print("("+pq.peek().ele+","+pq.peek().ind+")");
            pq.poll();
          }
          System.out.println();
          Collections.sort(indices);
          for(int i = 0;i<list.size();i++){
            arr[indices.get(i)] = list.get(i);
          }


       }
       return arr;

    }
}