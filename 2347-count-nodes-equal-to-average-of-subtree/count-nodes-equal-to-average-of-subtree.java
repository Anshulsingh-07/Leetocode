/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int avg(TreeNode node){
        Queue<TreeNode>q = new LinkedList<>();
        q.add(node);
        int sum = 0;
        int count = 0;
        while(q.size()>0){
            int size = q.size();
            count+=size;
            
            
           
            for(int i = 0;i<size;i++){
                TreeNode newnode = q.poll();
                
                 sum+=newnode.val;
                if(newnode.left!=null){
                    q.add(newnode.left);
                }
                if(newnode.right!=null){
                    q.add(newnode.right);
                }
            }
            
        }
       

    return sum/count;
        
    }
    public int averageOfSubtree(TreeNode root) {
     
        Queue<TreeNode>q = new LinkedList<>();
        q.add(root);
       
        int count = 0;
        while(q.size()>0){
            int size = q.size();
           
            
           
            for(int i = 0;i<size;i++){
                TreeNode newnode = q.poll();
                int val = avg(newnode);
                if(val==newnode.val)count++;
                System.out.println(newnode.val+","+val);
                if(newnode.left!=null){
                    
                    q.add(newnode.left);
                }
                if(newnode.right!=null){
                    q.add(newnode.right);
                }
            }
            
        }
        return count;
       
       

        
    }
}