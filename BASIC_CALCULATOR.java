package MIDTERM;

import java.util.Scanner;

public class BASIC_CALCULATOR {

      public static int addition(int makie,int ancla){
        return makie + ancla;
    }
    public static int subtraction(int makie,int ancla){
        return makie - ancla;
    }
    public static int Multiplication(int makie,int ancla){
        return makie * ancla;
    }
    public static int Division(int makie,int ancla){
        return makie / ancla;
    }
    public static float percentage(float mc,float francis){
        return mc * (francis/100);
        
    }
    
    public static void main(String[] args) {
        
        int result1 = addition(5,5);
        System.out.println("Addition: " + result1);
        int result2 = subtraction(5,5);
        System.out.println("Subtraction: " + result2);
        int result3 = Multiplication(5,5);
        System.out.println("Multiplication: " + result3);
        int result4 = Division(5,5);
        System.out.println("Division: " + result4);
        float result5 = percentage(100,50);
        System.out.println("Percentage: " + result5 );
    }
    

    
}