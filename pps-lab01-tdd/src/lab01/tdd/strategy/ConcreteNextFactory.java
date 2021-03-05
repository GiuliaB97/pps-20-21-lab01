package lab01.tdd.strategy;

public class ConcreteNextFactory implements SelectStrategyAbstractFactory {

    @Override
    public SelectStrategy createConcreteNextStrategyEven(Integer element) {
        return new evenStrategy();
    }

    @Override
    public SelectStrategy createConcreteNextStrategyMultipleOf(Integer element) {
        return new multipleOfStrategy(element);
    }

    @Override
    public SelectStrategy createConcreteNextStrategyEqual(Integer element) {
        return new equalsStrategy(element);
    }
}
