class MinStack {
    
    class Pair{
        int  first;
        int  second;
        Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }
    Stack<Pair>minstack = new Stack<>();

    public MinStack() {
        Stack<Pair>minstack = new Stack<>();
    }
    
    public void push(int val) {
    int min_ele = minstack.size()==0?val:Math.min(minstack.peek().second,val);
     minstack.push(new Pair(val,min_ele));
    
        
    }
    
    public void pop() {
        int removed = minstack.pop().first;
    
       
    }
    
    public int top() {
        int top =  minstack.peek().first;
        return top;
      
        
    }
    
    public int getMin() {
       int min =  minstack.peek().second;
       return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */