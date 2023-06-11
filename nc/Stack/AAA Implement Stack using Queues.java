class MyStack {
    Deque<Integer> q;
    public MyStack() {
        q=new ArrayDeque();
    }
    
    public void push(int x) {
        q.addLast(x);
    }
    
    public int pop() {
        int size =q.size();
        for(int i = 0; i < size - 1; i++)
          push(q.pollFirst());
        return q.pollFirst();
    }
    
    public int top() {
        int size=q.size();
        for(int i=0;i<size-1;i++)
        {
            push(q.pollFirst());
        }
        int res =q.peekFirst();
        push(q.pollFirst());
        return res;

    }
    
    public boolean empty() {
        return q.size()==0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */





class MyStack 
{
    Queue<Integer> queue;
    
    public MyStack()
    {
        this.queue=new LinkedList<Integer>();
    }
    
    // Push element x onto stack.
    public void push(int x) 
    {
       queue.add(x);
       for(int i=0;i<queue.size()-1;i++)
       {
           queue.add(queue.poll());
       }
    }

    // Removes the element on top of the stack.
    public void pop() 
    {
        queue.poll();
    }

    // Get the top element.
    public int top() 
    {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() 
    {
        return queue.isEmpty();
    }
}
