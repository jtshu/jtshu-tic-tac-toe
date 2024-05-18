public class GameBoard {
    // characters representing the states of the 9 squares
    // top left is 1 and bottom right is 9
    private char status1;
    private char status2;
    private char status3;
    private char status4;
    private char status5;
    private char status6;
    private char status7;
    private char status8;
    private char status9;

    //constructor
    public GameBoard() {
        status1 = '-';
        status2 = '-';
        status3 = '-';
        status4 = '-';
        status5 = '-';
        status6 = '-';
        status7 = '-';
        status8 = '-';
        status9 = '-';
    }

    //method to set the values of a status
    public void setStatus(char status, int square) {
        switch (square) {
            case 1:
                status1 = status;
                break;
            case 2:
                status2 = status;
                break;
            case 3:
                status3 = status;
                break;
            case 4:
                status4 = status;
                break;
            case 5:
                status5 = status;
                break;
            case 6:
                status6 = status;
                break;
            case 7:
                status7 = status;
                break;
            case 8:
                status8 = status;
                break;
            case 9:
                status9 = status;
                break;
            default:
                break;
        }
    }

    //method to output the current state of the game board to the console
    public void printGameBoard() {
        System.out.println(status1 + "  " + status2 + "  " + status3);
        System.out.println(status4 + "  " + status5 + "  " + status6);
        System.out.println(status7 + "  " + status8 + "  " + status9);
    }
}
