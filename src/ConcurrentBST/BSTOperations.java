package ConcurrentBST;

public class BSTOperations {

	/**
	 * @author Dinesh Appavoo
	 *
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new BSTOperations().doOperationsOnBST();
	}
	
	public void doOperationsOnBST()
	{
		BST bst=new BST();
		bst.insert(10);
		bst.insert(5);
		bst.insert(15);
		bst.insert(3);
		bst.insert(8);
		bst.insert(2);

		
		//bst.inOrderTraversal();
		bst.delete(2);
		
		boolean isAvail=bst.lookUp(15);
		System.out.println("Available: "+isAvail);
		bst.inOrderTraversal();
	}

}
