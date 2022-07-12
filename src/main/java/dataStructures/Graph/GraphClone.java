package dataStructures.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GraphClone {
	class Node {
	    public int val;
	    public List<Node> neighbors;
	    public Node() {
	        val = 0;
	        neighbors = new ArrayList<Node>();
	    }
	    public Node(int _val) {
	        val = _val;
	        neighbors = new ArrayList<Node>();
	    }
	    public Node(int _val, ArrayList<Node> _neighbors) {
	        val = _val;
	        neighbors = _neighbors;
	    }
	}
	 public Node cloneGraph(Node node) {

	        if(node==null)
	            return node;
	        Map<Node,Node> mp= new HashMap<>();
	        Queue<Node> q= new ArrayDeque<>();
	        q.add(node);
	        mp.put(node,new Node(node.val,new ArrayList<>()));
	        while(!q.isEmpty()){
	            Node temp= q.poll();
	            for(Node neighbor:temp.neighbors){
	                if(!mp.containsKey(neighbor)){
	                    q.add(neighbor);
	                    mp.put(neighbor,new Node(neighbor.val,new ArrayList<>()));
	                }
	                mp.get(temp).neighbors.add(mp.get(neighbor));
	            } 
	        }
	        return mp.get(node);
	        
	    }

}
