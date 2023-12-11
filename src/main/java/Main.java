import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //operadores bitwise
        /*
        Scanner sc = new Scanner(System.in);

        int mask = 0b00100000;
        int n = sc.nextInt();

        if ((n & mask) != 0) {
            System.out.println("6th bit is true!");
        } else {
            System.out.println("6th bit is false!");
        }*/
        String s = "potato apple lemon";

        String[] vect = s.split(" ");

        System.out.println(vect[0]);
        System.out.println(vect[1]);
        System.out.println(vect[2]);

    }
}