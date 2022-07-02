package dataStructures.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import dataStructures.Tree.MaxDepthInTree.TreeNode;

public class LevelOrderTraversal {
	class Solution {
	    public List<List<Integer>> levelOrder(TreeNode root) {
	        List<List<Integer>> res= new ArrayList<List<Integer>>();
	        Queue<TreeNode> q= new LinkedList<TreeNode>();
	        if(root==null)
	            return res;
	        q.add(root);
	        while(!q.isEmpty()){
	            int size =q.size();
	            List<Integer> list = new ArrayList<Integer>();
	            for(int i=0;i<size;i++){
	                TreeNode top=q.poll();
	                list.add(top.val);
	                if(top.left!=null)
	                    q.add(top.left);
	                if(top.right!=null)
	                    q.add(top.right);
	                
	            }
	            res.add(list);
	        }
	        return res;
	        
	    }
	}

}
