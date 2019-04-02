class BSTNode<T> {
	/* This is the BSTNode class */
	Comparable data; 
	BSTNode left;
	BSTNode right;

	/* constructor */

	public BSTNode(Comparable data){ 
		this.data = data;
		left = null;
		right = null;
	}

	/* mutators or setters */

	public void setLeft(BSTNode left){
		this.left = left;
	}

	public void setRight(BSTNode right){
		this.right = right;
	}

	public void setData(Comparable data){
		this.data = data;
	}

	/* accessors or getters */

	public BSTNode getLeft(){
		return left;
	}

	public BSTNode getRight(){
		return right;
	}

	public Comparable getData(){
		return data;
	}

}

public class BST<T>{
	/* This class is the Binary Search Tree class */

	BSTNode root;


	/* this method will return a boolean if a value is found */
	public boolean find(Comparable value){
		return find(root, value);
	}

	private boolean find(BSTNode node, Comparable value){
		/* base case */
		if (node == null){
			return false;
		}

		if (node.getData().compareTo(value) == 0){
			return true;
		} else if (node.getData().compareTo(value) > 0){
			return find(node.getRight(), value);
		} else {
			return find(node.getLeft(), value);
		}
	}

	/* this method will insert a value in a tree */
	public void insert(Comparable value){
		root = insert(root, value);
	}

	private BSTNode insert(BSTNode node, Comparable value) {
		if (node == null){
			BSTNode newNode = new BSTNode(value);
			return newNode;
		} else if (node.getData().compareTo(value) < 0){
			BSTNode newNode = insert(node.getLeft(), value);
			node.setLeft(newNode);
		} else {
			BSTNode newNode = insert(node.getRight(), value);
			node.setRight(newNode);
		}
		return node;
	}

	/* This method will print out the tree */
	public void print(){
		print(root);
	}

	private void print(BSTNode node){
		if (node != null){
			print(node.getLeft());
			System.out.println(node.getData());
			print(node.getRight());
		}
	}
}