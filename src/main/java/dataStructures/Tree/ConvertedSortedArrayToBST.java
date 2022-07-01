package dataStructures.Tree;

public class ConvertedSortedArrayToBST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	class Solution {
		public TreeNode treeBuild(int[] nums, int start, int end) {
			if (start > end)
				return null;
			int mid = (end + start) / 2;
			TreeNode node = new TreeNode(nums[mid]);
			node.left = treeBuild(nums, start, mid - 1);
			node.right = treeBuild(nums, mid + 1, end);
			return node;
		}

		public TreeNode sortedArrayToBST(int[] nums) {
			int n = nums.length;
			return treeBuild(nums, 0, n - 1);

		}
	}

}
