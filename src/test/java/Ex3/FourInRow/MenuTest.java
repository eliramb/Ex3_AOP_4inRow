package Ex3.FourInRow;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {
    private Menu menu;
    private String optionChoice;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        menu = new Menu("menuTest");
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        menu = null;
    }

    @Test
    public void checkMenu(){
        assertNotNull(menu);
    }

    @Test
    public void printMenu(){
        System.out.print(menu.MenuName);
        assertEquals(menu.MenuName, outContent.toString());}
}