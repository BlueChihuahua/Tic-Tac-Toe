package tictactoe;
import java.util.Scanner;

public class Main {
    public enum GameState {
        NotFinished, Draw, XWins, OWins, Impossible
    }
    public static void main(String[] args) {
        // write your code here
        Scanner scan = new Scanner(System.in);
        char[][] gameField = startField(); //generate empty field
        String data = getField(scan); //user input initial field state
        updateField(gameField, data); //update initial field state
        printField(gameField); //display initial field
//        char[][] testField = getChars(data);
        // X = 88  0 = 79 _ = 95
//        testState(testField);

    }
//update? to update inner field
    private static char[][] getChars(String data) {
        char[][] testField = new char[3][3];
        int c = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                testField[i][j] = data.charAt(c);
                c++;
            }
        }
        return testField;
    }
// not testing field for condition in this phase
//    private static void testState(char[][] testField) {
//        //test variables
//        boolean oSolved = false;
//        boolean impossible = false;
//        boolean xSolved = false;
//        boolean empty = false;
//        //test field has impossible
//        //horizontal
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 1; j++) {
//                if (testField[i][j] == 'X' && testField[i][j + 1] == 'X' && testField[i][j + 2] == 'X') {
//                    xSolved = true;
//                    break;
//                }
//            }
//        }
//        //vertical
//        for (int j = 0; j < 3; j++) {
//            for (int i = 0; i < 1; i++) {
//                if (testField[i][j] == 'X' && testField[i + 1][j] == 'X' && testField[i + 2][j] == 'X') {
//                    xSolved = true;
//                    break;
//                }
//            }
//        }
//        //diagonal
//        if (testField[0][0] == 'X' && testField[1][1] == 'X' && testField[2][2] == 'X') {
//            xSolved = true;
//        }
//        if (testField[2][0] == 'X' && testField[1][1] == 'X' && testField[0][2] == 'X') {
//            xSolved = true;
//        }
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 1; j++) {
//                if (testField[i][j] == 'O' && testField[i][j + 1] == 'O' && testField[i][j + 2] == 'O') {
//                    oSolved = true;
//                    break;
//                }
//            }
//        }
//        //vertical
//        for (int j = 0; j < 3; j++) {
//            for (int i = 0; i < 1; i++) {
//                if (testField[i][j] == 'O' && testField[i + 1][j] == 'O' && testField[i + 2][j] == 'O') {
//                    oSolved = true;
//                    break;
//                }
//            }
//        }
//        //diagonal
//        if (testField[0][0] == 'O' && testField[1][1] == 'O' && testField[2][2] == 'O') {
//            oSolved = true;
//        }
//        if (testField[2][0] == 'O' && testField[1][1] == 'O' && testField[0][2] == 'O') {
//            oSolved = true;
//        }
//        // test count x
//        int countX = 0;
//        for (int row = 0; row < 3; row++) {
//            for (int col = 0; col < 3; col++) {
//                if (testField[row][col] == 'X') countX++;
//            }
//        }
//        //test count o
//        int countO = 0;
//        for (int row = 0; row < 3; row++) {
//            for (int col = 0; col < 3; col++) {
//                if (testField[row][col] == 'O') countO++;
//            }
//        }
//        //compare count x and count o
//        if (Math.abs(countO - countX) > 1) {
//            impossible = true;
//        }
//
//        if (xSolved && oSolved || impossible) {
//            impossible = true;
//            System.out.println("Impossible");
//        }
//        // test field x wins
//        if (xSolved && !oSolved) {
//            System.out.println("X wins");
//        }
//        //test field o wins
//
//        if (oSolved && !xSolved) {
//            System.out.println("O wins");
//        }
//        //test field game not finished
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                if (testField[i][j] == '_') {
//                    empty = true;
//                    break;
//                }
//            }
//        }
//        if (empty && !xSolved && !oSolved && !impossible) {
//            System.out.println("Game not finished");
//        }
//        //test field draw
//
//        if (!empty && !xSolved && !oSolved && !impossible) {
//            System.out.println("Draw");
//        }
//    }

    private static void printField(char[][] gameField) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(gameField[i][j]);
            }
            System.out.println();
        }
    }
//create a second function similar to this function that will update individual move after user inputs initial board state
    //function should input i j and output the updated 3x3 grid with the user's move included, assume user is X
    //function should test input i and j to make sure they are in range (1-3 inclusive)
    //function should test input is an integer
    //function should test if cell is occupied before updating
    //function should convert i & j to array location by subtracting 1 from each
    // Int Int -> 3d array (3x3)
    //may need to split functions to a - check user input is suitable, b - check space occupied, c - update field.
    private static void updateField(char[][] gameField, String data) {
        int c = 0;
        for (int i = 1; i < 4; i++) {
            for (int j = 2; j < 7; j+=2) {
                gameField[i][j] = data.charAt(c);
                c++;
            }
        }
    }
//will get initial field start of phase
    private static String getField(Scanner scan) {
        System.out.print("Enter cells: ");
        return scan.next();
    }

    private static char[][] startField() {
        return new char[][]{
                    {'-', '-', '-', '-', '-', '-', '-', '-', '-'},
                    {'|', ' ', '_', ' ', '_', ' ', '_', ' ', '|'},
                    {'|', ' ', '_', ' ', '_', ' ', '_', ' ', '|'},
                    {'|', ' ', '_', ' ', '_', ' ', '_', ' ', '|'},
                    {'-', '-', '-', '-', '-', '-', '-', '-', '-'},
            };
    }
}

