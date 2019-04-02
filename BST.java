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
			return find(node.getLeft(), value);
		} else {
			return find(node.getRight(), value);
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
			BSTNode newNode = insert(node.getRight(), value);
			node.setRight(newNode);
		} else {
			BSTNode newNode = insert(node.getLeft(), value);
			node.setLeft(newNode);
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

	public Comparable removeSmallest(BSTNode node){
		if (node.getLeft().getLeft() == null){
			Comparable smallest = node.getLeft().getData();
			node.setLeft(node.getLeft().getRight());
			return smallest;
		} else {
			return removeSmallest(node.getLeft());
		}
	}

	public void delete(Comparable value){
		root = delete(root, value);
	}

	private BSTNode delete(BSTNode node, Comparable value){
		if (node == null){
			return null;
		}
		if (node.getData().compareTo(value) == 0){
			if (node.getLeft() == null){
				return node.getRight();
			} else if (node.getRight() == null){
				return node.getLeft();
			} else {
				if (node.getRight().getLeft() == null){
					node.setData(node.getRight().getData());
					node.setRight(node.getRight().getRight());
					return node;
				} else {
					node.setData(removeSmallest(node.getRight()));
					return node;
				}
			}
		} else if (node.getData().compareTo(value) < 0){
			node.setRight(delete(node.getRight(), value));
		} else {
			node.setLeft(delete(node.getLeft(), value));
		}
		return node;
	}
}