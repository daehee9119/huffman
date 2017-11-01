package tree;

public interface Iterator<T> {

	public boolean hasNext();
	
	public BinaryNode<T> next();
	
	public void remove();
	
}
