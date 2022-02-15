package Ex3.FourInRow;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseBoardDecoratorTest {
    private BaseBoardDecorator baseBoardDecorator;
    private Board board;

    @BeforeEach
    void setUp() {
        baseBoardDecorator = new BaseBoardDecorator();
        board = new Board();
    }

    @AfterEach
    void tearDown() {
        baseBoardDecorator = null;
        board = null;
    }

    @Test
    void winningDisk() {
        board.alignDisc(new Position(1,1),new DiscType('X'));
        board.alignDisc(new Position(2,1),new DiscType('X'));
        assertFalse(baseBoardDecorator.winningDisk(new Position(2,1)));
    }

    @Test
    void firstEmptyRow() {
        board.initializeBoard();
        assertEquals(baseBoardDecorator.firstEmptyRow(1),0);
    }

    @Test
    void isColumnFull() {
        board.initializeBoard();
        assertFalse(baseBoardDecorator.isColumnFull(1));
    }
}