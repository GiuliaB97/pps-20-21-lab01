package lab01.tdd.strategy;

import java.util.List;
import java.util.Optional;

public class equalsStrategy implements SelectStrategy {
    protected Integer actual_element;
    public equalsStrategy(Integer element) {
        this.actual_element=element;
    }

    @Override
    public boolean apply(int element) {
        return this.actual_element==element;
    }
}
