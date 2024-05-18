import java.util.ArrayList;
import java.util.Scanner;

public class GameBoard {
    // character array representing the states of the 9 squares
    // top left is 1 and bottom right is 9
    // '-' is used for unoccupied square, 'X' is for player 1, 'O' is for player 2
    private char[] squareStatuses = new char[9];
    private int activePlayer; // 1 = player, 2 = AI
    private int playerWinState; // 0 = no one has won yet, 1 = player won, 2 = AI won, 3 = tie game
    private int turnCounter = 0;

    // constructor
    public GameBoard() {
        for (int i = 0; i < 9; i++) {
            squareStatuses[i] = '-';
        }
        activePlayer = 1;
        playerWinState = 0;
    }

    // main function for logic and calling other methods
    public void startGame() {
        int square;

        Scanner scnr = new Scanner(System.in);
        // main loop for game
        while (playerWinState == 0) {
            printGameBoard();
            // player's turn
            if (activePlayer == 1) {
                System.out.println("Choose a square by typing a number from 1 to 9:");
                square = scnr.nextInt();

                // check if chosen square is valid
                if (squareStatuses[square - 1] == '-') {
                    setStatus('X', square);
                    turnCounter++;
                    checkWin();
                    activePlayer = 2;
                }
                else {
                    System.out.println("Square has already been selected. Try again.");
                }
            }
            // AI's turn
            else {
                System.out.println("AI is choosing its move...");
                square = randomAI();
                System.out.println("AI has chosen square " + square + ".");

                setStatus('O', square);
                turnCounter++;
                checkWin();
                activePlayer = 1;
            }
        }
        printGameBoard();
        if (playerWinState == 1) {
            System.out.println("The player wins.");
        }
        if (playerWinState == 2) {
            System.out.println("The AI wins.");
        }
        if (playerWinState == 3) {
            System.out.println("The game is a tie.");
        }
    }

    // method for random AI logic
    private int randomAI() {
        ArrayList<Integer> validChoices = new ArrayList<>();
        // add indices of valid choices into array list
        for (int i = 0; i < 9; i++) {
            if (squareStatuses[i] == '-') {
                validChoices.add(i);
            }
        }

        // pick only number if there's only one valid choice
        if (validChoices.size() == 1) {
            return validChoices.get(0) + 1;
        }

        // picking random number if there are more than one valid choices
        int randomPick = (int)(Math.random() * validChoices.size());
        return validChoices.get(randomPick) + 1;
    }

    // method to print the current state of the game board to the console
    private void printGameBoard() {
        System.out.println();
        System.out.println(squareStatuses[0] + "  " + squareStatuses[1] + "  " + squareStatuses[2]);
        System.out.println(squareStatuses[3] + "  " + squareStatuses[4] + "  " + squareStatuses[5]);
        System.out.println(squareStatuses[6] + "  " + squareStatuses[7] + "  " + squareStatuses[8]);
        System.out.println();
    }

    // method to set the value of a square
    public void setStatus(char status, int square) {
        squareStatuses[square - 1] = status;
    }

    // TODO: figure out a way to make this more elegant instead of brute forcing it with a bunch of if statements looking at every possible win condition
    // method to see if anyone has won so far after each move
    private void checkWin() {
        // horizontal win checks
        if (squareStatuses[0] == 'X' && squareStatuses[1] == 'X' && squareStatuses[2] == 'X') {
            playerWinState = 1;
        }
        if (squareStatuses[3] == 'X' && squareStatuses[4] == 'X' && squareStatuses[5] == 'X') {
            playerWinState = 1;
        }
        if (squareStatuses[6] == 'X' && squareStatuses[7] == 'X' && squareStatuses[8] == 'X') {
            playerWinState = 1;
        }

        if (squareStatuses[0] == 'O' && squareStatuses[1] == 'O' && squareStatuses[2] == 'O') {
            playerWinState = 2;
        }
        if (squareStatuses[3] == 'O' && squareStatuses[4] == 'O' && squareStatuses[5] == 'O') {
            playerWinState = 2;
        }
        if (squareStatuses[6] == 'O' && squareStatuses[7] == 'O' && squareStatuses[8] == 'O') {
            playerWinState = 2;
        }
        
        //vertical win checks
        if (squareStatuses[0] == 'X' && squareStatuses[3] == 'X' && squareStatuses[6] == 'X') {
            playerWinState = 1;
        }
        if (squareStatuses[1] == 'X' && squareStatuses[4] == 'X' && squareStatuses[7] == 'X') {
            playerWinState = 1;
        }
        if (squareStatuses[2] == 'X' && squareStatuses[5] == 'X' && squareStatuses[8] == 'X') {
            playerWinState = 1;
        }

        if (squareStatuses[0] == 'O' && squareStatuses[3] == 'O' && squareStatuses[6] == 'O') {
            playerWinState = 2;
        }
        if (squareStatuses[1] == 'O' && squareStatuses[4] == 'O' && squareStatuses[7] == 'O') {
            playerWinState = 2;
        }
        if (squareStatuses[2] == 'O' && squareStatuses[5] == 'O' && squareStatuses[8] == 'O') {
            playerWinState = 2;
        }
        
        //diagonal win checks
        if (squareStatuses[0] == 'X' && squareStatuses[4] == 'X' && squareStatuses[8] == 'X') {
            playerWinState = 1;
        }
        if (squareStatuses[2] == 'X' && squareStatuses[4] == 'X' && squareStatuses[6] == 'X') {
            playerWinState = 1;
        }

        if (squareStatuses[0] == 'O' && squareStatuses[4] == 'O' && squareStatuses[8] == 'O') {
            playerWinState = 2;
        }
        if (squareStatuses[2] == 'O' && squareStatuses[4] == 'O' && squareStatuses[6] == 'O') {
            playerWinState = 2;
        }

        if (playerWinState == 0 && turnCounter == 9) {
            playerWinState = 3;
        }
    }
}
