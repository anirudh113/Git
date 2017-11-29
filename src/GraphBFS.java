

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class GraphBFS {
	
	int size;
	List<List<Integer>> nodes;
	
	GraphBFS(int size){
		nodes = new ArrayList<>();
		this.size=size;
		while(size-- >0) {
			nodes.add(new ArrayList<Integer>());
		}
	}
	
	void addUnidirectionalEdge(int first, int second){
		nodes.get(first).add(second);
		nodes.get(second).add(first);
	}
	
	int[] findMinDistance(int startNode) {
		
		int[] distance = new int[size];
		Arrays.fill(distance, -1);
		
		Queue<Integer> que = new LinkedList<>();
		Set<Integer> seen = new HashSet<>();
		
		que.offer(startNode);
		seen.add(startNode);
		int currNode = startNode;
		distance[currNode] = 0;
		
		while(!que.isEmpty()) {
			 currNode = que.poll();
			for(int n: nodes.get(currNode)) {
				if(!seen.contains(n)) {
					seen.add(n);
					que.offer(n);
					distance[n]=distance[currNode]+6;
				}
			}
		}
		return distance;
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int queries = scanner.nextInt();
		while(queries-- >0) {
			int size1 = scanner.nextInt()+1;
			GraphBFS graph = new GraphBFS(size1);
			int edges = scanner.nextInt();
			while(edges-- > 0) {
				graph.addUnidirectionalEdge(scanner.nextInt(), scanner.nextInt());
			}
			int[] result = graph.findMinDistance(scanner.nextInt());
			for(int i=1;i<size1;i++) {
				if(result[i]!=0)
				System.out.print(result[i]+" ");
			}
			System.out.println();
			
		}
		
	}

}
