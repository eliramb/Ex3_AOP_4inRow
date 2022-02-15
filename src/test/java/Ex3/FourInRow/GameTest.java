package Ex3.FourInRow;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game;
    private String playerChoice;
    private Player player;
    private Player player2;
    private IPlayer testCurrentPlayer;
    private Menu menu;

    GameTest() {
    }

    @BeforeEach
    void setUp() {
        game = new Game();
        Board board=new Board();
        player = new Player('O',board);
        player2 = new Player('X',board);
        playerChoice = "1";
        menu = new Menu("menu");

    }

    @AfterEach
    void tearDown() {
        game = null;
        player = null;
        player2 = null;
    }

    @Test
    void checkGame() {
        assertNotNull(game);
    }

    @Test
    public void AddMenu(){
        game.AddMenu(menu);
        assertTrue(game.gameMenu.contains(menu));
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
    void play() {
        Board board;
        //IBoard
         //       2 player
         //   players com us
          //      current player= computer;
        assertFalse(game.play());
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