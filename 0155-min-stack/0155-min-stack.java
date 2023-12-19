class MinStack {
    /*
        Algorithms & DS: Stack
        Time: O(N), Extra Space: O(N)
     */
    private Stack<Integer> _minStack;
    private Stack<Integer> _stack;

    public MinStack() {
        _minStack = new Stack<>();
        _stack = new Stack<>();
    }
    
    public void push(int val) {
        _stack.push(val);

        if(!_minStack.isEmpty() && _minStack.peek() <= val) _minStack.push(_minStack.peek());
        else _minStack.push(val);
    }
    
    public void pop() {
        _minStack.pop();
        _stack.pop();
    }
    
    public int top() {
        return _stack.peek();
    }
    
    public int getMin() {
        return _minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */