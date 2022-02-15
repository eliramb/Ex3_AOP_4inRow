package Ex3.FourInRow;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game;
    private String playerChoice;
    private Player player;
    private ComputerPlayer player2;
    private IPlayer testCurrentPlayer;
    private Menu menu;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private PrintStream originalOut = System.out;

    GameTest() {
    }

    @BeforeEach
    void setUp() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        game = context.getBean(Game.class);//new Game();
        Board board=new Board();
        player = new Player('O',board);
        player2 = new ComputerPlayer('X',board);
        playerChoice = "1";
        menu = new Menu("menu");
        game.gameMenu.add(menu);
        game.Players.add(player);
        game.Players.add(player2);
        System.setOut(new PrintStream(outContent));



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
    public void printMenu(){
        game.printMenu();
       // System.out.print(menu.MenuName);
        assertEquals("0. Exit\r\n" +
                "1. play against friend\r\n" +
                "2. play against computer\r\n" +
                "menu\r\n" +
                "Please choose an option:", outContent.toString());}


    @Test
    void isInteger() {
        assertTrue(game.isInteger(playerChoice));
        assertFalse(game.isInteger("string"));
        assertFalse(game.isInteger(null));

    }

    @Test
    void addPlayer() {
        game.AddPlayer(player);
        assertNotNull(game.Players);
    }

    @Test
    void play() {

        game.currentPlayer = game.Players.get(0);
        game.isTest=true;
        assertFalse(game.play());
    }
    @Test
    void playComputer() {
        game.computerplays=true;
        game.currentPlayer = game.Players.get(1);
        game.isTest=true;
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

    @Test
    void userChoice(){
        game.isTest=true;
        game.testChoise="2";
       assertEquals(game.userChoice(),2);
    }

    @Test
    void userChoice1(){
        game.isTest=true;
        game.testChoise="1";
       assertEquals(game.userChoice(),1);
    }

    @Test
    void userChoice0(){
        game.isTest=true;
        game.testChoise="0";
       assertEquals(game.userChoice(),0);
    }
}