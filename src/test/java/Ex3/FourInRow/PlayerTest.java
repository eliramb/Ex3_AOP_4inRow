package Ex3.FourInRow;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private Player player;
    private char playerChar;
    private Board board;
    private Position position;

    @BeforeEach
    void setUp() {
        playerChar = 'X';
        board = new Board();
        position = new Position(1,1);
        player = new Player(playerChar, board);
    }

    @AfterEach
    void tearDown() {
        player = null;
        board = null;
        position = null;
    }

    @Test
    void checkPlayer() {
        assertNotNull(player);

    }
    @Test
    public void alignDisc() {
        board.initializeBoard();
        player.alignDisc(position);
        assertEquals(board.board[1][1],'X');
        assertEquals(player.alignDisc(position),position);
    }
}