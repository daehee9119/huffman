package tree;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BinaryTree<T> implements BinaryTreeInterface<T>{

	private BinaryNodeInterface<T> root;
	
	public BinaryTree(){
		this(null);
	}
	
	public BinaryTree(T rootData){
		root = new BinaryNode<T>(rootData);
	}
	
	public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree){
		privateSetTree(rootData, leftTree, rightTree);
	}
	
	public void setTree(T rootData){
		root = new BinaryNode<T>(rootData);
	}
	
	public void setTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree){
		privateSetTree(rootData, leftTree, rightTree);
	}

	private void privateSetTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree){
		root = new BinaryNode<T>(rootData);
		
		if( (leftTree != null) && (!leftTree.isEmpty()) )
			root.setLeftChild(leftTree.root);
		
		if( (rightTree != null) && (!rightTree.isEmpty()) ){
			if(rightTree != leftTree)
				root.setLeftChild(rightTree.root);
			else
				root.setRightChild(rightTree.root);
		}
		
		if( (leftTree != null) && (leftTree != this) )
			leftTree.clear();
		
		if( (rightTree != null) && (rightTree != this) )
			rightTree.clear();
	
	}
	
	@Override
	public T getRootData() {
		// TODO Auto-generated method stub
		T rootData = null;
		if(root != null)
			rootData = root.getData();
		
		return rootData;
	}
	
	protected void setRootData(T rootData){
		root.setData(rootData);
	}
	
	protected void setRootNode(BinaryNodeInterface<T> rootNode){
		root = rootNode;
	}
	
	protected BinaryNodeInterface<T> getRootNode(){
		return root;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return root.getHeight();
	}

	@Override
	public int getNumberOfNodes() {
		// TODO Auto-generated method stub
		return root.getNumberOfNodes();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (root==null);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		root = null;
	}


	@Override
	public void setTree(T RootData, BinaryTreeInterface<T> leftTree,
			BinaryTreeInterface<T> rightTree) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterator<T> getInorderIterator() {
		// TODO Auto-generated method stub
		return new InorderIterator();
	}
	
	private class InorderIterator implements Iterator<T>{

		private Stack<BinaryNodeInterface<T>> nodeStack;
		private BinaryNodeInterface<T> currentNode;
		
		public InorderIterator(){
			nodeStack = new Stack<BinaryNodeInterface<T>>();
			currentNode = root;
		}
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return !nodeStack.isEmpty() || (currentNode!=null);
		}

		@Override
		public   T next() {
			// TODO Auto-generated method stub
			BinaryNodeInterface<T> nextNode = null;
			while(currentNode!=null){
				nodeStack.push(currentNode);
				currentNode = currentNode.getLeftChild();
			}//while end
			if(!nodeStack.isEmpty()){
				nextNode = nodeStack.pop();
				assert nextNode!=null;
				currentNode = nextNode.getRightChild();
			}else throw new NoSuchElementException();
			
			return  (T)nextNode;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}
		
	}

	@Override
	public Iterator<T> getPreorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> getPostorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> getLevelOrderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
