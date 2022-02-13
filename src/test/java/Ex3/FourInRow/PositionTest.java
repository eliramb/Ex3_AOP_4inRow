package Ex3.FourInRow;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {
    private Position position;
    int row;
    int col;

    @BeforeEach
    void setUp() {
        position = new Position(row,col);
    }

    @AfterEach
    void tearDown() {
        position = null;
    }

    @Test
    void checkPosition(){
        assertNotNull(position);
    }
}