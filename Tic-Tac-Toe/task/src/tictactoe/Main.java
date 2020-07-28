package tictactoe;
import java.util.Scanner;

public class Main {

    static class moveCoor {
        private final int i;
        private final int j;

        public moveCoor (int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static moveCoor coordinates(String move) {
        int j = Integer.parseInt(String.valueOf(move.charAt(0)));
        int i = Integer.parseInt(String.valueOf(move.charAt(2)));

        return new moveCoor(i, j);
    }
//    public enum GameState {
//        NotFinished, Draw, XWins, OWins, Impossible
//    }
    //merge field check into enum states

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        char[][] gameField = startField(); //generate empty field
        String data = getField(scan); //user input initial field state
        updateField(gameField, data); //update initial field state
        printField(gameField); //display initial field
        boolean badMove = true;
        boolean badCoor = true;
        boolean running = true;
        while (running) {  //test move
            String move = getMove(scan);
            badMove = testMove(move);
//            System.out.println("begin");
//            if (badMove) {
//                move = getMove(scan);
//            }
            if (!badMove && badCoor) {
                moveCoor coor = coordinates(move);
                badCoor = testCoord(coor.i, coor.j, gameField);
                System.out.println("This cell is occupied! Choose another one!");
                return;
//                System.out.println("middle");
//                System.out.println("badCoor");
            } else if (!badMove && !badCoor) {
                moveCoor coor = coordinates(move);
                updateFieldMoveX(gameField, coor.i, coor.j);
                printField(gameField);
                running = false;
            }

        }


//        char[][] testField = getChars(data);
        // X = 88  0 = 79 _ = 95
//        testState(testField);

    }
//creates test field
//    private static char[][] getChars(String data) {
//        char[][] testField = new char[3][3];
//        int c = 0;
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                testField[i][j] = data.charAt(c);
//                c++;
//            }
//        }
//        return testField;
//    }

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
    // prints game field
    private static void printField(char[][] gameField) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(gameField[i][j]);
            }
            System.out.println();
        }
    }
    //sets initial field after user input char
    private static void updateField(char[][] gameField, String data) {
        int c = 0;
        for (int i = 1; i < 4; i++) {
            for (int j = 2; j < 7; j+=2) {
                if(data.charAt(c) == 'X' || data.charAt(c) == 'O') {
                    gameField[i][j] = data.charAt(c);
                }
                c++;
            }
        }
    }
    //update move X
    private static void updateFieldMoveX(char[][] gamefield, int i, int j) {
        j = j * 2;
        if (i == 1) {
            i = 3;
        } else if (i == 3) {
            i = 1;
        }
        gamefield[i][j] = 'X';
    }

//will get initial field start of phase
    private static String getField(Scanner scan) {
        System.out.print("Enter cells: ");
        return scan.nextLine();

    }
    //gets next proposed move coordinates
    private static String getMove(Scanner scan) {
        System.out.print("Enter the coordinates: ");
        return scan.nextLine();
    }
    //tests getmove
    private static boolean testMove(String move) {
//        System.out.println(move + " " + "length: " + move.length());
        if (Character.isDigit(move.charAt(0))) {
            int a = Integer.parseInt(String.valueOf(move.charAt(0)));
            int b = Integer.parseInt(String.valueOf(move.charAt(2)));
//            System.out.println("convert string to int characters: " + a + " " + b);
            if (a > 3 || a < 1 || b > 3 || b < 1) {
                System.out.println("Coordinates should be from 1 to 3!");
                return true;
            } else if (move.length() > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                return true;
            } else {
                return false;
            }
        } else {
            System.out.println("You should enter numbers!");
            return true;
        }

    }
    private static boolean testCoord(int i, int j, char[][] gameField) {
        if (gameField[i][j] == 'X' || gameField[i][j] == 'O') {
            System.out.println("This cell is occupied! Choose another one!");
            return true;
        } else {
            return false;
        }

    }

    private static char[][] startField() {
        return new char[][]{
                    {'-', '-', '-', '-', '-', '-', '-', '-', '-'},
                    {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                    {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                    {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                    {'-', '-', '-', '-', '-', '-', '-', '-', '-'},
            };
    }
}

