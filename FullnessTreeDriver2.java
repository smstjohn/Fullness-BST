//Fullness experiment part 2 driver code

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class FullnessTreeDriver2 {

   public static void main(String[] args) {
    
      List<FullnessTree> fTreeList = new ArrayList<FullnessTree>();
      FullnessTree<Integer> fTree = new FullnessTree<Integer>();
      Random randomNum = new Random();
    
      int sumHeight = 0;
      double sumFullness = 0;    

      //loop 10 times, setting k=10 at first and incrementing by 10
      //expand the application so that it generates 10 trees for each value of k varying between
      // 10 and 90, in increments of 10 for a total of 90 trees
      for (int k=10; k <= 90; k+=10) { 
         for (int i=0; i < 10; i++) { //each loop iteration will create 10 trees with 1000 nodes each
            fTree = new FullnessTree();
            for (int j = 0; j < 1000; j++) {
               if (k >= randomNum.nextInt(99) + 1) { //each time an integer is created, it has a k% chance of being 42
                  fTree.add(42);
               }else{ 
                  fTree.add(randomNum.nextInt(3000) + 1); // other integers have a (1-k)% chance of being generated
               }           
            }
            fTreeList.add(fTree);
         }
         for (int i = 0; i < fTreeList.size(); i++) {
            sumHeight += fTreeList.get(i).recHeight(fTreeList.get(i).getRoot());
            sumFullness += fTreeList.get(i).fRatio(fTreeList.get(i).getRoot());
            
         }
         //output average height
         System.out.println("\nHeight: " + sumHeight/fTreeList.size());
         
         //output average fRatio
         System.out.println("Fullness Ratio: " + sumFullness/fTreeList.size());
         
         sumHeight = 0;
         sumFullness = 0;
         fTreeList = new ArrayList<FullnessTree>();
      }
   }
}