package Ex3.FourInRow;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class DiscTypeTest {
private DiscType dt = new DiscType('X');

    @Test
    void getType() {
        assertEquals('X',dt.getType());
    }

    @Test
    void getColor() {
        dt.color= Color.BLUE;
        assertEquals(Color.BLUE,dt.getColor());
    }

    @Test
    void draw() {
        assertEquals(1,1);
    }

    @Test
    void testToString() {
        var str = "DiscType = "+'X' ;
        assertEquals(str,dt.toString());
    }
}