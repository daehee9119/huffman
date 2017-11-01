package tree;

public class HuffmanTree<T> extends BinaryTree<T> {
	
	public HuffmanTree(){
		super();
	}
	
	public BinaryNodeInterface<T> getLeftChild(){
		return super.getRootNode().getLeftChild();			
	}
	
	public BinaryNodeInterface<T> getRightChild(){
		return super.getRootNode().getRightChild();			
	}
	
	public void setLeftChild(BinaryNodeInterface<T> left){
		super.getRootNode().setLeftChild(left);
	}
	
	public void setRightChild(BinaryNodeInterface<T> right){
		super.getRootNode().setRightChild(right);
	}
	
	public String setEncode(BinaryNode<T> leaf){
		String result = "";
		BinaryNode<T> root = (BinaryNode<T>)leaf.getRoot();
		BinaryNode<T> prev = leaf;
		while(root!=null){
			if(root.getLeftChild().equals(prev)){
				result = "0"+result;
			}else if(root.getRightChild().equals(prev)){
				result = "1"+result;
			}//if close
			prev = root;
			root = (BinaryNode<T>)root.getRoot();
		}//while close
		return result;
	}
	
}
