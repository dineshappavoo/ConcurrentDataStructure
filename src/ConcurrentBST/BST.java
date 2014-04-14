/**
 * 
 */
package ConcurrentBST;

/**
 * @author Dany
 *
 */

	public class BST{
	
	public class TreeNode {

	int data;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int data)
	{
		this.data=data;
		this.left=null;
		this.right=null;
	}
	
	public TreeNode()
	{
		this.data=(Integer) null;
		this.left=null;
		this.right=null;
	}
 }
	private TreeNode root;

	public BST()
	{
	root=null;	
	}
		
	/**
	 * This method inserts the input data in the respective location in BST
	 * 
	 * @param root
	 * @param data
	 * @return
	 */
	public void insert(int data)
	{
		root=insert(root, data);
	}
	public TreeNode insert(TreeNode node, int data)
	{
		TreeNode newNode=new TreeNode(data);

		if(node==null)
			return newNode;
		if(node.data>data) //left sub tree
		{
			if(node.left==null)
			{
				node.left=newNode;
			}
			else
			{
				node.left=insert(node.left,data);
			}
		}else if(node.data<data) //Right sub tree
		{
			if(node.right==null)
			{
				node.right=newNode;
			}
			else
			{
				node.right=insert(node.right, data);
			}
			
		}else if(node.data==data) // duplicate values
		{
			return node;
		}
			return node;
			
	}
	
	/**
	 * This method deletes the given input data from the BST
	 * 
	 * @param data
	 */
	public void delete(int data)
	{
		root=delete(root, data);
	}
	public TreeNode delete(TreeNode node,int data)
	{
		if(node==null)
			return null;
		if(node.data==data)
		{
		if(node.left==null&&node.right==null)
		{
			node=null;
			return node;

		}else if(node.left!=null&node.right!=null)
		{
			node.data=getNextRootForDelete(node.left);
			node.left=delete(node.left, node.data);
			return node;
		}else 
		{
			if(node.left==null)
			{
				return node.right;
				
			}else if(node.right==null)
			{
				
				return node.left;
			}
				
		}
		}else if(node.data>data)
		{
			 node.left=delete(node.left, data);
			
		}else if(node.data<data)
		{
			node.right= delete(node.right, data);
		}
			
		return node;
	}
	
	/**
	 * This method returns the next root node value for the node to be deleted
	 * 
	 * @param root
	 * @return
	 */
	public int getNextRootForDelete(TreeNode node)
	{
		if(node.right==null)
		{
			int newRoot=node.data;
			node=null;
			return newRoot;
		}
		return getNextRootForDelete(node.right);
	}
	
	/**
	 * This method returns true if the given input data is available in the BST
	 * 
	 * @param data
	 * @return
	 */
	public boolean lookUp(int data)
	{
		return lookUp(root, data);
	}
	public boolean lookUp(TreeNode node,int data)
	{
		if(node==null)
			return false;
		if(node.data==data)
		{
			return true;
		}
		else if(node.data>data) //Left sub tree
		{
			return lookUp(node.left,data);
				
		}else if(node.data<data) //right sub tree
		{
			return lookUp(node.right, data);
		}
		
			return false;
	}
	
	/**
	 * This method traverse the tree in IN_ORDER traversal
	 * 
	 * @param root
	 */
	public void inOrderTraversal()
	{
		inOrderTraversal(root);
	}
	public void inOrderTraversal(TreeNode node)
	{
		if(node==null)
			return;
		inOrderTraversal(node.left);
		System.out.println(node.data);
		inOrderTraversal(node.right);
	}
}
