package test.leetCode;
import java.util.Stack;

class MyQueue {
    Stack<Integer> stack =new Stack<Integer>(); 
    int arr[]=null;
    // Push element x to the back of queue.
    public void push(int x) {
       stack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        int counter=-1;
        arr=new int[stack.size()];
        
        while(!stack.empty()){
            arr[++counter]=stack.pop();   
        }
        if(counter>0){
            for(int i=counter-1;i>=0;i--){
                stack.push(arr[i]);
            }
        }
        arr=null;
    }

    // Get the front element.
    public int peek() {
        if(stack.empty()){
            return 0;
        }
        if(stack.size()==1){
            return stack.peek();
        }
        int counter=-1;
        arr=new int[stack.size()];
        int val=0;
        
        while(!stack.empty()){
            arr[++counter]=stack.pop();   
        }
        if(counter>=0){
            val=arr[counter];
            for(int i=counter;i>=0;i--){
                stack.push(arr[i]);
            }
        }
        arr=null;
        return val;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.empty();
    }
}