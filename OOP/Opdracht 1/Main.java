import java.util.Random; 

// javac Main.java
// java Main
// Class Capital letter
// Methods camelCase

public class Main{
    public static void main(String[] args) {
        forLoop();
        whileLoop();
        random();
        count();
        zaagtand();
    }

    public static void zaagtand(){
        System.out.println("Zaagtand");
        int j = 0;
        for(int i = 0; i<= 4; i++){
            
            if(j == 1){
                System.out.println("ss");
                j = 0;
            }else{
                System.out.println("s");
                j++;
            }
        }
        System.out.println();
    }

    public static void count(){
        int total = 0;
        for(int i = 0; i <= 39; i++){
            total = total + i;
        }
        System.out.println("Totaal: " + total);
        System.out.println();
    }

    public static void random(){
        System.out.println("random");
        for(int i = 1; i <= 10; i++){            
            double n = Math.random();            
            System.out.println(i + " " + n);
        }        
        System.out.println();   
    }

    public static void forLoop(){
        System.out.println("ForLoop");
        for(int i = 1; i <= 10; i++){
            System.out.println(i);            
        }        
        System.out.println();
    }

    public static void whileLoop(){
        System.out.println("WhileLoop");
        int count = 1;
        while(count <= 10){
            System.out.println(count);
            count++;
        }        
        System.out.println();
    }
}