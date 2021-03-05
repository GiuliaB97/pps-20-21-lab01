package lab01.tdd.strategy;

public interface SelectStrategyAbstractFactory {
    SelectStrategy createConcreteNextStrategyEven(Integer element);
    SelectStrategy createConcreteNextStrategyMultipleOf(Integer element);
    SelectStrategy createConcreteNextStrategyEqual(Integer element);
}
