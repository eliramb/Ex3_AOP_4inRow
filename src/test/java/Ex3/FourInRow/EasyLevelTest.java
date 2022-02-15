package Ex3.FourInRow;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EasyLevelTest {

    private EasyLevel easyLevel;
    private Board board;
    Position position;

    @BeforeEach
    void setUp() {
        easyLevel = new EasyLevel();
        board = new Board();
        position = new Position(-1,0);
    }

    @AfterEach
    void tearDown() {
        easyLevel = null;
        board = null;
        position = null;
    }

    @Test
    void computerChoice() {
        board.initializeBoard();
        board.alignDisc(new Position(5,1),new DiscType('X'));
        assertEquals(easyLevel.ComputerChoice(board).row,position.row);
        assertEquals(easyLevel.ComputerChoice(board).col,position.col);
    }
}