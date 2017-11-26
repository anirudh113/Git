

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Queue2stacks {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
              queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
              queue.dequeue();
            } else if (operation == 3) { // print/peek
              System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}

class MyQueue<E>{
	Deque<E> stack1, stack2;
	
	MyQueue(){
		stack1 = new ArrayDeque<>();
		stack2 = new ArrayDeque<>();
	}
	
	void enqueue(E e){
		
		stack1.push(e);
	}
	
	void dequeue(){
		
		if(!stack2.isEmpty()) {
			stack2.pop();
		}
		else {
			this.manageStacks();
			stack2.pop();
		}
	}
	
	E peek(){
		
		E value;
		if(!stack2.isEmpty()) {
			value = stack2.peek();
		}
		else {
			this.manageStacks();
			value = stack2.peek();
		}
		
		return value;
		
	}
	
	void manageStacks() {
		
		while(!stack1.isEmpty()) {
			E value = stack1.pop();
			stack2.push(value);
		}
	}
	
}


