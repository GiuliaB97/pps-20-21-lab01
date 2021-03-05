import lab01.tdd.CircularList;
import lab01.tdd.strategy.ConcreteNextFactory;
import lab01.tdd.strategy.SelectStrategy;
import lab01.tdd.strategy.SelectStrategyAbstractFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class StrategyTest {
    private CircularList circularList;
    private SelectStrategyAbstractFactory selectStrategyFactory;
    @BeforeEach
    void beforeAll(){
        this.circularList = new CircularListImpl();
        this.selectStrategyFactory = new ConcreteNextFactory();
    }

    @Test
    void testStrategyEven(){
        this.circularList.add(3);
        this.circularList.add(2);

        assertNotEquals(Optional.of(3), circularList.next(this.selectStrategyFactory.createConcreteNextStrategyEven(3)));
        assertEquals(Optional.of(2), circularList.next(this.selectStrategyFactory.createConcreteNextStrategyEven(2)));
        assertNotEquals(Optional.of(3), circularList.next(this.selectStrategyFactory.createConcreteNextStrategyEven(3)));
    }

    @Test
    void testStrategyEqual(){
        this.circularList.add(3);
        this.circularList.add(2);

        assertEquals(Optional.of(3), circularList.next(this.selectStrategyFactory.createConcreteNextStrategyEqual(3)));
        assertEquals(Optional.of(2), circularList.next(this.selectStrategyFactory.createConcreteNextStrategyEqual(2)));
        assertEquals(Optional.of(3), circularList.next(this.selectStrategyFactory.createConcreteNextStrategyEqual(3)));
    }
    @Test
    void testStrategyMultiple(){
        this.circularList.add(6);
        this.circularList.add(8);

        assertEquals(Optional.of(6), circularList.next(this.selectStrategyFactory.createConcreteNextStrategyMultipleOf(3)));
        assertEquals(Optional.of(8), circularList.next(this.selectStrategyFactory.createConcreteNextStrategyMultipleOf(2)));
        assertEquals(Optional.of(6), circularList.next(this.selectStrategyFactory.createConcreteNextStrategyMultipleOf(3)));
    }
}
