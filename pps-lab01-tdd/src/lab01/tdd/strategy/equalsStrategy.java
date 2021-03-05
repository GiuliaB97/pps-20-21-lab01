package lab01.tdd.strategy;

public class equalsStrategy implements SelectStrategy {
    protected Integer actual_element;
    public equalsStrategy(Integer element) {
        this.actual_element=element;
    }

    @Override
    public boolean apply(int element) {
        return this.actual_element.equals(element);
    }
}
