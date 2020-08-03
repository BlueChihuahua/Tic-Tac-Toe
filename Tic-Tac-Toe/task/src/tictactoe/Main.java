package tictactoe;

import java.util.Scanner;

public class Main {

    private static char turn = 'X';

    public static void main(String[] args) {
        String board = "_________"; //initial empty playing field
        print(board);
        boolean gameOver = false;
        while (!gameOver) {
            boolean isValid = false;
            while (!isValid) {
                System.out.print("Enter the Coordinates: ");
                String move = new Scanner(System.in).nextLine();
                ValidMoveStatus valid = check(move, board);
                switch (valid) {
                    case NOTNUMBER:
                        System.out.println(ValidMoveStatus.NOTNUMBER);
                        break;
                    case OUTSIDERANGE:
                        System.out.println(ValidMoveStatus.OUTSIDERANGE);
                        break;
                    case OCCUPIED:
                        System.out.println(ValidMoveStatus.OCCUPIED);
                        break;
                    case VALID:
                        //swap turns between players starting with X
                        if (Main.turn == 'X') {
                            board = updateBoardX(board, move);
                            print(board);
                            Main.turn = changePlayer(turn);
                            GameState gameState = gameComplete(board);
                            switch (gameState) {
                                case DRAW:
                                    System.out.println(GameState.DRAW);
                                    gameOver = true;
                                    break;
                                case OWINS:
                                    System.out.println(GameState.OWINS);
                                    gameOver = true;
                                    break;
                                case XWINS:
                                    System.out.println(GameState.XWINS);
                                    gameOver = true;
                                    break;
                                default:
                                    break;
                            }
                        } else if (Main.turn == 'O') {
                            board = updateBoardO(board, move);
                            print(board);
                            Main.turn = changePlayer(turn);
                            GameState gameState = gameComplete(board);
                            switch (gameState) {
                                case DRAW:
                                    System.out.println(GameState.DRAW);
                                    gameOver = true;
                                    break;
                                case OWINS:
                                    System.out.println(GameState.OWINS);
                                    gameOver = true;
                                    break;
                                case XWINS:
                                    System.out.println(GameState.XWINS);
                                    gameOver = true;
                                    break;
                                default:
                                    break;
                            }
                        }
                        isValid = true;
                        break;
                    default:
                        break;
                }
            }
        }
    }

    // decide who's turn it is
    private static char changePlayer(char turn) {
        Main.turn = turn;
        if (turn == 'X') {
            return 'O';
        } else {
            return 'X';
        }
    }

    //check move -> returns invalid move, occupied move, or valid move
    private static ValidMoveStatus check(String move, String board) {
        ValidMoveStatus check = error(move);
        if (check == ValidMoveStatus.NOTNUMBER) {
            return check;
        } else if (check == ValidMoveStatus.OUTSIDERANGE) {
            return check;
        } else {
            check = notOccupiedCheck(move, board);
            return check;
        }
    }

    //checks invalid move entry
    private static ValidMoveStatus error(String move) {
         if (!Character.isDigit(move.charAt(0))) {
            return ValidMoveStatus.NOTNUMBER;
        }
        int a = Integer.parseInt(String.valueOf(move.charAt(0)));
        int b = Integer.parseInt(String.valueOf(move.charAt(2)));
        if (a > 3 || a < 1 || b > 3 || b < 1) {
            return ValidMoveStatus.OUTSIDERANGE;
        } else return ValidMoveStatus.UNKNOWN;
    }

    // checks if move space is occupied or valid
    private static ValidMoveStatus notOccupiedCheck(String move, String board) {
        char[][] boardArray = getChars(board);
        int b = Integer.parseInt(String.valueOf(move.charAt(0))) - 1;
        int a = Integer.parseInt(String.valueOf(move.charAt(2))) - 1;
        if (a == 0) {
            a = 2;
        } else if (a == 2) {
            a = 0;
        }
        if (boardArray[a][b] == 'X' || boardArray[a][b] == 'O') {
            return ValidMoveStatus.OCCUPIED;
        } else return ValidMoveStatus.VALID;
    }

    // creates array
    private static char[][] getChars(String board) {
        char[][] boardArray = new char[3][3];
        int c = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardArray[i][j] = board.charAt(c);
                c++;
            }
        }
        return boardArray;
    }

    //updates the board string with X move when move is valid
    private static String updateBoardX(String board, String move) {
        char[][] boardArray = getChars(board);
        int b = Integer.parseInt(String.valueOf(move.charAt(0))) - 1;
        int a = Integer.parseInt(String.valueOf(move.charAt(2))) - 1;
        if (a == 0) {
            a = 2;
        } else if (a == 2) {
            a = 0;
        }
        boardArray[a][b] = 'X';
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                result.append(boardArray[row][col]);
            }
        }
        return String.valueOf(result);
    }

    //updates the board string with O move when move is valid
    private static String updateBoardO(String board, String move) {
        char[][] boardArray = getChars(board);
        int b = Integer.parseInt(String.valueOf(move.charAt(0))) - 1;
        int a = Integer.parseInt(String.valueOf(move.charAt(2))) - 1;
        if (a == 0) {
            a = 2;
        } else if (a == 2) {
            a = 0;
        }
        boardArray[a][b] = 'O';
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                result.append(boardArray[row][col]);
            }
        }
        return String.valueOf(result);
    }

    //print board from board string
    private static void print(String board) {
        //a > b ? a : b
        System.out.println("---------");
        System.out.printf("| %c %c %c |%n", (board.charAt(0) == '_' ? ' ' : board.charAt(0)), (board.charAt(1) == '_' ? ' ' : board.charAt(1)), (board.charAt(2) == '_' ? ' ' : board.charAt(2)));
        System.out.printf("| %c %c %c |%n", (board.charAt(3) == '_' ? ' ' : board.charAt(3)), (board.charAt(4) == '_' ? ' ' : board.charAt(4)), (board.charAt(5) == '_' ? ' ' : board.charAt(5)));
        System.out.printf("| %c %c %c |%n", (board.charAt(6) == '_' ? ' ' : board.charAt(6)), (board.charAt(7) == '_' ? ' ' : board.charAt(7)), (board.charAt(8) == '_' ? ' ' : board.charAt(8)));
        System.out.println("---------");
    }

    //checks if a game is complete
    private static GameState gameComplete(String board) {
        GameState xWins = xWinsCheck(board);
        if (xWins == GameState.XWINS) return GameState.XWINS;
        GameState oWins = oWinsCheck(board);
        if (oWins == GameState.OWINS) return GameState.OWINS;
        GameState gameState = checkDraw(board);
        if (gameState == GameState.DRAW) {
            return GameState.DRAW;
        } else return GameState.NOTFINISHED;
    }

    private static GameState checkDraw(String board) {
        char[][] boardArray = getChars(board);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (boardArray[i][j] == '_') {
                    return GameState.NOTFINISHED;
                }
            }
        }
        return GameState.DRAW;

    }

    private static GameState xWinsCheck(String board) {
        char[][] boardArray = getChars(board);
        //horizontal
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 1; j++) {
                if (boardArray[i][j] == 'X' && boardArray[i][j + 1] == 'X' && boardArray[i][j + 2] == 'X') {
                    return GameState.XWINS;
                }
            }
        }
        //vertical
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 1; i++) {
                if (boardArray[i][j] == 'X' && boardArray[i + 1][j] == 'X' && boardArray[i + 2][j] == 'X') {
                    return GameState.XWINS;
                }
            }
        }
        //diagonal
        if (boardArray[0][0] == 'X' && boardArray[1][1] == 'X' && boardArray[2][2] == 'X') {
            return GameState.XWINS;
        }
        if (boardArray[2][0] == 'X' && boardArray[1][1] == 'X' && boardArray[0][2] == 'X') {
            return GameState.XWINS;
        }
        return GameState.UNKNOWN;
    }

    private static GameState oWinsCheck(String board) {
        char[][] boardArray = getChars(board);
        //horizontal
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 1; j++) {
                if (boardArray[i][j] == 'O' && boardArray[i][j + 1] == 'O' && boardArray[i][j + 2] == 'O') {
                    return GameState.OWINS;
                }
            }
        }
        //vertical
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 1; i++) {
                if (boardArray[i][j] == 'O' && boardArray[i + 1][j] == 'O' && boardArray[i + 2][j] == 'O') {
                    return GameState.OWINS;
                }
            }
        }
        //diagonal
        if (boardArray[0][0] == 'O' && boardArray[1][1] == 'O' && boardArray[2][2] == 'O') {
            return GameState.OWINS;
        }
        if (boardArray[2][0] == 'O' && boardArray[1][1] == 'O' && boardArray[0][2] == 'O') {
            return GameState.OWINS;
        }
        return GameState.UNKNOWN;
    }

    enum ValidMoveStatus {
        VALID(""),
        OCCUPIED("This cell is occupied! Choose another one!"),
        NOTNUMBER("You should enter numbers!"),
        OUTSIDERANGE("Coordinates should be from 1 to 3!"),
        UNKNOWN("");
        private final String msg;

        ValidMoveStatus(String msg) {
            this.msg = msg;
        }

        @Override
        public String toString() {
            return msg;
        }
    }

    enum GameState {
        NOTFINISHED(""),
        DRAW("Draw"),
        XWINS("X wins"),
        OWINS("O wins"),
        UNKNOWN("");
        private final String msg;

        GameState(String msg) {
            this.msg = msg;
        }

        @Override
        public String toString() {
            return msg;
        }


    }
}


