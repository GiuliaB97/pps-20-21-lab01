package lab01.tdd.strategy;

import java.util.List;
import java.util.Optional;

public interface AbstractFactory {
    public SelectStrategy concreteNextStrategyEven(Integer element);
    public SelectStrategy ConcreteNextStrategyMultipleOf(Integer element);
    public SelectStrategy ConcreteNextStrategyEqual(Integer element);
}
