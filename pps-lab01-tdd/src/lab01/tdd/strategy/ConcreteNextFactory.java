package lab01.tdd.strategy;

import java.util.List;
import java.util.Optional;

public class ConcreteNextFactory implements AbstractFactory{

    @Override
    public SelectStrategy ConcreteNextStrategyA(List<Optional> list, Optional<Integer> index_element, Optional<Integer> last_element) {
        return new evenStrategy(list, index_element, last_element);
    }

    @Override
    public SelectStrategy ConcreteNextStrategyB(List<Optional> list, Optional<Integer> index_element, Optional<Integer> last_element) {
        return new multipleOfStrategy(list, index_element, last_element);
    }

    @Override
    public SelectStrategy ConcreteNextStrategyC(List<Optional> list, Optional<Integer> index_element, Optional<Integer> last_element) {
        return new equalsStrategy(list, index_element, last_element);
    }
}
