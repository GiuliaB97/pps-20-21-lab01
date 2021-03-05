package lab01.tdd.strategy;

import java.util.List;
import java.util.Optional;

public interface AbstractFactory {
    public SelectStrategy ConcreteNextStrategyA(List<Optional> list, Optional<Integer> index_element, Optional<Integer> last_element);
    public SelectStrategy ConcreteNextStrategyB(List<Optional> list, Optional<Integer> index_element, Optional<Integer> last_element);
    public SelectStrategy ConcreteNextStrategyC(List<Optional> list, Optional<Integer> index_element, Optional<Integer> last_element);
}
