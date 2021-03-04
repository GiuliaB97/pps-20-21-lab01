import lab01.tdd.CircularList;
import lab01.tdd.SelectStrategy;

import java.util.*;

public class CircularListImpl implements CircularList {
    protected List<Optional> list;
    protected Optional<Integer> index_element;
    protected Optional<Integer> last_element;

    public CircularListImpl() {
        this.list = new ArrayList();
        last_element=Optional.empty();
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
        if (last_element.isPresent()) {
            if (outOfBound(list.indexOf(last_element)+1)) {
                last_element=Optional.empty();
                index_element=Optional.of(0);
            }else{
                index_element = Optional.of(list.indexOf(last_element));
            }
        }
        if(last_element.isPresent()){
            int a=index_element.get();
            a++;
            index_element = Optional.of(a);
            last_element = list.get(index_element.get());
        } else if (!Optional.ofNullable(list.get(0)).isEmpty()) {
            last_element = list.get(0);
        }
        return last_element.isPresent()? last_element: Optional.empty();
    }

    @Override
    public Optional<Integer> previous() {
        if (last_element.isPresent()) {
            if (outOfBound(list.indexOf(last_element)-1)) {
                index_element=Optional.of(list.size());
            }else{
                index_element = Optional.of(list.indexOf(last_element));
            }
        }
        if(last_element.isPresent()){
            int a=index_element.get();
            a--;
            index_element = Optional.of(a);
            last_element = list.get(index_element.get());
        } else if (!Optional.ofNullable(list.get(0)).isEmpty()) {
            last_element = list.get(0);
        }
        return last_element.isPresent()? last_element: Optional.empty();
    }

    @Override
    public void reset() {
        this.list = new ArrayList();
        last_element=Optional.empty();
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        return Optional.empty();
    }


    private boolean outOfBound(Integer index) {
        return index>=list.size()|| index<0;
    }
}