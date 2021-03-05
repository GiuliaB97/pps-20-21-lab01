package lab01.tdd.strategy;

import java.util.List;
import java.util.Optional;

public class ConcreteNextFactory implements AbstractFactory{

    @Override
    public SelectStrategy concreteNextStrategyEven(Integer element) {
        return new evenStrategy();
    }

    @Override
    public SelectStrategy ConcreteNextStrategyMultipleOf(Integer element) {
        return new multipleOfStrategy(element);
    }

    @Override
    public SelectStrategy ConcreteNextStrategyEqual(Integer element) {
        return new equalsStrategy(element);
    }
}
