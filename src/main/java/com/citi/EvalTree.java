package com.citi;

public class EvalTree {

	public static double evaluateTree(TreeNode node) throws NumberFormatException {

		if (node == null) {
			// throw NullNodeException
			return 0;
		} else if (node.getLeft() == null && node.getRight() == null) {
			return Double.parseDouble(node.getValue());
		}

		if (node.getValue().equals("+"))
			return evaluateTree(node.getLeft()) + evaluateTree(node.getRight());

		else if (node.getValue().equals("-"))
			return evaluateTree(node.getLeft()) - evaluateTree(node.getRight());

		else if (node.getValue().equals("*"))
			return evaluateTree(node.getLeft()) * evaluateTree(node.getRight());

		else if (node.getValue().equals("/"))
			return evaluateTree(node.getLeft()) / evaluateTree(node.getRight());

		else if (node.getValue().equals("%"))
			return evaluateTree(node.getLeft()) % evaluateTree(node.getRight());

		else if (node.getValue().equals("^"))
			return Math.pow(evaluateTree(node.getLeft()), evaluateTree(node.getRight()));

		else
			// throw InvalidOperatorException
			return 0;
	}

	public static void main(String args[]) {

		TreeNode root = new TreeNode("+");

		root.setLeft(new TreeNode("21"));

		TreeNode rightTree = new TreeNode("*");
		rightTree.setRight(new TreeNode("22"));
		
		TreeNode rightLeftNode = new TreeNode("%");
		rightLeftNode.setLeft(new TreeNode("11"));
		rightLeftNode.setRight(new TreeNode("3"));

		
		rightTree.setLeft(rightLeftNode);
		
		root.setRight(rightTree);

		/*
		 * TreeNode root = new TreeNode('*');
		 * 
		 * root.left = new TreeNode('1'); root.right = new TreeNode('2');
		 */
		try {
			System.out.println(evaluateTree(root));
		} catch (NumberFormatException e) {
			System.out.println("Invalid Number value in the node...");
		}
	}

}

class TreeNode {

	private String value;
	private TreeNode left;
	private TreeNode right;

	TreeNode(String value, TreeNode left, TreeNode right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	TreeNode(String value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

}
