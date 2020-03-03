//Fullness experiment Class

import ch07.trees.*;
import support.*;
import java.util.*;   // Iterator, Comparator
import support.BSTNode;      

public class FullnessTree<T> extends BinarySearchTree<T> {

   public BSTNode<T> getRoot() {
      return root;
   }

   //returns the height of a tree using recursion
   public int recHeight (BSTNode<T> node) {
      int lHeight;
      int rHeight;
      int recHeight = 0;
      
      //start at the root
      //go to the left node << recursion
      //until no more left nodes
      //go back up one level
      //for each level increment the height variable     
      if (root == null) {
         return 0; 
      } else { 
         // compute the depth of each subtree 
         if (node != null) {
            lHeight = recHeight(node.getLeft());
            rHeight = recHeight(node.getRight());
            
            if (lHeight > rHeight){
               recHeight = lHeight + 1;
            }else{
               recHeight = rHeight + 1;
            }
         }
         return recHeight;
      }
   }
      
   //minHeight method to implement in fRatio method
   public int minHeight(BSTNode<T> root) {
       if (root == null) {
           return 0;
       } else {
           if (root.getRight() == null && root.getLeft() == null) {
               return 1;
           } else {
               /* Check the height of the right nodes and return the value */
               if (root.getRight() == null) {
                   return minHeight(root.getRight());
               }
               /* Check the height of the left nodes and return the value */
               if (root.getLeft() == null) {
                   return minHeight(root.getLeft());
               }
           }
           return Math.min(minHeight(root.getRight()), minHeight(root.getLeft())) + 1;
       }
   }
  //method that returns the fullness ratio of the tree
   public double fRatio(BSTNode<T> root) {
   
      //ratio between the minimum height and the maximum height
      return (double) minHeight(root) / recHeight(root);
   }   
   
   //added this method to override book file
   //book file seemed to have a typo(?) 
   public boolean add (T element) {
   // Adds element to this BST. The tree retains its BST property.
  
    BSTNode<T> newNode = new BSTNode<T>(element);
    BSTNode<T> prev = null, curr = null;
    
    if (root == null)
      root = newNode;
    else
    {
      curr = root;
      while (curr != null)
      {
        if (comp.compare(element, curr.getInfo()) <= 0)
        {
          prev = curr;
          curr = curr.getLeft();
        }
        else
        {
          prev = curr;
          curr = curr.getRight();
        }
      }
      if (comp.compare(element, prev.getInfo()) <= 0)
        prev.setLeft(newNode);
      else
        prev.setRight(newNode);//setRight?, previously said 'setLeft'
    }
    return true;
  } 
}