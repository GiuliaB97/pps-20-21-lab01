package lab01.tdd.strategy;

public class evenStrategy implements SelectStrategy {

    @Override
    public boolean apply(int element) {
        return (element%2)==0;
    }
}
