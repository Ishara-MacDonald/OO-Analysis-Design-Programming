package Opdracht3B;

public class Main {

    public static void main(String[] args) throws IllegalArgumentException{
        Circle c1 = null, c2 = null;

        try {
            c1 = new Circle(10, 0, 0);
            c2 = new Circle(0, 10, 10);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }

        System.out.println(c1);
        System.out.println(c2);
    }

}

