import lab01.tdd.CircularList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {
    private CircularList circularList;

    @BeforeEach
    void beforeAll(){
        circularList = new CircularListImpl();
    }

    @Test
    void testIsEmpty(){
        assertEquals(true, circularList.isEmpty());
    }

    @Test
    void testInitialSize(){
        assertEquals(0, circularList.size());
    }

    @Test
    void testAddElement(){
        this.circularList.add(4);
        assertEquals(1, circularList.size());
        this.circularList.add(3);
        assertEquals(2, circularList.size());
        this.circularList.add(2);
        assertEquals(3, circularList.size());
    }

    @Test
    void testNext(){
        this.circularList.add(4);
        assertFalse(this.circularList.isEmpty());
        assertEquals(Optional.of(4), circularList.next());
        this.circularList.add(3);
        assertEquals(Optional.of(3), circularList.next());
        this.circularList.add(2);
        assertEquals(Optional.of(2), circularList.next());
        assertEquals(Optional.of(4), circularList.next());
    }

    @Test
    void testPrev(){
        this.circularList.add(4);
        this.circularList.add(3);
        this.circularList.add(2);
        assertFalse(this.circularList.isEmpty());
        assertEquals(Optional.of(4), circularList.previous());
        assertEquals(Optional.of(2), circularList.previous());
        assertEquals(Optional.of(3), circularList.previous());
        assertEquals(Optional.of(4), circularList.previous());
    }

    @Test
    void testReset(){
        this.circularList.add(2);
        assertFalse(this.circularList.isEmpty());
        this.circularList.reset();
        assertFalse(!this.circularList.isEmpty());
    }


}
