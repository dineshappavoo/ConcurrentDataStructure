/**
 * 
 */
package ConcurrentBSTWithOutRecursion;

import java.util.Stack;

/**
 * @author Dinesh Appavoo
 *
 */

public class BST
{
	private TreeNode parentHead;
	//Public constructor for BST
	public BST()
	{
		parentHead=new TreeNode(Integer.MAX_VALUE);	
	}

	/**
	 * This method inserts the input key in the respective location in BST
	 * 
	 * @param root
	 * @param key
	 * @return
	 */
	public boolean insert(int key)
	{
		TreeNode pnode = parentHead;
		TreeNode node = pnode.left;
		while(node!=null) //left or right subtree
		{
			if(node.key>key)
			{
				pnode=node;
				node=node.left;
			}else if(node.key<key)
			{
				pnode=node;
				node=node.right;
			}else if(node.key==key)
				return false;
		}
		if(pnode.key>key)
			pnode.left=new TreeNode(key);
		else if(pnode.key<key)
			pnode.right=new TreeNode(key);
		else if(pnode.key==key) // duplicate values
		{
			return false;
		}
		return true;

	}

	/**
	 * This method deletes the given input key from the BST
	 * 
	 * @param key
	 */
	public boolean delete(int key)
	{
		TreeNode pnode=parentHead;
		TreeNode node=pnode.left;
		boolean keyFound=false;
		while(node!=null) //left or right subtree
		{
			if(node.key>key)
			{
				if(node.left!=null)
				{
					pnode=node;
					node=node.left;
				}else
					return false;
			}else if(node.key<key)
			{
				if(node.right!=null)
				{
					pnode=node;
					node=node.right;
				}else
					return false;
			}else if(node.key==key)
			{
				keyFound=true;
				break;
			}
		}	
		if(!keyFound||node==null)
		{
			return false;

		}else if(node.key==key)
		{
			if(node.left==null) //Case 1:If both the left and right sub tree is null or either of the subtree  
			{
				if(pnode.left==node)
					pnode.left=node.right;
				else
					pnode.right=node.right;
				return true;

			}else if(node.right==null)
			{
				if(pnode.left==node)
					pnode.left=node.left;
				else
					pnode.right=node.left;
				return true;
			}
			else if(node.left!=null&&node.right!=null) //Case 2: If both left and right sub tree is not empty
			{
				TreeNode rNode=node.right;
				TreeNode rlNode=rNode.left;
				if(rlNode==null)
				{
					node.key=rNode.key;
					node.right=rNode.right;
				}else
				{
					while(rlNode.left!=null)
					{
						rNode=rlNode;
						rlNode=rlNode.left;
					}
					if(rlNode.left==null)
					{
						node.key=rNode.key;
						rNode=rlNode;
					}
				}
				return true;
			}
		}

		return false;
	}

	/**
	 * This method returns true if the given input key is available in the BST
	 * 
	 * @param key
	 * @return
	 */
	public boolean lookUp(int key)
	{
		TreeNode node=parentHead.left;
		if(node==null)
			return false;
		while(node.key>key||node.key<key) //left or right subtree
		{
			if(node.key>key)
			{
				if(node.left!=null)
					node=node.left;
				else
					return false;
			}else if(node.key<key)
			{
				if(node.right!=null)
					node=node.right;
				else
					return false;
			}
		}
		if(node.key==key)
		{
			return true;
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
		inOrderTraversal(parentHead.left);
	}

	public void treeInOrderTraversal(TreeNode root)

	{

		TreeNode current=root;

		if(root==null)

			return;

		while(current!=null)

		{

			if(current.left==null)

			{

				System.out.println(current.key);

				current=current.right;

			}else

			{

				TreeNode temp=current.left;

				while(temp.right!=null&&temp.right!=current)
					temp=temp.right;
				if(temp.right==null)

				{
					temp.right=current;
					current=current.left;
				}else

				{
					temp.right=null;
					System.out.println(current.key);
					current=current.right;
				}
			}
		}
	}

	public void inOrderUsingStack(TreeNode root)
	{
		if(root==null)
			return;
		TreeNode current=root;
		Stack<TreeNode> S=new Stack<TreeNode>();
		boolean done=false;
		while(!done)
		{
			if(current.left!=null)
			{
				S.push(current);
				current=current.left;
			}else 

			{
				if(!S.isEmpty())
				{
					TreeNode temp=S.pop();
					System.out.println(temp.key);
					current=current.right;
				}else
				{
					done=true;
				}
			}
		}
	}


	public void inOrderTraversal(TreeNode root)
	{
		if(root==null)
			return;
		inOrderTraversal(root.left);
		System.out.println(root.key);
		inOrderTraversal(root.right);
	}
}
