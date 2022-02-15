package Ex3.FourInRow;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscFactoryTest {
    private DiscFactory discFactory;
    @BeforeEach
    void setUp() {
        discFactory =new DiscFactory();
    }

    @AfterEach
    void tearDown() {
        discFactory=null;
    }

    @Test
    void checkDiscFactory() {
        assertNull(discFactory.discTypeArray);
    }
}