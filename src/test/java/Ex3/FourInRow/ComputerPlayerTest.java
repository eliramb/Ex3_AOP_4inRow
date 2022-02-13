package Ex3.FourInRow;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerPlayerTest {

    private ComputerPlayer computerPlayer;
    private char playerChar;
    @BeforeEach
    void setUp() {
        computerPlayer = new ComputerPlayer(playerChar,new Board());
    }

    @AfterEach
    void tearDown() {
        computerPlayer = null;
    }

    @Test
    public void  checkComputerPlayer(){
        assertNotNull(computerPlayer);
    }
}