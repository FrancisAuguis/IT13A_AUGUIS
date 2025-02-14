
package Prelim;


public class Act1_Arithmetic_Operators {
     public static void main(String[] org){
             
        int numb1 = 10;
        int numb2 = 6;
        int numb3 = 4;
        int numb4 = 3; 
        
        
        
        int AUGUIS1 = numb1 * numb3 + numb2;
        int UNDO1 = numb1 - numb3;
        int AUGUIS2 = UNDO1 % numb2;
        int UNDO2 = numb1 + numb3 + numb2;
        int AUGUIS3 = UNDO2 / numb4;
        int UNDO3 = numb3 * numb3;
        int AUGUIS4 = numb1 * numb2 - UNDO3;
        
          System.out.println("10 * 4 + 6 ="+ AUGUIS1);
         System.out.println("(10-4) % 6 = "+ AUGUIS2);
            System.out.println("(10 + 4 + 6)/3 = "+ AUGUIS3);
               System.out.println("10 * 6 -(4 * 4 ) = "+ AUGUIS4);
               
     }
}