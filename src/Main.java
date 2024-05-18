public class Main {
    public static void main(String[] args) {
        //test cases
        GameBoard testBoard = new GameBoard();
        testBoard.setStatus('X',1);
        testBoard.setStatus('O',9);
        testBoard.printGameBoard();
    }
}