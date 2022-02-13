package Ex3.FourInRow;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game;
    private String playerChoice;
    private Player player;
    private Player player2;
    private IPlayer testCurrentPlayer;

    GameTest() {
    }

    @BeforeEach
    void setUp() {
        game = new Game();
        Board board=new Board();
        player = new Player('O',board);
        player2 = new Player('X',board);
        playerChoice = "1";
    }

    @AfterEach
    void tearDown() {
        game = null;
        player = null;
        player2 = null;
    }

    @Test
    void isInteger() {
        assertTrue(game.isInteger(playerChoice));
    }

    @Test
    void addPlayer() {
        game.AddPlayer(player);
        assertNotNull(game.Players);
    }

    @Test
    void isComputerPlayer() {
        assertFalse(game.isComputerPlayer(player));
    }

    @Test
    void changePlayer() {
        game.AddPlayer(player);
        game.AddPlayer(player2);
        game.currentPlayer= game.Players.get(0);
        testCurrentPlayer = game.Players.get(1);
        game.changePlayer();
        assertNotNull(game.currentPlayer);
        assertEquals(game.currentPlayer,testCurrentPlayer);
        // assertEquals(game.Players.get(1),testCurrentPlayer);
    }

}