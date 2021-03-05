package lab01.tdd.strategy;

import java.util.List;
import java.util.Optional;

public class evenStrategy implements SelectStrategy {
    protected List<Optional> list;
    protected Optional<Integer> index_element;
    protected Optional<Integer> last_element;
    protected Integer resulting_element;

    public evenStrategy(List<Optional> list, Optional<Integer> index_element, Optional<Integer> last_element) {
        this.list = list;
        this.index_element = index_element;
        this.last_element = last_element;
        this.resulting_element=-1;
    }

    private void next(){
        for(int i=index_element.get(); i<list.size(); i++){
            Integer element=Integer.parseInt(String.valueOf(list.get(i)));
            if((element%2)==0){
                this.resulting_element=element;
            }
        }
    }

    @Override
    public boolean apply(int element) {
        next();
        return this.resulting_element==element;
    }
}
