/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
         int arr[] = new int[2];
        List<Integer>list = new ArrayList<>();
        
        if(head == null||head.next==null|| head.next.next==null){
            arr[0] = -1;
            arr[1] = -1;
            return arr;
        }
       
        ListNode prev = head;
        ListNode curr = prev.next;
        ListNode next = curr.next;
        int ind = 1;
        while(next!=null){
            if((curr.val<next.val && curr.val<prev.val)|| (curr.val>next.val && curr.val>prev.val)){
                 list.add(ind);
                
            }
            ind++;
            prev = curr;
            curr = next;
            next = next.next;
        }
        int min = Integer.MAX_VALUE ;
        
        Collections.sort(list);
        if(list.size()<2){
            arr[0] = -1;
            arr[1] = -1;
            return arr;
        }
        for(int i = 1;i<list.size();i++){
            System.out.println(list.get(i));
            min = Math.min(min,list.get(i)-list.get(i-1));

        }
        int max = list.get(list.size()-1)-list.get(0);
        arr[0] = min;
        arr[1] = max;
        return arr;

    }
}