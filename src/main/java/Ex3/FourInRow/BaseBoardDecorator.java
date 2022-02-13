package Ex3.FourInRow;

public class BaseBoardDecorator implements IBoard{

    public IBoard board;
    @Override
    public void DecorateBoard() {

    }

    @Override
    public void printBoard() {

    }

    @Override
    public void alignDisc(Position position, DiscType discType) {

    }

    @Override
    public Board getBoard() {
        return board.getBoard();
    }

    @Override
    public boolean winningDisk(Position position) {
        return false;
    }

    @Override
    public int firstEmptyRow(int col) {
        return 0;
    }

    @Override
    public boolean isColumnFull(int col) {
        return false;
    }
}
