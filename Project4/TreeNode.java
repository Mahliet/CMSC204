
public class TreeNode<T> extends java.lang.Object
{
	T data;
	TreeNode<T> left;
	TreeNode<T> right;
	
	/**
	 * Constructor -Creates a new TreeNode with left and right child set to null and data set to the dataNode
	 * @param node - the data to be stored in the TreeNode
	 */
	public TreeNode(T dataNode)
	{
		this.data=dataNode;
		this.right=null;
		this.left=null;
		
	}
	
	/**
	 * Makes deep copies
	 * @param node - node to make copy of
	 */
	public TreeNode(TreeNode<T> node)
	{
		new TreeNode<T>(node);
	}
	
	/**
	 * Returns the data within this TreeNode
	 * @return - the data within the TreeNode
	 */
	public T getData()
	{
		return data;
	}
}
