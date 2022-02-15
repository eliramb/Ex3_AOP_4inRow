package Ex3.FourInRow;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerPlayerTest {

    private ComputerPlayer computerPlayer;
    private char playerChar;
    private Board board;
    private Position position;

    @BeforeEach
    void setUp() {
        board = new Board();
        position = new Position(1,1);
        computerPlayer = new ComputerPlayer(playerChar,board);
    }

    @AfterEach
    void tearDown() {
        computerPlayer = null;
        board = null;
        position = null;
    }

    @Test
    public void  checkComputerPlayer(){
        assertNotNull(computerPlayer);
    }

    @Test
    public void alignDisc(){
        board.initializeBoard();
        computerPlayer.alignDisc(position);
        assertEquals(board.board[1][1],playerChar);
        assertEquals(computerPlayer.alignDisc(position),position);
    }
}