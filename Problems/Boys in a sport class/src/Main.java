import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //h represents the integer height of boys in a sports class
        int h1 = scanner.nextInt();
        int h2 = scanner.nextInt();
        int h3 = scanner.nextInt();
        //boolean ordered returns true if boys are arranged in either ascending or descending order
        boolean ordered = h1 <= h2 && h2 <= h3 || h1 >= h2 && h2 >= h3;
        System.out.println(ordered);
    }
}