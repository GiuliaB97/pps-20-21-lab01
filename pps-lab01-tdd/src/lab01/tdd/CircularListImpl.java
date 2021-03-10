package lab01.tdd;

import lab01.tdd.CircularList;
import lab01.tdd.Direction;
import lab01.tdd.strategy.SelectStrategy;

import java.util.*;

public class CircularListImpl implements CircularList {
    protected Direction actual_direction;
    protected List<Optional> list;
    protected Optional<Integer> index_element;
    protected Optional<Integer> last_element;
    protected Integer update_quantity;

    public CircularListImpl() {
        this.list = new ArrayList();
        this.last_element=Optional.empty();
        this.index_element=Optional.of(-1);
    }

    @Override
    public void add(int element) {
        list.add(Optional.of(element));
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        updateDirection(Direction.RIGHT);
        return calculateNext();
    }

    @Override
    public Optional<Integer> previous() {
        updateDirection(Direction.LEFT);
        return calculateNext();
    }

    @Override
    public void reset() {
        this.list = new ArrayList();
        last_element=Optional.empty();
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        int count=0;
        if(!list.isEmpty()){
            while(count<list.size()) {
                if (strategy.apply(next().get())) {
                    return last_element;
                }
                count++;
            }
        }
        return Optional.empty();
    }
    private Optional<Integer> calculateNext(){
        if(!list.isEmpty()){
           checkIndexNextElement();
           updateIndexNextElement();
        }
        return last_element.isPresent()? last_element: Optional.empty();
    }
    private void updateIndexNextElement(){
        if(!this.index_element.isEmpty()){
            index_element = Optional.of(index_element.get()+this.update_quantity);
        }else if(index_element.isEmpty()&& last_element.isEmpty()||index_element.isEmpty()&& this.actual_direction.equals(Direction.RIGHT)){
            index_element=Optional.of(0);
        }else{
            index_element=Optional.of(list.size()-1);
        }
        last_element = list.get(index_element.get());
    }

    private void checkIndexNextElement(){
        if(index_element.isPresent()) {
            if (isOutOfBound(list.indexOf(last_element))) {
                index_element = Optional.empty();
            } else {
                index_element = Optional.of(list.indexOf(last_element));
            }
        }
    }

    private boolean isOutOfBound(Integer index) {
        index+=this.update_quantity;
        return index>=list.size()||index<0;
    }

    private void updateDirection(Direction direction){
        this.actual_direction=direction;
        this.update_quantity=this.actual_direction==Direction.RIGHT ? 1:-1;
    }
}