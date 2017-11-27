import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class MovingMedianHeap {

	static Queue<Integer> minheap = new PriorityQueue<>(Comparator.reverseOrder());
	static Queue<Integer> maxheap = new PriorityQueue<>();
	 

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		MovingMedianHeap mvmedian = new MovingMedianHeap();

		int inputlength = sc.nextInt(); // no if inputs

		for (int i = 0; i < inputlength; i++) {

			int inputvalue = sc.nextInt();
			mvmedian.add(inputvalue);

			System.out.println(mvmedian.findMeadian());

		}
	}

	void add(int inputvalue) {

		Queue<Integer> target;
		
		if (minheap.isEmpty())
			target = minheap;
		else if (maxheap.isEmpty())
			target = maxheap;
		else
			target = minheap.size() > maxheap.size() ? maxheap : minheap;

		target.add(inputvalue);

		balanceHeaps();

	}

	void balanceHeaps() {

		if (!maxheap.isEmpty() && !minheap.isEmpty() & minheap.peek() > maxheap.peek()) {
			int minheapvalue = minheap.poll();
			int maxheapvalue = maxheap.poll();
			maxheap.add(minheapvalue);
			minheap.add(maxheapvalue);
		}

	}

	double findMeadian() {

		if (minheap.isEmpty() && maxheap.isEmpty()) {
			throw new IllegalStateException("Empty heaps");
		} else {
			if (minheap.size() == maxheap.size())
				return ((minheap.peek() + maxheap.peek()) / 2.0);
			else
				return minheap.peek();

		}

	}

}
