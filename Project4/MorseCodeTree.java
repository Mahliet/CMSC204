import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> 
{
	 TreeNode<String> root = null;
	 String letter;
	
	/**
	 * constructor
	 * calls the buildTree method
	 */
	public MorseCodeTree()
	{
		buildTree();
	}
	
	/**
	 * Returns a reference to the root
	 * @Return reference to root
	 */
	
	public TreeNode<String> getRoot()
	{
		return root=root;
	}
	
	/**
	 * sets the root of the MorseCodeTree
	 * @param newNode- a newNode that will be the root of MorseCodeTree
	 */
	
	public void setRoot​(TreeNode<java.lang.String> newNode)

	{
		root = newNode;
	}
	/**
	 * Fetch the data in the tree based on the code This method will call the recursive method fetchNode
	 * @param String
	 * @param code-the code that describes the traversals to retrieve the string (letter)
	 * @return - the string (letter) that corresponds to the code
	 */
	public String fetch(String code) 

	{
		String alpha = fetchNode​(root,code);
		return alpha;
	}
	
	/**
	 * Adds element to the correct position in the tree based on the code
	 * @param root, code, letter
	 */
	public void addNode(TreeNode<java.lang.String> root, java.lang.String code,java.lang.String letter)
	{
		while(code.length()==1)
		{
			if(code.equals("."))
			{
				root.left= new TreeNode<String>(letter);
			}
			else
			{
				root.right = new TreeNode<String>(letter);
			}
			return;
		}
		while(code.length()!=1)
		{
			if(code.substring(0,1).equals("."))
			{
				addNode(root.left,code.substring(1),letter);
			}
			else
			{
				addNode(root.right,code.substring(1),letter);
			}
		}
		return;
	}
	
	/**
	 * Adds element to the correct position in the tree based on the code This method will call the recursive method addNode
	 * @param code - the code for the new node to be added
	 * @param letter
	 */
	@Override
	public void insert(String code, String result)

	{
		addNode(root,code,letter);
		
	}
	
	/**
	 * This is the recursive method that fetches the data of the TreeNode that corresponds with the code A '.' (dot) means traverse to the left. A "-" (dash) means traverse to the right. The code ".-" would fetch the data of the TreeNode stored as the right child of the left child of the root
	 * @param root - the root of the tree for this particular recursive instance of addNode
	 * @param code - the code for this particular recursive instance of addNode
	 * @return the string (letter) corresponding to the code
	 */
	
	public java.lang.String fetchNode​(TreeNode<java.lang.String> root, java.lang.String code)
	{
		while(code.length()==1)
		{
			if(code.equals("."))
			{
				letter= root.left.getData();
			}
			else
			{
				letter = root.right.getData();
			}
			return letter;
		}
		while(code.length()!=1)
		{
			if(code.substring(0,1).equals("."))
			{
				fetchNode​(root.left, code.substring(1));
			}
			else
			{
				fetchNode​(root.right, code.substring(1));
			}
		}
		return letter;
	}
	
	/**
	 * This operation is not supported in the MorseCodeTree
	 * @param data
	 * @return null
	 * @throws java.lang.UnsupportedOperationException
	 */
	public MorseCodeTree delete​(java.lang.String data) throws java.lang.UnsupportedOperationException
	{
		return null;
	}
	
	/**
	 * This operation is not supported in the MorseCodeTree
	 * @return null
	 */
	public MorseCodeTree update() throws java.lang.UnsupportedOperationException
	{
		return null;
	}
	
	/**
	 * This method builds the MorseCodeTree by inserting the nodes of the tree level by level based on the code. 
	 */
	public void buildTree()
	{
		root = new TreeNode<String>("");
		
		insert(".", "e");
		insert("-", "t");

		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");

		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");

		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
	}
	
	/**
	 * Returns an ArrayList of the items in the linked Tree in LNR (Inorder) Traversal order Used for testing to make sure tree is built correctly
	 * @return printTree
	 */
	@Override
	public ArrayList toArrayList() 
	{
		ArrayList<String> print = new ArrayList<String>();
		LNRoutputTraversal​(root, print);
		return print;
	}
	
	/**
	 * The recursive method to put the contents of the tree in an ArrayList in LNR (Inorder)
	 * @param root - the root of the tree for this particular recursive instance
	 * @param list - the ArrayList that will hold the contents of the tree in LNR order
	 */
	public void LNRoutputTraversal​(TreeNode<java.lang.String> root, java.util.ArrayList<java.lang.String> list)
	{
		if(root != null)
		{
			LNRoutputTraversal​(root.left, list);
			list.add(root.getData());
			LNRoutputTraversal​(root.right, list);
		}
	}


	@Override
	public String fetchNode(TreeNode<String> root, String code) 
	{
		while(code.length()==1)
		{
			if(code.equals("."))
			{
				letter= root.left.getData();
			}
			else
			{
				letter = root.right.getData();
			}
			return letter;
		}
		while(code.length()!=1)
		{
			if(code.substring(0,1).equals("."))
			{
				fetchNode​(root.left, code.substring(1));
			}
			else
			{
				fetchNode​(root.right, code.substring(1));
			}
		}
		return letter;
	}

	@Override
	public void setRoot(TreeNode<String> newNode) 
	{
		// TODO Auto-generated method stub
		
	}


	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		// TODO Auto-generated method stub
		
	}

	

	

	

	



	
}