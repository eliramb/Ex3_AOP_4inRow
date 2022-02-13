package Ex3.FourInRow;

import org.springframework.stereotype.Component;

@Component
public interface IBoard {
    void DecorateBoard();
    void printBoard();
    void alignDisc(Position position, DiscType discType);
    Board getBoard();
    boolean winningDisk(Position position);
    int firstEmptyRow(int col);
    boolean isColumnFull(int col);
}
