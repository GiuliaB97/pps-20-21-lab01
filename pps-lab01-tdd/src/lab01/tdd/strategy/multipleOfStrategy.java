package lab01.tdd.strategy;

import java.util.List;
import java.util.Optional;

public class
multipleOfStrategy implements SelectStrategy {
    protected Integer actual_element;

    public multipleOfStrategy(Integer element){
        this.actual_element=element;
    }

    @Override
    public boolean apply(int element) {
        return (element%this.actual_element)==0;
    }
}
