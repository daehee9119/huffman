package tree;

public interface BinaryTreeInterface<T> extends TreeInterface<T>,TreeIteratorInterface<T> {
	
	public void setTree(T RootData);
	
	public void setTree(T RootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree);
	
}
