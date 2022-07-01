package dataStructures.Tree;

import dataStructures.Tree.MaxDepthInTree.TreeNode;

public class IsSymmetricTree {
	class Solution {
	    public boolean isSame(TreeNode node1 ,TreeNode node2){
	        if(node1==null && node2==null)
	            return true;
	        if(node1==null && node2!=null)
	            return false;
	        if(node2==null)
	            return false;
	            
	        if(node1.val!=node2.val)
	            return false;
	        return isSame(node1.left,node2.right) && isSame(node1.right,node2.left);
	    }
	        
	    public boolean isSymmetric(TreeNode root) {
	        if(root==null)
	            return true;
	        return isSame(root.left,root.right);
	        
	    }
	}

}
