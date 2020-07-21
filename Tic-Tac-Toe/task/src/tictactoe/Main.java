package tictactoe;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scan = new Scanner(System.in);
//        possible lines
//        String empty = "     ";
//        String x__ = "X    ";
//        String xx_ = "X X  ";
//        String xxx = "X X X";
//        String o__ = "O    ";
//        String oo_ = "O O  ";
//        String ooo = "O O O";
//        String xo_ = "X O  ";
//        String ox_ = "O X  ";
//        String xox = "X O X";
//        String xoo = "X O O";
//        String oxo = "O X O";
//        String oxx = "O X X";
//        String __x = "    X";
//        String _xx = "  X X";
//        String __o = "    O";
//        String _oo = "  O O";
//        String _xo = "  X O";
//        String _ox = "  O X";
//        String _o_ = "  O  ";
//        String _x_ = "  X  ";
//
//        //output
//        System.out.println(x__);
//        System.out.println(oxx);
//        System.out.println(oo_);
        char[][] gameField = {
                {'-', '-', '-', '-', '-', '-', '-', '-', '-'},
                {'|', ' ', '_', ' ', '_', ' ', '_', ' ', '|'},
                {'|', ' ', '_', ' ', '_', ' ', '_', ' ', '|'},
                {'|', ' ', '_', ' ', '_', ' ', '_', ' ', '|'},
                {'-', '-', '-', '-', '-', '-', '-', '-', '-'},
        };
        String data = scan.next();
        int c = 0;
        for (int i = 1; i < 4; i++) {
            for (int j = 2; j < 7; j+=2) {
                gameField[i][j] = data.charAt(c);
                c++;
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(gameField[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}

