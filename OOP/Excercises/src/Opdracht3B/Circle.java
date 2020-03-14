package Opdracht3B;

public class Circle {

    private int rad;
    private int x;
    private int y;


    public Circle(int rad, int x, int y) throws IllegalArgumentException{
        if(rad <= 0){
            throw new IllegalArgumentException ("Radius has to be bigger than 0!");
        }else this.rad = rad;
        this.x = x;
        this.y = y;
    }

    public String toString(){
        String s = String.format("circle (%d, %d) of radius: %d", x, y, rad);
        return s;
    }
}
