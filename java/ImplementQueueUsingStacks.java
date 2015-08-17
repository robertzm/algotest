class MyQueue {
    Stack<Integer> queue = new Stack<Integer>();
    
    // Push element x to the back of queue.
    public void push(int x) {
        Stack<Integer> tmp = new Stack<Integer>();
        while(!queue.empty()){
            tmp.push(queue.pop());
        }
        tmp.push(x);
        while(!tmp.empty()){
            queue.push(tmp.pop());
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        queue.pop();
    }

    // Get the front element.
    public int peek() {
        return queue.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return queue.empty();
    }
}