import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String>{
	
	private TreeNode <String> root;
	
	/**
	 * defualt constructor for MorseCodeTree class
	 */
	public MorseCodeTree()
	{
		root = null;
		buildTree();
	}
	
	/**
	 * Returns a reference to the root
	 * @return reference to root
	 */
	@Override
	public TreeNode getRoot() {
		return root;
	}

	/**
	 * sets the root of the Tree
	 * @param newNode a TreeNode<T> that will be the new root
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {
		root = new TreeNode<String>(newNode);
	}

	/**
	 * Adds result to the correct position in the tree based on the code
	 * This method will call the recursive method addNode
	 * 
	 * @param code the code for the new node to be added
	 * 
	 */
	@Override
	public void insert(String code, String result) {
		if(root==null){
			root=new TreeNode<String>(result);
		}
		else {
			addNode(root,code,result);
		}
	}

	/**
	 * This is a recursive method that adds element to the correct position 
	 * in the tree based on the code.
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of addNode
	 * @param letter the data of the new TreeNode to be added
	 */
	@Override
	public void addNode(TreeNode<String> root,String code,String letter) {
		
		if(code.length()>1) {
			if(code.charAt(0)=='-') {
				addNode(root.right,code.substring(1),letter);
			}
			else {
				addNode(root.left,code.substring(1),letter);
			}
		}
		else {
			if(code.equals(".")) {
				root.left=new TreeNode<String>(letter);
			}
			else {
				root.right=new TreeNode<String>(letter);
			}
		}
		
	}

	/**
	 * Fetch the data in the tree based on the code
	 * This method will call the recursive method fetchNode
	 * 
	 * @param code the code that describes the traversals within the tree
	 * @return the result that corresponds to the code
	 */
	@Override
	public String fetch(String code) {
		String result=fetchNode(root,code);
		return result;
	}

	/**
	 * This is the recursive method that fetches the data of the TreeNode
	 * that corresponds with the code
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of fetchNode
	 * @return the data corresponding to the code
	 */
	@Override
	public String fetchNode(TreeNode root, String code) {
		String letter="";
		if(code.length()>1) {
			if(code.charAt(0)=='.') {
				letter+=fetchNode(root.left,code.substring(1));
			}
			else {
				letter+=fetchNode(root.right,code.substring(1));
			}
			
		}
		else {
			if(code.equals(".")) {
				letter+=root.left.getData();
				return letter;
			}
			else { 
				letter+=root.right.getData();
				return letter;
			}
		}
		return letter;
	}

	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @param data data of node to be deleted
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * This method builds the LinkedConverterTree by inserting TreeNodes<T>
	 * into their proper locations
	 * 
	 */
	@Override
	public void buildTree() {
		//root Level
		insert("","");
		//Level 1
		insert(".","e"); insert("-","t");
		//Level 2
		insert("..","i"); insert(".-","a");insert("-.","n"); insert("--","m");
		//Level 3
		insert("...","s"); insert("..-","u");insert(".-.","r"); insert(".--","w");insert("-..","d"); 
		insert("-.-","k");insert("--.","g"); insert("---","o");
		//Level 4
		insert("....","h"); insert("...-","v");insert("..-.","f"); insert(".-..","l");insert(".--.","p"); 
		insert(".---","j");insert("-...","b"); insert("-..-","x");insert("-.-.","c"); insert("-.--","y");
		insert("--..","z"); insert("--.-","q");							
	}

	/**
	 * Returns an ArrayList of the items in the linked converter Tree in LNR (Inorder) Traversal order
	 * Used for testing to make sure tree is built correctly
	 * @return an ArrayList of the items in the linked Tree
	 */
	@Override
	public ArrayList toArrayList() {
		ArrayList<String>result=new ArrayList<String>();
		LNRoutputTraversal(root,result);
		return result;
	}

	/**
	 * The recursive method to put the contents of the linked converter tree in an ArrayList<T> 
	 * LNR (Inorder)
	 * @param root the root of the tree for this particular recursive instance
	 * @param list the ArrayList that will hold the contents of the tree in LNR order
	 */
	@Override
	public void LNRoutputTraversal(TreeNode root, ArrayList list) {
		if(root.left==null && root.right==null) {
			list.add(root.getData()+" ");
		}
		else {
			if(root.left!=null) {
				LNRoutputTraversal(root.left,list);
				list.add(root.getData()+" ");
			}
			if(root.right!=null) {
				LNRoutputTraversal(root.right,list);
			}
		}
	}
}
