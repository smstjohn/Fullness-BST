//Fullness experiment part 1 driver code

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class FullnessTreeDriver {

   public static void main(String[] args) {
   
      List<FullnessTree> fTreeList = new ArrayList<FullnessTree>();
      FullnessTree<Integer> fTree = new FullnessTree<Integer>();
      Random randomNum = new Random();
      
      for (int i=0; i < 10; i++) {

         fTree = new FullnessTree();
         
         for (int j = 0; j < 1000; j++) {
            fTree.add(randomNum.nextInt(3000) + 1);
         }
         
         fTreeList.add(fTree);
      }
      
      for (int i = 0; i < fTreeList.size(); i++) {
         System.out.println("\nTree #" + (i+1));
         
          //output height
         System.out.println("Height: " + fTreeList.get(i).recHeight(fTreeList.get(i).getRoot()));
      
         //output optimal height
         System.out.println("Optimal Height: " + fTreeList.get(i).minHeight(fTreeList.get(i).getRoot()));
         
         //output fRatio
         System.out.println("Fullness Ratio: " + fTreeList.get(i).fRatio(fTreeList.get(i).getRoot()));
		}
   }
}