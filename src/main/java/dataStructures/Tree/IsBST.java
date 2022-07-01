package dataStructures.Tree;

import dataStructures.Tree.MaxDepthInTree.TreeNode;

public class IsBST {
	class Solution {
	    public boolean isBst(TreeNode root,long minV,long maxV){
	        if(root==null)
	            return true;
	        if(root.val<=minV || root.val>=maxV)
	            return false;
	        return isBst(root.left,minV,root.val)&& isBst(root.right,root.val,maxV);
	    }
	    public boolean isValidBST(TreeNode root) {
	        return isBst(root,Long.MIN_VALUE,Long.MAX_VALUE);
	        // if(root==null)
	        //     return true;
	        // List<Integer> list = new ArrayList<>();
	        // inorder(root,list);
	        // int flag=1;
	        // for(int i=1;i<list.size();i++){
	        //     if(list.get(i-1)>=list.get(i)){
	        //         flag=0;
	        //         break;
	        //     }
	        // }
	        // if(flag==1)
	        //     return true;
	        // return false;   
	    }
	 // public void inorder(TreeNode root, List<Integer> list){
	    //     if(root==null)
	    //         return;
	    //     inorder(root.left,list);
	    //     list.add(root.val);
	    //     inorder(root.right,list);
	    //     return;
	    // }
	}
}
