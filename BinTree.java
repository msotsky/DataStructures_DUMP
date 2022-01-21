public class BinTree<T extends Comparable<T>> {
	
	// INSTANCE VARIABLES
	
		TreeNode<T> root;
		
		// CONSTRUCTORS
		
		BinTree(T route){
			root.data = route;
			root.leftChild = null;
			root.rightChild = null;
		}
		
		BinTree(){
			root = null;
		}
		
		/**
		 * This is the private inner class Tree Node
		 * @param <T>
		 */
		private static class TreeNode<T> {
			
			// INSTANCE VARIABLES
			
	        T data;
	        TreeNode<T> leftChild;
	        TreeNode<T> rightChild;
	        
	        // CONSTRUCTORS
	        
	        TreeNode(T data){
	            this.data = data;
	        }
	        
	        TreeNode(T data, TreeNode<T> lChild, TreeNode<T> rChild){
	            this.data = data;
	     	    this.leftChild = lChild;
	            this.rightChild = rChild;
	        }
	        
	        // METHODS
	        
	        private T getData() {
	        	return this.data;
	        }
	        
	        private TreeNode<T> getRightChild(){
	        	return this.rightChild;
	        }
	        
	        private TreeNode<T> getLeftChild(){
	        	return this.leftChild;
	        }
	        
	        private void setRightChild(TreeNode<T> rChild) {
	        	rightChild = rChild;
	        }
	        
	        private void setLeftChild(TreeNode<T> lChild) {
	        	leftChild = lChild;
	        }
	    }
		
		// METHODS
		
		public TreeNode<T> getRoot(){
			return root;
		}
		
		// Add a custom compare method for objects of type T
		public int compare(T elt1, T elt2) {
			return elt1.compareTo(elt2);
		}

		/** 
		   Inserts the given data into the binary tree. 
		   Uses a recursive helper. 
		   Author @NickParlante
		  (Generics by SLR)

		  */ 
		  public void insert(T data) { 
		    root = insert(root, data); 
		  } 
		 

		  /** 
		   Recursive insert -- given a tree node reference, recurse down and 
		   insert the given data into the tree. Returns the new 
		   node reference (the standard way to communicate a changed reference 
		   back to the caller).
		   Author @NickParlante 
		   (Generics and OOP-ified by SLR)
		  */ 
		  private TreeNode<T> insert(TreeNode<T> tNode, T data) { 
		    if (tNode==null) { 
		      tNode = new TreeNode<T>(data); 
		    } 
		    else { 
		      // This is performing an insertion into the tree based on values of the data field
		      if (compare(data,tNode.getData()) < 0) { 
		        tNode.setLeftChild(insert(tNode.getLeftChild(), data)); 
		      } 
		      else { 
		        tNode.setRightChild(insert(tNode.getRightChild(), data)); 
		      } 
		    }

		    return(tNode); // in any case, return the new reference to the caller 
		  } 
		  
		  /** 
		   Returns true if the given target is in the binary tree. 
		   Uses a recursive helper. 
		  */ 
		  public boolean lookup(T data) { 
		    return(lookup(root, data)); 
		  } 
		 

		  /** 
		   Recursive lookup  -- given a node, recur 
		   down searching for the given data. 
		  */ 
		  private boolean lookup(TreeNode<T> tNode, T data) { 
		    if (tNode==null) { 
		      return(false); 
		    }

		    if (data==tNode.getData()) { 
		      return(true); 
		    } 
		    else {
		    	if (compare(data,tNode.getData()) < 0)  { 
		    		return(lookup(tNode.getLeftChild(), data)); 
		    	} 
		    	else { 
		    		return(lookup(tNode.getRightChild(), data)); 
		    	}
		    }
		  } 
		  
		  
		  /**
		   * If you ever want to delete a node containing a particular value from your
		   *  tree, here is the method to do just that...
		   */

		  
		  public boolean delete(T value){
		        TreeNode<T> current = root;
		        TreeNode<T> parent = root;
		        boolean isLeftChild = false;
		        while(current.getData() != value){
		            parent = current;
		            if(compare(value, current.getData())<0){
		                // Move to the left if searched value is less
		                current = current.getLeftChild();
		                isLeftChild = true;
		            }
		            else{
		                // Move to the right if searched value is >=
		                current = current.getRightChild();
		                isLeftChild = false;
		            }
		            if(current == null){
		                return false;
		            }
		        }
		        // if reached here means node to be deleted is found
		        
		        // Leaf node deletion case
		        if(current.getLeftChild() == null && current.getRightChild() == null){
		            // if root node is to be deleted
		            if(current == root){
		                root = null;
		            }
		            // left child
		            else if(isLeftChild){
		                parent.setLeftChild(null);
		            }
		            // right child
		            else{
		                parent.setRightChild(null);
		            }
		        }
		        // Node to be deleted has one child case
		        // Node to be deleted has right child
		        else if(current.getLeftChild() == null){
		            // if root node is to be deleted
		            if(current == root){
		                root = current.getRightChild();
		            }
		            // if deleted node is left child
		            else if(isLeftChild){
		                parent.setLeftChild(current.getRightChild());
		            }
		            // if deleted node is right child
		            else{
		                parent.setRightChild(current.getRightChild());
		            }
		        }
		        // Node to be deleted has left child
		        else if(current.getRightChild() == null){
		            if(current == root){
		                root = current.getLeftChild();
		            }
		            // if deleted node is left child
		            else if(isLeftChild){
		                parent.setLeftChild(current.getLeftChild());
		            }
		            // if deleted node is right child
		            else{
		                parent.setRightChild(current.getLeftChild());
		            }
		        }
		        // Node to be deleted has two children case
		        else{
		            // find in-order successor of the node to be deleted
		            TreeNode<T> successor = findSuccessor(current);
		            if(current == root){
		                root = successor;
		            }
		            // if deleted node is left child
		            else if(isLeftChild){
		                parent.setLeftChild(successor);
		            }
		            // if deleted node is right child
		            else{
		                parent.setRightChild(successor);
		            }
		            successor.setLeftChild(current.getLeftChild());
		        }
		        return true;
		    }
		  
		    /** 
		     * Helper method to find the in-order successor of the deleted node
		     * 
		     */
		    private TreeNode<T> findSuccessor(TreeNode<T> tnode){
		        TreeNode<T> successor = tnode;
		        TreeNode<T> successorParent = tnode;
		        // Start from the right child of the node to be deleted
		        TreeNode<T> current = tnode.getRightChild();
		        while(current != null){
		            successorParent = successor;
		            successor = current;
		            current = current.getLeftChild();
		        }
		        // When in-order successor is in the left subtree 
		        // perform two reference changes here as we have 
		        // access to successorParent
		        if(successor != tnode.getRightChild()){
		            successorParent.setLeftChild(successor.getRightChild());
		            // applicable only when successor is not right child
		            // so doing here
		            successor.setRightChild(tnode.getRightChild());
		        }
		        return successor;
		    }
		 
		    
		    
		    /** 
		    Prints the node values in the "postorder" order. 
		    Uses a recursive helper to do the traversal. 
		   */ 
		   public void printPostorder() { 
		    postOrder(root); 
		    System.out.println(); 
		   }
		   
		   private void postOrder(TreeNode<T> tnode) { 
		     if (tnode == null) return;

		     // first recur on both subtrees 
		     postOrder(tnode.getLeftChild()); 
		     postOrder(tnode.getRightChild());

		     // then deal with the node 
		    System.out.print(tnode.getData() + "  "); 
		   } 
		   
		   /** 
		    Prints the node values in the "preorder" order. 
		    Uses a recursive helper to do the traversal. 
		   */ 
		   public void printPreorder() { 
		    preOrder(root); 
		    System.out.println(); 
		   }
		   
		   private void preOrder(TreeNode<T> tnode) { 
		     if (tnode == null) return;
		     
		     // deal with the node 
			 System.out.print(tnode.getData() + "  "); 
			 
		     // then recur on both subtrees 
		     preOrder(tnode.getLeftChild()); 
		     preOrder(tnode.getRightChild());

		     
		   } 
		   
		   /** 
		    Prints the node values in the "preorder" order. 
		    Uses a recursive helper to do the traversal. 
		   */ 
		   public void printInorder() { 
		    inOrder(root); 
		    System.out.println(); 
		   }
		   
		   private void inOrder(TreeNode<T> tnode) { 
		     if (tnode == null) return;		     
			 
		     // first recur on left subtree
		     inOrder(tnode.getLeftChild()); 
    		 // deal with the node 
			 System.out.print(tnode.getData() + "  ");
			 // then recur on right subtree
		     inOrder(tnode.getRightChild());

		     
		   } 
		    
		    
}
