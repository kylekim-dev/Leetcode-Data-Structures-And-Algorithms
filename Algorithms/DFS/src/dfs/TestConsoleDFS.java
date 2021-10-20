package dfs;

import java.util.LinkedList;
import java.util.Stack;

class Graph {
	class Node {
		int data;
		LinkedList<Node> adjacent;
		boolean marked;
		Node (int data){
			this.data = data;
			this.marked = false;
			adjacent = new LinkedList<Node>();
		}
	}
	
	Node[] nodes;
	Graph(int size) {
		nodes = new Node[size];
		for (int i = 0; i < size; i++) {
			nodes[i] = new Node(i);
		}
	}
	
	void addEdge(int i1, int i2) {
		Node n1 = nodes[i1];
		Node n2 = nodes[i2];
		
		if(!n1.adjacent.contains(n2)) {
			n1.adjacent.add(n2);
		}
		if(!n2.adjacent.contains(n1)) {
			n2.adjacent.add(n1);
		}
	}
	
	void dfs(int index) {
		Node root = this.nodes[index];
		Stack<Node> stack = new Stack<Node>();
		
		stack.push(root);
		root.marked = true;
		
		while(!stack.empty()) {
			Node node = stack.pop();
			LinkedList<Node> adjNodes = node.adjacent;
			
			for(Node adjNode : adjNodes) {
				if(!adjNode.marked) {
					stack.push(adjNode);
					adjNode.marked = true;
				}
			}
			
			visit(node);
		}
	}
	
	void dfsR(int index) {
		Node r = nodes[index];
		dfsR(r);
	}
	
	void dfsR(Node r) {
		if (r == null) return;
		
		r.marked = true;
		visit(r);
		
		for(Node n : r.adjacent) {
			if(!n.marked) {
				dfsR(n);
			}
		}
	}
	
	void visit(Node n) {
		System.out.print(n.data + " ");
	}
}

/*
 
 0
/
1 -- 3    7
|  / | \ /
| /  |  5 
2 -- 4   \
          6 - 8
 
 */

/* Result
 DFS (0)
 0 1 3 5 7 6 8 4 2 
 DFS (3)
 3 5 7 6 8 4 2 1 0 

 DFSR(0)
 0 1 2 4 3 5 6 8 7 
 DFSR(3)
 3 1 0 2 4 5 6 8 7 
 */

public class TestConsoleDFS {

	public static void main(String[] args) {
		Graph g = new Graph(9);

		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(5, 6);
		g.addEdge(5, 7);
		g.addEdge(6, 8);
		
		g.dfs(0);
		System.out.println();
		/*g.dfs(3);
		System.out.println();
		g.dfsR(0);
		System.out.println();
		g.dfsR(3);
		System.out.println();*/
		//g.dfsR();
	}

}
