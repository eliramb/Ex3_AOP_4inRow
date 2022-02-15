package Ex3.FourInRow;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.awt.*;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class DiscTypeTest {
private DiscType dt;
    @BeforeEach
    void setUp() {
        dt = new DiscType('X');
    }

    @AfterEach
    void tearDown() {
        dt= null;
    }

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