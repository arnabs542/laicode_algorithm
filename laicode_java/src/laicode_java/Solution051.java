package laicode_java;

import java.util.*;

public class Solution051 {

	//    Insert In Binary Search Tree
	//    Insert a key in a binary search tree if the binary search tree does not already contain the key. Return the root of the binary search tree.
	//        
	//        Assumptions
	//        
	//        There are no duplicate keys in the binary search tree
	//        
	//        If the key is already existed in the binary search tree, you do not need to do anything
	//            
	//            Examples
	//            
	//                  5
	//            
	//                /    \
	//            
//               3        8
//            
//             /   \
//            
//            1     4
//            
//            insert 11, the tree becomes
//            
//                  5
//            
//                /    \
//            
//               3        8
//            
//             /   \        \
//            
//            1     4       11
//            
//            insert 6, the tree becomes
//            
//                   5
//            
//                 /    \
//            
//               3        8
//            
//             /   \     /  \
//            
//            1     4   6    11

	TreeNode insert(TreeNode root, int value) {
		// Write your solution here.
		if (root == null) {
			root = new TreeNode(value);
			return root;
		}
		// 我们需要parent帮我们插入左边还是右边
		TreeNode parent = null;
		TreeNode current = root;
		while (current != null) {
			if (current.key == value) {
				return root;
			} else if (current.key>value) {
				parent = current;
				current = current.left;
			} else {
				parent = current;
				current = current.right;
			}
		}
		//退出时，current==null
		if (parent.key<value) {
			parent.right = new TreeNode(value);
		} else {
			parent.left = new TreeNode(value);
		}
		return root;
	}
	
	public static void main(String[] args) {


	}
}
