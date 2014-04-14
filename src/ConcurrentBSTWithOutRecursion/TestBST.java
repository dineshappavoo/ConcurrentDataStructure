package ConcurrentBSTWithOutRecursion;

public class TestBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new TestBST().doOperationsOnBST();
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
		bst.insert(10);


		
		//bst.inOrderTraversal();
		boolean isTrue=bst.delete(90);
		System.out.println("Deleted?"+isTrue);
		
		
		boolean isAvail=bst.lookUp(5);
		System.out.println("Available: "+isAvail);
		bst.inOrderTraversal();
	}

}
